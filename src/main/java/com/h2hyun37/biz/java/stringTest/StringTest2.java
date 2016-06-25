package com.h2hyun37.biz.java.stringTest;

public class StringTest2 {

    public static void main(String[] args) {
	equalsTest();
	compareToTest();
    }

    /**
     * 스트링 compareTo 테스트
     * 
     * <pre>
     * 
     * "this - another" 기억하자
     * 
     * str1 : Blue mountin
     * str2 : BCappuccino
     * str3 : ZZZZ
     * str1.compareTo(str2) : 41
     * str1.compareTo(str3) : -24
     * </pre>
     * 
     */
    public static void compareToTest() {
	String str1 = "Blue mountin";
	String str2 = "BCappuccino";
	String str3 = "ZZZZ";

	System.out.println("str1 : " + str1);
	System.out.println("str2 : " + str2);
	System.out.println("str3 : " + str3);
	System.out.println("str1.compareTo(str2) : " + str1.compareTo(str2));
	System.out.println("str1.compareTo(str3) : " + str1.compareTo(str3));

    }

    /**
     * 스트링 equals 테스트
     * 
     * <pre>
     * 
     * Result : 
     * 
     * str1 : ABC
     * str2 : ABC
     * System.identityHashCode(str1) : 366712642
     * System.identityHashCode(str2) : 1829164700
     * str1 != str2
     * str1.equals(str2) == true
     * str1.equalsIgnoreCase(str2) == true
     * </pre>
     * 
     * 
     */
    public static void equalsTest() {

	String str1 = "ABC";
	String str2 = new String("ABC");

	System.out.println("str1 : " + str1);
	System.out.println("str2 : " + str2);
	System.out.println("System.identityHashCode(str1) : " + System.identityHashCode(str1));
	System.out.println("System.identityHashCode(str2) : " + System.identityHashCode(str2));

	if (str1 == str2) {
	    System.out.println("str1 == str2");
	} else {
	    System.out.println("str1 != str2");
	}

	if (str1.equals(str2)) {
	    System.out.println("str1.equals(str2) == true");
	} else {
	    System.out.println("str1.equals(str2) != true");
	}

	if (str1.equalsIgnoreCase(str2)) {
	    System.out.println("str1.equalsIgnoreCase(str2) == true");
	} else {
	    System.out.println("str1.equalsIgnoreCase(str2) != true");
	}
    }

}
