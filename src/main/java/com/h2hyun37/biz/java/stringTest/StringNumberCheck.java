package com.h2hyun37.biz.java.stringTest;

import java.util.Arrays;
import java.util.List;

public class StringNumberCheck {

	public static boolean isNumberString(String str) {

		boolean result = false;

		try {
			Double.parseDouble(str);
			result = true;
		} catch (NumberFormatException ex) {
		}

		return result;
	}

	public static void main(String[] args) {

		String str1 = "하하";
		String str2 = "523";
		String str3 = "5.7";
		String str4 = "-5";
		String str5 = "-5.9";
		String str6 = "3.141592";
		String str7 = "하하123";

		List<String> list = Arrays.asList(str1, str2, str3, str4, str5, str6, str7);

		for (String str : list) {
			System.out.println(str + " : " + isNumberString(str));
		}

	}

}
