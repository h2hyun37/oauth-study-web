package com.h2hyun37.biz.java.chatGui;

/////////////////////User.java//////////////////////////////

import java.net.*;
import java.io.*;

public class User {
	Socket socket;
	String ip;
	String id;
	PrintWriter out;
	BufferedReader in;

	public User(Socket socket) throws Exception {
		this.socket = socket;
		socket.setSoTimeout(100);
		ip = socket.getInetAddress().getHostAddress();
		out = new PrintWriter(new PrintStream(socket.getOutputStream()));
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		id = in.readLine();
	}

	public String getIp() {
		return ip;
	}

	public String getId() {
		return id;
}

	public void sendMessage(String msg) {
		out.println(msg);
		out.flush();
	}

	public boolean isActive() {
		try {
			String temp = in.readLine();
			return true;
		} catch(SocketTimeoutException ste){
			return true;
		} catch(Exception e){
			return false;
		}
	}
}
