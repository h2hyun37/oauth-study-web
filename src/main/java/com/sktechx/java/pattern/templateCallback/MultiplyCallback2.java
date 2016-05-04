package com.sktechx.java.pattern.templateCallback;


public class MultiplyCallback2 implements LineCallback<Integer> {

	@Override
	public Integer doSomethingWithLine(String line, Integer value) {
		value *= Integer.valueOf(line);

		return value;
	}


}
