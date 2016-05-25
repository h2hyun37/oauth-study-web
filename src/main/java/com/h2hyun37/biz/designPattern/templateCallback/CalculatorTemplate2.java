package com.h2hyun37.biz.designPattern.templateCallback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalculatorTemplate2 {

	public String getFilePath() {
		return this.getClass().getResource("numbers.txt").getPath();
	}

	public <T> T calcSum(String filePath, LineCallback<T> callback, T initValue) throws NumberFormatException,
			IOException {

		BufferedReader br = null;
		T res = initValue;
		String line = null;

		try {
			br = new BufferedReader(new FileReader(filePath));

			while ((line = br.readLine()) != null) {

				res = callback.doSomethingWithLine(line, res);
			}

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

		return res;
	}

}
