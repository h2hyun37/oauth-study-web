package com.h2hyun37.biz.java.bitOperator;

public class BitOperator {

	public static void unsignedByteExam() {

		int n = 150;

		byte b = (byte) n;
		String binaryStrOfB = Integer.toBinaryString(b);
		binaryStrOfB = binaryStrOfB.substring(binaryStrOfB.length() - 8);


		// result :
		// -106,10010110
		// 150,10010110
		System.out.println(b + "," + binaryStrOfB);
		System.out.println((b & 0xff) + "," + Integer.toBinaryString((b & 0xff)));

	}

	public static void main(String[] args) {

		unsignedByteExam();

		char c = 65;

		System.out.println(c);


	}

}
