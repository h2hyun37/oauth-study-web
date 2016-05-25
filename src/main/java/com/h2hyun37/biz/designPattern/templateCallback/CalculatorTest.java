package com.h2hyun37.biz.designPattern.templateCallback;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	CalculatorTemplate calc;
	BufferedReaderCallback callback;
	String filePath;

	@Before
	public void setUp() {
		calc = new CalculatorTemplate();
		filePath = calc.getFilePath();
	}

	@Test
	public void sumCallbackTest() throws NumberFormatException, IOException {

		callback = new SumCallback();
		int sum = calc.calcSum(filePath, callback);
		assertThat(sum, is(10));
	}

	@Test
	public void multiplyCallbackTest() throws NumberFormatException, IOException {

		callback = new MultiplyCallback();
		int multiply = calc.calcSum(filePath, callback);
		assertThat(multiply, is(24));
	}


}
