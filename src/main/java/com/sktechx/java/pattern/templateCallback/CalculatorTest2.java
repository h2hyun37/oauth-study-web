package com.sktechx.java.pattern.templateCallback;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest2 {

	CalculatorTemplate2 calc;
	String filePath;

	@Before
	public void setUp() {
		calc = new CalculatorTemplate2();
		filePath = calc.getFilePath();
	}

	@Test
	public void sumCallbackTest() throws NumberFormatException, IOException {

		LineCallback<Integer> callback = new SumCallback2();
		int sum = calc.calcSum(filePath, callback, 0);
		assertThat(sum, is(10));
	}

	@Test
	public void multiplyCallbackTest() throws NumberFormatException, IOException {

		LineCallback<Integer> callback = new MultiplyCallback2();
		int multiply = calc.calcSum(filePath, callback, 1);
		assertThat(multiply, is(24));
	}


	@Test
	public void concatCallbackTest() throws NumberFormatException, IOException {

		LineCallback<String> callback = new StringConcatCallback2();
		String concat = calc.calcSum(filePath, callback, "");
		assertThat(concat, is("1234"));

	}

}
