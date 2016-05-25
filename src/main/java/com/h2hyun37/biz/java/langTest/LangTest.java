package com.h2hyun37.biz.java.langTest;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;


public class LangTest<T> {

	public static void printByteArray(byte[] bytes) {
		for (byte b : bytes) {
			System.out.print(b + " ");
		}
		System.out.println();
	}

	public static void printByteArray(String prefix, byte[] bytes) {
		System.out.print(prefix + " ");
		printByteArray(bytes);
	}

	public static void stringTest() {
		String str = "한글";
		String str2 = "my hello";

		str2 = str2.concat(" " + str); // string concat
		System.out.println(str2);

		System.out.println("str2.contains(str) : " + str2.contains(str)); // string contains

		System.out.println("startswith : " + str2.startsWith("my "));

		try {
			printByteArray(str.getBytes());
			printByteArray("str.getBytes(\"UTF-8\")", str.getBytes("UTF-8"));
			printByteArray("str.getBytes(\"UTF-16\")", str.getBytes("UTF-16"));
			printByteArray("str.getBytes(\"EUC-KR\")", str.getBytes("EUC-KR"));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String str3 = null;
		try {
			str3 = new String(str.getBytes("UTF-16"), "UTF-16");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("str3(string -> byte[](UTF-16) -> string : " + str3);

		System.out.println("str2.indexOf(\"한\") : " + str2.indexOf("한"));
		System.out.println("str2.indexOf(\"글\") : " + str2.indexOf("글"));
		System.out.println("str2.charAt(9) : " + str2.charAt(9));

		System.out.println(str2.toCharArray());
	}

	public static void WrapperTest() {

		Integer number1 = new Integer("1234");

		int number2 = Integer.parseInt("1111");

		Integer number3 = Integer.valueOf("2222");

		System.out.println("number1 : " + number1);
		System.out.println("number2 : " + number2);
		System.out.println("number3 : " + number3);

		System.out.println("number1 instanceof Integer : " + (number1 instanceof Integer));

	}

	public static void SystemTest() {

		System.out.println("System.getProperties() START ======================= ");
		Properties prop = System.getProperties();

		Set<Entry<Object, Object>> propSet = prop.entrySet();
		for (Entry<Object, Object> set : propSet) {
			System.out.println(set.getKey() + " --> " + set.getValue());
			System.out.println(set);
		}

		System.out.println("Iterator() ======================= ");

		Iterator<Entry<Object, Object>> iter = prop.entrySet().iterator();

		while (iter.hasNext()) {
			Entry<Object, Object> entry = iter.next();
			System.out.println(entry.toString());
		}

		System.out.println("System.getProperties() END ======================= ");


		System.out.println("\n\n\n" + "System.getenv() START ======================= ");

		Map<String, String> sysenv = System.getenv();
		for (String key : sysenv.keySet()) {
			System.out.println(key + " ==> " + sysenv.get(key));
		}

		System.out.println("\n\n\n" + "System Class time method START ======================= ");
		System.out.println("System.currentTimeMillis() : " + System.currentTimeMillis());
		System.out.println("System.nanoTime() : " + System.nanoTime());

	}

	public void myGenericTest(WildcardGeneric<T> c, T value) {

		c.setWildcard(value);

	}

	public static void main(String[] args) {

		// StringTest.stringTest();
		// StringTest.WrapperTest();
		LangTest.SystemTest();

	}

}
