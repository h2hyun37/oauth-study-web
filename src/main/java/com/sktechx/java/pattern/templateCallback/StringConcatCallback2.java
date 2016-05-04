package com.sktechx.java.pattern.templateCallback;

public class StringConcatCallback2 implements LineCallback<String> {

	@Override
	public String doSomethingWithLine(String line, String value) {
		return value + line;
	}

}
