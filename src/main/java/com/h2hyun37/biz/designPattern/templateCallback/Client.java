package com.h2hyun37.biz.designPattern.templateCallback;

import java.io.IOException;

public class Client {

	public static void main(String[] args) throws NumberFormatException, IOException {
		CalculatorTemplate calc = new CalculatorTemplate();

		BufferedReaderCallback callback = new SumCallback();
		BufferedReaderCallback callback2 = new MultiplyCallback();

		int sum = calc.calcSum(calc.getFilePath(), callback);
		System.out.println("sum = " + sum);

		int multiply = calc.calcSum(calc.getFilePath(), callback2);
		System.out.println("multiply = " + multiply);

	}

}
