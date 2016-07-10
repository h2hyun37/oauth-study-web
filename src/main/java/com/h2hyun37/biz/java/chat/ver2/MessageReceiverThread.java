package com.h2hyun37.biz.java.chat.ver2;

import java.io.DataInputStream;
import java.io.IOException;


/**
 * MessageReceiverThread
 * 
 * 생성시 InputStream을 넘겨 받아
 * 
 * InputStream(즉 채팅 상대방)에게 메시지 받으면 화면에 출력
 * 
 * 종료시 stream close 처리.
 * 
 * @author hyunho
 *
 */
class MessageReceiverThread implements Runnable {

    String threadName = null;

    DataInputStream in;

    SocketManager manager;

    public MessageReceiverThread(SocketManager manager, DataInputStream in) {
	this.manager = manager;
	this.in = in;
    }

    @Override
    public void run() {
	threadName = Thread.currentThread().getName();


	String buffer = null;

	try {
	    while (true) {
		System.out.println("[" + threadName + "] waiting for message");
		buffer = in.readUTF();
		if (buffer == null || "bye".equals(buffer)) {
		    System.out.println("[" + threadName + "] break;");
		    break;
		}
		System.out.println("[" + threadName + "] received message : " + buffer);
	    }

	} catch (IOException e) {
	    e.printStackTrace();

	} finally {
	    manager.closeStream();
	}
    }

}