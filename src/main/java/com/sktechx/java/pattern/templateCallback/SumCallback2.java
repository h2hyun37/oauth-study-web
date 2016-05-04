package com.sktechx.java.pattern.templateCallback;

public class SumCallback2 implements LineCallback<Integer> {

	@Override
	public Integer doSomethingWithLine(String line, Integer value) {

		value += Integer.valueOf(line);
		return value;
	}

}
