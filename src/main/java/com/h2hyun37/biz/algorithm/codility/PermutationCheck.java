package com.h2hyun37.biz.algorithm.codility;

import java.util.Arrays;
import java.util.Random;

/**
 * <pre>
 * In the codility permutation check question:
 *
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * For example, array A such that:
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * is a permutation, but array A such that:
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * is not a permutation.
 * The goal is to check whether array A is a permutation.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.
 * For example, given array A such that:
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * the function should return 1.
 * Given array A such that:
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * the function should return 0.
 * Assume that:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 *
 * </pre>
 *
 *
 *
 *
 * @author 1001065
 *
 */
public class PermutationCheck {

	public int solution(int[] a) {

		int flag = 1;

		int len = a.length;

		int[] checkArray = new int[len];

		for (int idx = 0; idx < len; idx++) {

			int value = a[idx];

			// break if value is bigger than array's length, or smaller than 1
			if (len < value || value < 1) {
				// System.out.println("value(" + value + ") > len(" + len + ")");
				flag = 0;
				break;
			}

			if (checkArray[value - 1] == 0) {
				checkArray[value - 1] = 1;
			} else {
				// System.out.println("check[" + (value - 1) + "] : " + checkArray[value - 1]);
				flag = 0;
				break;
			}
		}

		return flag;

	}

	public static void main(String[] args) {

		int[] a1 = new int[] { 4, 1, 2, 3 };
		int[] a2 = new int[] { 4, 1, 3 };
		int[] a3 = new int[100000];

		Random random = new Random();
		for (int i = 0; i < a3.length; i++) {
			while (a3[i] == 0) {
				int randomNumber = random.nextInt(a3.length) + 1;

				if (a3[i] == 0) {
					a3[i] = randomNumber;
				}
			}

		}
		System.out.println(Arrays.toString(a3));

		PermutationCheck pChk = new PermutationCheck();
		System.out.println(pChk.solution(a1));
		System.out.println(pChk.solution(a2));
		System.out.println(pChk.solution(a3));

	}

}
