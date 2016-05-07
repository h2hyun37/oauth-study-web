package com.sktechx.java.algorithm.dynamic.fibonacci;

public class Fib1 {

    public static void main(String[] args) {

	Fib1 fib1 = new Fib1();

	int sum = fib1.fibonacci(10);

	System.out.println(sum);

    }

    public int fibonacci(int n) {

	System.out.println("finbonacci(" + n + ") called");

	if (n == 1 || n == 2) {
	    return 1;
	}

	return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
