package com.sktechx.java.pattern.templateCallback;

import java.io.IOException;

public class Client2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		CalculatorTemplate2 calc = new CalculatorTemplate2();

		LineCallback<Integer> callback = new SumCallback2();
		LineCallback<Integer> callback2 = new MultiplyCallback2();
		LineCallback<String> callback3 = new StringConcatCallback2();

		int sum = calc.calcSum(calc.getFilePath(), callback, 0);
		System.out.println("sum = " + sum);

		int multiply = calc.calcSum(calc.getFilePath(), callback2, 1);
		System.out.println("multiply = " + multiply);

		String concat = calc.calcSum(calc.getFilePath(), callback3, "");
		System.out.println("concat = " + concat);

	}

}
