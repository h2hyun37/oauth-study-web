package com.h2hyun37.biz.java.chat.ver2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * MessageSenderThread
 * 
 * 생성시 OutputStream을 넘겨받고,
 * 
 * 사용자에게 입력(System.in)을 받아 OutputStream (즉 채팅 상대방)으로 메시지 write
 * 
 * 종료시 stream close 처리.
 * 
 * @author hyunho
 *
 */
class MessageSenderThread implements Runnable {

    String threadName = null;

    DataOutputStream out;

    SocketManager manager;

    public MessageSenderThread(SocketManager manager, DataOutputStream out) {
	this.manager = manager;
	this.out = out;
    }

    @Override
    public void run() {
	threadName = Thread.currentThread().getName();

	BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
	String buffer = null;

	try {
	    while (true) {
		System.out.print("[" + threadName + "] input message (type 'bye' to end the chat) : ");
		buffer = consoleIn.readLine();

		if (buffer == null) {
		    break;
		}

		out.writeUTF(buffer);
		out.flush();

		if ("bye".equals(buffer)) {
		    break;
		}
	    }

	} catch (IOException e) {
	    e.printStackTrace();

	} finally {
	    manager.closeStream();
	}
    }
}