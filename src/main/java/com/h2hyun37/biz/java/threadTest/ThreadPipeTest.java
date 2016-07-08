package com.h2hyun37.biz.java.threadTest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 스레드 간 통신 테스트.
 *
 * 메인 스레드 : PipedInputStream, PipedOutputStream 생성 및 연결. 스레드1,2 생성. stream close 처리
 *
 * PipedOutThread : 사용자 입력을 받아서 파이프에 write
 *
 * PipedInThread : 파이프에서 read 해서 console 에 출력
 *
 * --> 결국은 Queue 를 이용한 스레드간 통신임. 큐의 형태가 PipedInputStream/PipedOutputStream 일뿐.
 *
 * @author 1001065
 *
 */
public class ThreadPipeTest {

	/**
	 * 프로그램 entry point 및 파이프 생성, 스레드 생성, 전체 실행, 파이프 클로징 등.
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		String threadName = Thread.currentThread().getName();


		PipedInputStream pipeIn = new PipedInputStream();
		PipedOutputStream pipeOut = new PipedOutputStream();

		try {
			pipeIn.connect(pipeOut);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		Thread th1 = new Thread(new PipedOutThread(pipeOut), "PipedOutThread");
		Thread th2 = new Thread(new PipedInThread(pipeIn), "PipedInThread");
		th1.start();
		th2.start();

		try {
			th1.join();
			th2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("[" + threadName + "] : pipeIn.close();");
			pipeIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("[" + threadName + "] : pipeOut.close();");
			pipeOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("[" + threadName + "] : finished");

	}


	/**
	 *
	 * 사용자 입력을 받아 파이프에 write하는 스레드
	 *
	 * @author 1001065
	 *
	 */
	static class PipedOutThread implements Runnable {

		PipedOutputStream pipeOut;

		BufferedInputStream reader = null;
		String threadName = null;

		public PipedOutThread(PipedOutputStream pipeOut) {
			this.pipeOut = pipeOut;
		}

		@Override
		public void run() {

			int n;
			byte[] bytebuf = new byte[255];
			reader = new BufferedInputStream(System.in);
			threadName = Thread.currentThread().getName();

			try {

				while (true) {
					System.out.println("[" + threadName + "] User Input : ");
					n = reader.read(bytebuf);
					// String str = new String(bytebuf);

					if (n == -1) {
						break;
					}

					System.out.println("[" + threadName + "] send input to other thread...");
					pipeOut.write(bytebuf);

				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					System.out.println(getClass().getName() + " : reader.close()");
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * 다른 스레드에서 입력을 받아 stdout 으로 출력하는 스레드
	 *
	 *
	 * @author 1001065
	 *
	 */
	static class PipedInThread implements Runnable {

		PipedInputStream pipeIn;

		String threadName = null;

		public PipedInThread(PipedInputStream pipeIn) {
			this.pipeIn = pipeIn;
			}

		@Override
		public void run() {

			int n;
			byte[] bytebuf = new byte[255];
			threadName = Thread.currentThread().getName();

			try {

				while (true) {
					n = pipeIn.read(bytebuf);

					if (n == -1) {
						break;
					}

					String str = new String(bytebuf);

					System.out.println("[" + threadName + "] received : " + str);

				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
