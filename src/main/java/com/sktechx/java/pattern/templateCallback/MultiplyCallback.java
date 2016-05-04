package com.sktechx.java.pattern.templateCallback;

import java.io.BufferedReader;
import java.io.IOException;

public class MultiplyCallback implements BufferedReaderCallback {

	@Override
	public int doSomethingWithReader(BufferedReader br) throws IOException {

		String line = null;

		int multiply = 1;
		while ((line = br.readLine()) != null) {

			multiply *= Integer.valueOf(line);
		}

		return multiply;
	}

}
