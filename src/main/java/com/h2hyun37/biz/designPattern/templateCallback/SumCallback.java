package com.h2hyun37.biz.designPattern.templateCallback;

import java.io.BufferedReader;
import java.io.IOException;

public class SumCallback implements BufferedReaderCallback {

	@Override
	public int doSomethingWithReader(BufferedReader br) throws IOException {

		String line = null;

		int sum = 0;
		int lineNumber = 0;
		while ((line = br.readLine()) != null) {
			lineNumber++;
			sum += Integer.valueOf(line);

			System.out.println("[" + lineNumber + "] : " + line + ", sum = " + sum);
		}

		return sum;

	}

}
