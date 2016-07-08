package com.h2hyun37.biz.java.ioTest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleInputTest {

	public static void main(String[] args) {

		ConsoleInputTest stdinTest = new ConsoleInputTest();
		stdinTest.runTest();

	}

	public void testInputStream(InputStream is) {

		try {
			System.out.println("========================================");
			System.out.print("InputStream : ");
			int n1 = is.read();
			System.out.println("int : [" + n1 + "]");

			byte[] byteBuf = new byte[255];
			System.out.print("InputStream : ");
			int n2 = is.read(byteBuf);
			System.out.println("int : [" + n2 + "]");

			StringBuilder sb = new StringBuilder();
			for (byte b : byteBuf) {
				sb.append(b + ",");
			}
			System.out.println(sb.toString());
			System.out.println("========================================");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void testInputStreamReader(InputStreamReader reader) {

		try {
			System.out.println("========================================");
			System.out.print("Reader : ");
			int n1 = reader.read();
			System.out.println("int : [" + n1 + "]");

			char[] charBuf = new char[255];
			System.out.print("Reader : ");
			int n2 = reader.read(charBuf);
			System.out.println("int : [" + n2 + "]");

			System.out.println("n21 : [" + String.valueOf(charBuf) + "]");
			System.out.println("========================================");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void testBufferedReader(BufferedReader reader) {

		try {
			System.out.println("========================================");
			System.out.print("Reader : ");
			String str1 = reader.readLine();
			System.out.println("String : [" + str1 + "]");

			char[] charBuf = new char[255];
			System.out.print("Reader : ");
			int n2 = reader.read(charBuf);
			System.out.println("int : [" + n2 + "]");

			System.out.println("n21 : [" + String.valueOf(charBuf) + "]");
			System.out.println("========================================");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void runTest() {

		// InputStream
		BufferedInputStream bis1 = new BufferedInputStream(System.in);

		// Reader
		InputStreamReader isr1 = new InputStreamReader(System.in);
		InputStreamReader isr2 = new InputStreamReader(new BufferedInputStream(System.in));

		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		testInputStream(bis1);
		testInputStreamReader(isr1);
		testInputStreamReader(isr2);
		testBufferedReader(br1);

		try {
			System.out.println("bis1.close()");
			bis1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("isr1.close()");
			isr1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("isr2.close()");
			isr2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("br1.close()");
			br1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
