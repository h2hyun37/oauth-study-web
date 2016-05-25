package com.h2hyun37.biz.algorithm.sort;

import java.util.Random;

public class IterativeQuickSortInPlace {

	public static Random random = new Random();

	public static void main(String[] args) {
		int[] array;
		array = new int[] { 35, 78, 2, -11, 57, -95, 10, 4 };
		array = new int[] { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
		IterativeQuickSortInPlace qs = new IterativeQuickSortInPlace();

		System.out.print("start : ");
		qs.printArray(array);

		qs.quicksort(array, 0, array.length - 1);

		System.out.print("finish : ");
		qs.printArray(array);
	}

	public void printArray(int[] array) {
		System.out.print("{");
		for (int idx = 0; idx < array.length; idx++) {

			System.out.print(array[idx]);
			if (idx < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	public void quicksort(int[] array, int left, int right) {

		int[] stack = new int[right - left + 1];
		int top = -1;

		// push 순서는 항상 left, right
		stack[++top] = left;
		stack[++top] = right;

		while (top >= 0) {

			// pop 순서는 항상 right, left
			right = stack[top--];
			left = stack[top--];

			// set pivot
			int pivotIdx = partition(array, left, right);

			System.out.print("pivot in quicksort() : " + array[pivotIdx] + " - ");
			printArray(array);

			// pivot 왼쪽에 elements 남아있으면 left 값을 push
			// push 순서는 항상 left, right
			if (left < pivotIdx - 1) {
				stack[++top] = left;
				stack[++top] = pivotIdx - 1;
			}

			// pivot 오른쪽에 elements 남아있으면 right 값을 push
			// push 순서는 항상 left, right
			if (pivotIdx + 1 < right) {
				stack[++top] = pivotIdx + 1;
				stack[++top] = right;
			}
		}
	}

	public int partition(int[] array, int left, int right) {

		// 맨 마지막 값 선택 => 랜덤값 선택하도록 개선
		int randomPivotIdx = random.nextInt(right - left + 1);
		swap(array, randomPivotIdx + left, right);

		int pivot = array[right];

		System.out.print("\t[in partition]\t\tpivot : " + pivot + "\t");

		int l = left - 1;
		int r = right;

		while (true) {

			while (array[++l] < pivot) {
				; // do nothing
			}

			while (r > 0 && array[--r] > pivot) {
				; // do nothing
			}

			if (l >= r) {
				break;
			}

			swap(array, l, r);
			System.out.print("\t");
			printArray(array);
		}

		swap(array, l, right);
		return l;
	}

	public void swap(int[] array, int l, int r) {
		int temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}

}
