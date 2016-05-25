package com.h2hyun37.biz.designPattern.templateCallback;

public class StringConcatCallback2 implements LineCallback<String> {

	@Override
	public String doSomethingWithLine(String line, String value) {
		return value + line;
	}

}
