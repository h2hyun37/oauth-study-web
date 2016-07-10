package com.h2hyun37.biz.java.chat.ver1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {

	private ServerSocket serverSocket;
	// private Socket socket;

	private int port = 9999;

	private BufferedReader in;

	public static void main(String[] args) {

		Thread t = new Thread(new ChatServer());
		t.start();

	}

	@Override
	public void run() {

		if (serverSocket == null) {
			try {
				serverSocket = new ServerSocket(port);
			} catch (IOException e) {
				System.out.println("new ServerSocket() failed");
				e.printStackTrace();
			}
		}

		while (true) {

			Socket socket = null;
			try {
				System.out.println("waiting for connection...");
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "로부터 연결요청 받음");

				InputStream in = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String buffer = null;

				while ((buffer = br.readLine()) != null) {
					System.out.println("input message : " + buffer);
				}

				br.close();
				in.close();
				socket.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}