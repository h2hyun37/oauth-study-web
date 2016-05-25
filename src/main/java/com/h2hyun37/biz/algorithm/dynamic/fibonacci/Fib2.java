package com.h2hyun37.biz.algorithm.dynamic.fibonacci;

public class Fib2 {

    public static void main(String[] args) {

	Fib2 fib1 = new Fib2();

	int sum = fib1.fibonacci(10);

	System.out.println(sum);

    }

    public int fibonacci(int n) {

	int[] array = new int[n];

	int j = 0;
	if (n > 1) {
	    array[j] = 1;
	    System.out.println("set array[" + j + "] = " + 1);
	}

	j = 1;
	if (n > 2) {
	    array[j] = 1;
	    System.out.println("set array[" + j + "] = " + 1);
	}

	for (j = 2; j < array.length; j++) {
	    array[j] = array[j - 1] + array[j - 2];
	    System.out.println("set array[" + j + "] = " + array[j]);
	}

	return array[n - 1];

    }

}
