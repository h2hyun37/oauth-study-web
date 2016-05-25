package com.h2hyun37.biz.java.multiInterface;

public class Client {

	private Interface2 class1 = null;

	{
		class1 = new Class2();
	}

	public static void main(String[] args) {

		Client client = new Client();

		// client.class1.setNumber(10);

		client.class1.printUserInfo();



	}

}
