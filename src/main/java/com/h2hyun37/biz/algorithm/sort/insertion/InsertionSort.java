package com.h2hyun37.biz.algorithm.sort.insertion;

public class InsertionSort {

	public static void printArray(int[] array) {
		System.out.print("{");
		for (int idx = 0; idx < array.length; idx++) {
			System.out.print(array[idx]);
			if (idx < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	public static void main(String[] args) {

		int[] array = new int[] { 345, 7, 30, 1, -5, 555, 9, 36 };

		printArray(array);

		for (int i = 1; i < array.length; i++) {

			int num = array[i];
			int compareIdx = i - 1;

			// 하나씩 밀어낸다
			while (compareIdx >= 0 && num < array[compareIdx]) {

				array[compareIdx + 1] = array[compareIdx];
				compareIdx--;

			}

			// 적절한 자리에 삽입
			array[compareIdx + 1] = num;

			printArray(array);

		}

	}

}
