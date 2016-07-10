package com.h2hyun37.biz.java.chat.gui;

////////////////////ServerInfo.java /////////////////////////////
import java.net.*;
import java.io.*;
import java.awt.*;
import java.util.Hashtable;

public class ServerInfo extends Thread {
	Socket socket;
	List listUser;
	PrintWriter out;
	BufferedReader in;
	Hashtable ChatList;
	String myid;

	public ServerInfo(Socket socket, List listUser, Hashtable ChatList, String myid) throws Exception {
		super();
		this.socket = socket;
		this.listUser = listUser;
		this.ChatList = ChatList;
		this.myid = myid;
		out = new PrintWriter(new PrintStream(socket.getOutputStream()));
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	public void sendMessage(String msg) {
		out.println(msg);
		out.flush();
	}

	@Override
	public void run() {
		while(true) {
			try {
				String strUser = in.readLine().trim();
				String ipnid[] = strUser.split("[/]"); //IP 주소와 ID 분리
				if ( ipnid[2].trim().equals("접속")) {
					if ( !ChatList.containsKey(ipnid[0].trim()) ) {
						ChatList.put(ipnid[0].trim(), new Chat(myid, ipnid[1].trim()));
						listUser.add(ipnid[0].trim() + " [" + ipnid[1].trim() + "]");
					}
				} else if( ipnid[2].trim().equals("해제")) {
					if ( ChatList.containsKey(ipnid[0].trim()) ) {
						ChatList.remove(ipnid[0].trim());
						for (int i = 0; i < listUser.getItemCount(); i++) {
							if (listUser.getItem(i).equals(ipnid[0].trim() + " [" + ipnid[1].trim() + "]")) {
								listUser.remove(i);
							}
						}
					}
				}

			} catch (Exception e) {
				break;
			}

		}
	}

}