package com.h2hyun37.biz.algorithm.hackerrank.sort;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ClosestNumbers {

	public static int[] getArrayFromUserInput() {

		Scanner scanner = new Scanner(System.in);

		// get array length
		int arrLength = 0;
		arrLength = scanner.nextInt();
		int[] arr = new int[arrLength];

		scanner.nextLine(); // skip new line (\n)

		// get array elements
		int idx = 0;
		String[] elements = scanner.nextLine().split(" ");
		for (String element : elements) {
			arr[idx++] = Integer.parseInt(element);
		}

		scanner.close();

		return arr;
	}

	public static void main(String[] args) {

		// get elements from user input and sort
		int[] elements = getArrayFromUserInput();
		Arrays.sort(elements);

		// buffer for closest number pairs
		int[] closest = new int[elements.length * 2];
		int closestIdx = 0;

		// pick closest value pairs while looping
		int min = Integer.MAX_VALUE;
		for (int idx = 0; idx < elements.length - 1; idx++) {
			int num1 = elements[idx];
			int num2 = elements[idx + 1];
			int diff = num2 - num1;

			// skip if diff value is bigger than minimum value.
			if (diff > min) {
				continue;
			}

			// reset index if diff value is smaller then minimum value.
			if (diff < min) {
				closestIdx = 0;
				min = diff;
			}

			closest[closestIdx++] = num1;
			closest[closestIdx++] = num2;
		}

		// print closest value pairs
		for (int idx = 0; idx < closestIdx; idx++) {
			System.out.print(closest[idx] + " ");
		}

	}

}