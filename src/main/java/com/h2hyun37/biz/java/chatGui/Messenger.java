package com.h2hyun37.biz.java.chatGui;

//////////////////Messenger.java /////////////////////

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

public class Messenger extends Thread implements ActionListener {
	String serverIp;
	int serverPort = 9831;
	int messengerPort = 9832;
	ServerSocket listen;
	Chat chat;

	Frame MainWindow;
	TextField tfServerIp, tfId;
	Button btnLogon, btnCancel, btnExit;
	Panel pnlLogon, pnlUser;
	List listUser;

	Hashtable ChatList = new Hashtable();
	CardLayout card;

	public Messenger() {
		super();
		MainWindow = new Frame("자바 메신저 Ver 1.0");

		card = new CardLayout();
		MainWindow.setLayout(card);

		// 로그인 카드
		pnlLogon = new Panel(new BorderLayout());
		tfServerIp = new TextField(20);
		tfId = new TextField(20);
		btnLogon = new Button("로그인");
		btnCancel = new Button("취소");
		Panel pnlIp = new Panel();
		pnlIp.add(new Label("P2P 서버 주소: "));
		pnlIp.add(tfServerIp);
		Panel pnlId = new Panel();
		pnlId.add(new Label("로그인 아이디: "));
		pnlId.add(tfId);
		Panel pnlBtn = new Panel();
		pnlBtn.add(btnLogon);
		pnlBtn.add(btnCancel);
		pnlLogon.add("North", pnlIp);
		pnlLogon.add("Center", pnlId);
		pnlLogon.add("South", pnlBtn);
		MainWindow.add("Panel1", pnlLogon);

		// 접속자 목록 카드
		pnlUser = new Panel(new BorderLayout());
		btnExit = new Button("종 료");
		listUser = new List(15, false);
		pnlUser.add("North", new Label("접속자 목록"));
		pnlUser.add("Center", listUser);
		pnlUser.add("South", btnExit);
		MainWindow.add("Panel2", pnlUser);

		// 이벤트 설정
		btnExit.addActionListener(this);
		btnCancel.addActionListener(this);
		btnLogon.addActionListener(this);
		listUser.addActionListener(this);
		// 화면 표시
		MainWindow.pack();
		MainWindow.setVisible(true);

		// 서버소켓
		try {
			listen = new ServerSocket(messengerPort);
		} catch (Exception e) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit || e.getSource() == btnCancel) {
			System.exit(0);
		} else if (e.getSource() == btnLogon) {
			try {
				serverIp = tfServerIp.getText().trim();
				Socket serverSocket = new Socket(serverIp, serverPort);
				ServerInfo serverInfo = new ServerInfo(serverSocket, listUser, ChatList, tfId.getText());
				serverInfo.sendMessage(tfId.getText());
				card.next(MainWindow);
				serverInfo.start();
				this.start();
			} catch (Exception err) {
				tfServerIp.setText("연결 실패" + serverIp);
			}
		} else if (e.getSource() == listUser) {
			try {
				String ip = listUser.getSelectedItem().split("[ ]")[0].trim();
				Chat chat = (Chat) ChatList.get(ip);
				chat.connect(ip, messengerPort);
				chat.showWindow();
			} catch (Exception err) {
				err.printStackTrace(System.out);
			}
		}

}
@Override
	public void run() {
		while (true) {
			try {
				Socket socket = listen.accept();
				String ip = socket.getInetAddress().getHostAddress();
				Chat chat = (Chat) ChatList.get(ip);
				chat.setSocket(socket);
				chat.showWindow();
			} catch (Exception e) {
			}
		}
	}

	public static void main(String args[]) {
		Messenger msn = new Messenger();
	}
}
