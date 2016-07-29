package com.h2hyun37.biz.java.stringTest;

import java.util.Arrays;

public class SortSingleString {

	public static String sortStringUsingJavaApi(String str) {

		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		return String.valueOf(charArr);
	}

	public static void main(String[] args) {

		String str1 = "dfasdgbaer";
		String sortedStr1 = sortStringUsingJavaApi(str1);

		System.out.println(str1 + ":" + sortedStr1);

	}

}
