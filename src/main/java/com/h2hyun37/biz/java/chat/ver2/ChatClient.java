package com.h2hyun37.biz.java.chat.ver2;

import java.io.IOException;
import java.net.Socket;

/**
 * ChatClient
 * 
 * ChatServer 에 접속하여 연결이 생성되면 SocketManager 쓰레드 생성하여 접속된 socket을 넘겨준다.
 * 
 * 
 * 
 * @author hyunho
 *
 */
public class ChatClient implements Runnable {

    String threadName = null;

    String serverIp = "localhost";
    int serverPort = 9999;

    Socket socket = null;

    public void initSocket() throws IOException {

	String logMsg = null;

	logMsg = String.format("[%s] trying to initiate socket", threadName);
	System.out.println(logMsg);

	socket = new Socket(serverIp, serverPort);

	logMsg = String.format("[%s] ip : %s, port : %s", threadName, serverIp, serverPort);
	System.out.println(logMsg);
    }

    public void closeSocket() {
	try {
	    System.out.println("[" + threadName + "] : trying to socket.close()");
	    socket.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void run() {

	threadName = Thread.currentThread().getName();

	try {
	    initSocket();

	    Thread t = new Thread(new SocketManager(socket), "SocketManager");
	    t.start();

	    try {
		System.out.println("[" + threadName + "] : t.join() start");
		t.join();
		System.out.println("[" + threadName + "] : t.join() finished");

	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	} catch (IOException e) {
	    e.printStackTrace();

	}


    }

    public static void main(String[] args) {

	Thread t = new Thread(new ChatClient(), "ChatClient");

	t.start();

    }

}
