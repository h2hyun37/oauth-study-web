package com.h2hyun37.biz.java.stringTest;

public class StringTest1 {
	String caesar(String s, int n) {
		StringBuilder sb = new StringBuilder();

		for (String str : s.split(" ")) {
			byte[] inputArray = str.getBytes();
			byte[] outputArray = new byte[inputArray.length];

			for (int idx = 0; idx < inputArray.length; idx++) {
				outputArray[idx] = getNextChar(inputArray[idx], n);
			}
			sb.append(new String(outputArray) + " ");
		}
		return sb.toString().trim();
	}

	private byte getNextChar(byte inputArray, int n) {

		if (n >= 26) {
			n = n % 26;
		}

		byte b;
		if (inputArray == 'Z') {
			inputArray = 'A';
			b = (byte) (inputArray + (n - 1));
		} else if (inputArray == 'z') {
			inputArray = 'a';
			b = (byte) (inputArray + (n - 1));
		} else {
			b = (byte) (inputArray + n);
		}

		if (b > 'Z' && b < 'a') {
			b = (byte) (b - 26);
		} else if (b > 'z') {
			b = (byte) (b - 26);
		}

		System.out.println(inputArray + "," + b);
		return b;
	}

	public static void main(String[] args) {
		StringTest1 c = new StringTest1();
		// String s = "SKVi cQ   ygkXacoeXRxZEzYwTpjQzRAvHzUXsl  DGOZ oez";
		String s = "SKVi";
		System.out.println(s + ",34 : " + c.caesar(s, 34));
	}
}
