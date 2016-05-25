package com.h2hyun37.biz.designPattern.templateCallback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalculatorTemplate {

	public String getFilePath() {
		return this.getClass().getResource("numbers.txt").getPath();
	}

	public int calcSum(String filePath, BufferedReaderCallback callback) throws NumberFormatException, IOException {

		BufferedReader br = null;
		int sum = 0;

		try {
			br = new BufferedReader(new FileReader(filePath));
			sum = callback.doSomethingWithReader(br);

		} catch (IOException | NumberFormatException e) {

			e.printStackTrace();

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sum;
	}

}
