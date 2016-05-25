package com.h2hyun37.biz.algorithm;

import java.util.ArrayList;
import java.util.List;

public class NumberOfCases {

	public static void main(String[] args) {
		NumberOfCases noc = new NumberOfCases(3);
		List<CaseElement> list = noc.getNumberOfCases();
		System.out.println(list);
	}

	private ArrayList<CaseElement> cases;

	public NumberOfCases(int numberCount) {
		cases = new ArrayList<>();
		if(numberCount == 0){
				System.out.println("Number Count is 0");
				return;
		}

		int[] numbers = new int[numberCount];
		for(int i = 0; i < numberCount; i++){
			numbers[i] = i;
		}

		permute(numbers, 0);
	}

	public void permute(int[] numbers, int startIndex) {

		if (numbers.length == startIndex) {
			cases.add(new CaseElement(numbers));
		} else {
			for (int i = startIndex; i < numbers.length; i++) {
				int[] input = numbers.clone();
				int temp = input[i];
				input[i] = input[startIndex];
				input[startIndex] = temp;
				permute(input, startIndex + 1);
			}
		}
	}

	public ArrayList<CaseElement> getNumberOfCases() {
		return cases;
	}

	public class CaseElement {

		int[] caseElement;

		public CaseElement(int[] caseElement) {
			this.caseElement = caseElement;
		}

		public int[] getCaseElement() {
			return caseElement;
		}

		@Override
		public String toString() {
			String str = "";
			for (int i = 0; i < caseElement.length; i++) {
				str += caseElement[i];
			}
			return str;
		}
	}


		@Override
		public String toString() {
			if (cases == null) {
				return "null";
			}

			if (cases.size() <= 0) {
				return "0";
			}

			StringBuilder sb = new StringBuilder();
			sb.append("/////////Number of Cases/////////////\n");
			for (int i = 0; i < cases.size(); i++) {
				sb.append(cases.get(i).toString());
				sb.append('\n');
			}
			sb.append("////////////////////////////////////");
			return sb.toString();
		}

	}

