package com.h2hyun37.biz.java.chat.ver1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient implements Runnable {

	// private ServerSocket serverSocket;
	private Socket socket;

	private String ip = "localhost";
	private int port = 9999;

	private BufferedReader in;
	private BufferedWriter out;

	private BufferedReader userInputReader;

	public static void main(String[] args) {

		Thread t = new Thread(new ChatClient());
		t.start();

	}

	@Override
	public void run() {

		System.out.println("server ip, port : " + ip + "," + port);

		try {
			socket = new Socket(ip, port);

			OutputStream os = socket.getOutputStream();
			out = new BufferedWriter(new OutputStreamWriter(os));

			InputStream is = socket.getInputStream();
			in = new BufferedReader(new InputStreamReader(is));

			userInputReader = new BufferedReader(new InputStreamReader(System.in));


			String str = null;
			while (true) {
				str = userInputReader.readLine();

				out.write(str);
				out.newLine();
				out.flush();
			}


		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				userInputReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				out.close();
			} catch (IOException e) {
			}

			try {
				socket.close();
			} catch (IOException e) {
			}

		}


	}

	// public void run2() {
	//
	// if (serverSocket == null) {
	// try {
	// serverSocket = new ServerSocket(port);
	// } catch (IOException e) {
	// System.out.println("new ServerSocket() failed");
	// e.printStackTrace();
	// }
	// }
	//
	// while (true) {
	//
	// Socket socket = null;
	// try {
	// socket = serverSocket.accept();
	// System.out.println(socket.getInetAddress() + "로부터 연결요청 받음");
	//
	// InputStream in = socket.getInputStream();
	// BufferedReader br = new BufferedReader(new InputStreamReader(in));
	// String buffer = null;
	//
	// while ((buffer = br.readLine()) != null) {
	// System.out.println("input message : " + buffer);
	// }
	//
	// br.close();
	// in.close();
	// socket.close();
	//
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	//
	// }

}