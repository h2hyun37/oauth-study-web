package com.sktechx.java.pattern.templateCallback;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void calcSumTest() throws NumberFormatException, IOException {
		CalculatorTemplate calc = new CalculatorTemplate();

		BufferedReaderCallback callback = new SumCallback();
		int sum = calc.calcSum(calc.getFilePath(), callback);

		assertThat(sum, is(10));
	}

}
