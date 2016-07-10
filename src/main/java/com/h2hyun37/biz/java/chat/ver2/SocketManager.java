package com.h2hyun37.biz.java.chat.ver2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * SocketManager
 * 
 * 생성시 넘겨받은 socket을 이용하여 I/O stream 생성.
 * 
 * Input쓰레드 , Output쓰레드 생성하여 각각 stream 을 넘겨준다.
 * 
 * 두 개의 쓰레드가 모두 종료되면 stream close 처리, socket close 처리 후 종료.
 * 
 * 
 * @author hyunho
 *
 */
class SocketManager implements Runnable {

    String threadName = null;

    Socket socket = null;

    DataInputStream in = null;
    DataOutputStream out = null;

    public SocketManager(Socket socket) {
        this.socket = socket;
    }

    public void initStream() throws IOException {
	System.out.println("[" + threadName + "] : initialize I/O streams");

	in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void closeStream() {
	try {
	    if (in != null) {
		System.out.println("[" + threadName + "] : close input stream");
		in.close();
		in = null;
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

	try {
	    if (out != null) {
		System.out.println("[" + threadName + "] : close output stream");
		out.close();
		out = null;
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void closeSocket() {
	try {
	    if (socket != null) {
		System.out.println("[" + threadName + "] : close socket");
		socket.close();
		socket = null;
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void run() {
	threadName = Thread.currentThread().getName();

	try {
	    initStream();

	    Thread t1 = new Thread(new MessageSenderThread(this, out), "MessageSenderThread");
	    Thread t2 = new Thread(new MessageReceiverThread(this, in), "MessageReceiverThread");

	    t2.start();
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e1) {
	    }
	    t1.start();

	    try {
		System.out.println("[" + threadName + "] : t1.join() start");
		t1.join();
		System.out.println("[" + threadName + "] : t2.join() start");
		t2.join();
		System.out.println("[" + threadName + "] : join() finished");

	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	} catch (IOException e) {
	    e.printStackTrace();

	} finally {
	    closeStream();
	    closeSocket();
	}

    }

}