package com.h2hyun37.biz.algorithm.sort.merge;


public class MergeSort {

	public static void main(String[] args) {

		int[] array;
		array = new int[] { 35, 78, 2, -11, 57, -95, 10, 4 };
		array = new int[] { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };

		System.out.print("start : ");
		MergeSort.printArray(array);

		MergeSort.mergeSort(array, 0, array.length - 1);

		System.out.print("finish : ");
		MergeSort.printArray(array);

	}

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

	public static void mergeSort(int[] array, int left, int right) {

		if (left >= right) {
			// if (right - left + 1 < 2) {
			return;
		}

		int center = (left + right) / 2;
		mergeSort(array, left, center);
		mergeSort(array, center + 1, right);

		merge(array, left, center, right);
	}

	public static void merge(int[] array, int left, int center, int right) {

		System.out.printf("merge() (left = %s, center = %s, right = %s) : ", left, center, right);
		printArray(array);

		int[] arrayTmp = new int[right - left + 1];

		int leftIdx = left;
		int rightIdx = center + 1;
		int tmpIdx = 0;

		while (leftIdx <= center && rightIdx <= right) {

			if (array[leftIdx] <= array[rightIdx]) {
				System.out.println("left(" + array[leftIdx] + ")");
				arrayTmp[tmpIdx++] = array[leftIdx++];
			} else {
				System.out.println("right(" + array[rightIdx] + ")");
				arrayTmp[tmpIdx++] = array[rightIdx++];
			}
		}

		System.out.print("merge() (merge 1) : ");
		printArray(arrayTmp);

		while (leftIdx <= center) {
			arrayTmp[tmpIdx++] = array[leftIdx++];
		}

		while (rightIdx <= right) {
			arrayTmp[tmpIdx++] = array[rightIdx++];
		}

		System.out.print("merge() (merge 2) : ");
		printArray(arrayTmp);

		int l = left;
		tmpIdx = 0;
		while (tmpIdx < right - left + 1) {
			array[l] = arrayTmp[tmpIdx];
			l++;
			tmpIdx++;
		}

	}

}
