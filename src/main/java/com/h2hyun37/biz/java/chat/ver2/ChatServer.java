package com.h2hyun37.biz.java.chat.ver2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ChatServer
 * 
 * ServerSocket 을 열어서 Client 접속을 받는다.
 * socket이 accept되면 SocketManager 쓰레드 생성하여 접속된 socket을 넘겨주고 
 * 다음 접속을 대기 
 * 
 * @author hyunho
 *
 */
public class ChatServer implements Runnable {

    String threadName = null;

    ServerSocket listen;
    String ip;
    int port = 9999;

    public void initServerSocket() throws IOException {

	if (listen == null) {

	    String logMsg = null;
	    logMsg = String.format("[%s] trying to initiate server socket", threadName);
	    System.out.println(logMsg);

	    listen = new ServerSocket(port);

	    logMsg = String.format("[%s] server socket initialization complete", threadName);
	    System.out.println(logMsg);

	}

    }

    public void closeServerSocket() {
	if (!listen.isClosed()) {
	    try {
		listen.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

    @Override
    public void run() {
	threadName = Thread.currentThread().getName();

	try {
	    initServerSocket();

	    Socket socket = null;

	    while (true) {
		System.out.println("[" + threadName + "] waiting for connection");
		socket = listen.accept();

		InetAddress address = socket.getInetAddress();
		int clientPort = socket.getPort();
		System.out.println(
			"[" + threadName + "] connection accepted. address : " + address + ", port : " + clientPort);

		Thread t = new Thread(new SocketManager(socket), "SocketManager");

		t.start();
	    }


	} catch (IOException e1) {
	    e1.printStackTrace();
	} finally {
	    closeServerSocket();
	}


    }

    public static void main(String[] args) {

	Thread t = new Thread(new ChatServer(), "ChatServer");

	t.start();
    }

}
