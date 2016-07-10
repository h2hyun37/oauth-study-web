package com.h2hyun37.biz.java.chat.gui;

//////////////////P2PServer.java //////////////////////////
import java.net.*;
import java.util.*;

public class P2PServer extends Thread {
	Vector UserList;
	ServerSocket server;

	public P2PServer() {
		super();
		UserList = new Vector();
	}

	public void waitClient() {
		try {
			server = new ServerSocket(9831);
			System.out.println("접속 대기중입니다.");
		} catch(Exception e) { return; }
		while(true) {
			Socket socket;
			try {
				socket = server.accept();
				User user = new User(socket);
				System.out.println(user.getIp() + "/" + user.getId() + "/접속");
				broadcast(user.getIp() + "/" + user.getId() + "/접속");
				for (int j=0; j < UserList.size() ; j++) {
					User temp = (User) UserList.get(j);
					user.sendMessage(temp.getIp() + "/" + temp.getId() + "/접속");
				}

				UserList.add(user);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void run() {
		while(true) {
			for (int i=0; i < UserList.size(); i++) {
				User user = (User) UserList.get(i);
				if (!user.isActive()) {
					UserList.remove(i);
					System.out.println(user.getIp() + "/" + user.getId() + "/해제");
					broadcast(user.getIp() + "/" + user.getId() + "/해제");
					break;
				}
			}
			try {
				Thread.sleep(500);
			} catch(Exception e) {}
		}
	}


	public void broadcast(String msg) {
		for (int j = 0; j < UserList.size(); j++) {
			User user = (User) UserList.get(j);
			user.sendMessage(msg);
		}
	}

	public static void main(String args[]) {
		P2PServer server = new P2PServer();
		server.start();
		server.waitClient();
	}

}
