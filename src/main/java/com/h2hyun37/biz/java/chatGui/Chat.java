package com.h2hyun37.biz.java.chatGui;

//////////////////Chat.java//////////////////////
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

public class Chat extends Thread implements ActionListener {

	Socket socket;
	String myid, yourid;
	PrintWriter out;
	BufferedReader in;

	Frame window;
	TextField tfMsg;
	TextArea taMsg;

	Button btnSend, btnClose;
	Panel pnlBtn;

	public Chat(String myid, String yourid) {
		super();
		this.myid = myid;
		this.yourid = yourid;
	}

	public void connect(String ip, int port) throws Exception {
		if (socket == null)
			socket = new Socket(ip, port);
		setSocket(socket);
	}

	public void setSocket(Socket socket) throws Exception {
		this.socket = socket;
		out = new PrintWriter(new PrintStream(socket.getOutputStream()));
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		if (!this.isAlive())
			this.start();
	}

	public void showWindow() {
		if (window == null) {
			window = new Frame(yourid);
			taMsg = new TextArea(20, 40);
			pnlBtn = new Panel();
			tfMsg = new TextField(30);
			btnSend = new Button("보내기");
			btnClose = new Button("닫기");
			pnlBtn.add(tfMsg);
			pnlBtn.add(btnSend);
			pnlBtn.add(btnClose);

			window.add("North", taMsg);
			window.add("Center", pnlBtn);

			// 이벤트 설정
			btnClose.addActionListener(this);
			btnSend.addActionListener(this);
			tfMsg.addActionListener(this);

			// 화면 표시
			window.pack();
		}
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClose) {
			window.setVisible(false);
		} else if (e.getSource() == btnSend || e.getSource() == tfMsg) {
			out.println(tfMsg.getText());
			out.flush();
			taMsg.append(myid + ":\n");
			taMsg.append(tfMsg.getText() + "\n");
			tfMsg.setText("");
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				String msg = in.readLine();
				taMsg.append(yourid + ":\n");
				taMsg.append(msg + "\n");
				window.setVisible(true);
				window.show();
			} catch (Exception e) {
				taMsg.append("연결이 끊어졌습니다.\n");
				socket = null;
				break;
			}
		}
	}

}
