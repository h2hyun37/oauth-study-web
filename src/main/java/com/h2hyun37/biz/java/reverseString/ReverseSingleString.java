package com.h2hyun37.biz.java.reverseString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ReverseSingleString {

	public static String reverseSingleStringUsingJavaApi(String str) {

		StringBuilder sb = new StringBuilder(str).reverse();

		return sb.toString();

	}

	public static String reverseStringUsingStack(String str) {

		char[] arr = str.toCharArray();

		LinkedList<Character> list = new LinkedList<>();

		for (char c : arr) {
			list.add(c);
		}

		char[] reverseArr = new char[arr.length];

		int idx = 0;
		while (!list.isEmpty()) {
			reverseArr[idx++] = list.removeLast();
		}

		return String.valueOf(reverseArr);

	}

	public static void main(String[] args) {

		String str1 = "abcdefghi";
		String str2 = reverseSingleStringUsingJavaApi(str1);
		String str3 = reverseStringUsingStack(str1);

		System.out.println(str1 + " => " + str2);
		System.out.println(str1 + " => " + str3);

	}

}
