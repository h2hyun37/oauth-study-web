package com.sktechx.java.algorithm.dynamic.fibonacci;

public class Fib3 {

    int[] memo = null;

    public static void main(String[] args) {

	Fib3 fib1 = new Fib3();

	int sum = fib1.fibonacci(10);

	System.out.println(sum);

    }

    public int fibonacci(int n) {

	if (memo == null) {
	    memo = new int[n];
	    for (int i = 0; i < memo.length; i++) {
		memo[i] = -1;
	    }
	}

	if (memo[n - 1] != -1) {
	    System.out.println("use memo : " + memo[n - 1] + "(n == " + n + ")");
	    return memo[n - 1];
	}

	if (n == 1 || n == 2) {
	    System.out.println("return 1 (n == " + n + ")");
	    return 1;
	}

	System.out.println("n == " + n);
	memo[n - 1] = fibonacci(n - 1) + fibonacci(n - 2);
	return memo[n - 1];

    }

}
