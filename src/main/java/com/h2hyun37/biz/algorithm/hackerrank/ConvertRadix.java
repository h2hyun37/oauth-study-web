package com.h2hyun37.biz.algorithm.hackerrank;

public class ConvertRadix {

	private static int getRadixNumber(char c, int base) {

		int num = 0;

		if (base == 16 && c >= 'a') {
			num = (c - 'a') + 10;
			return num;
		} else {
			num = (c - '0');
		}

		return num;
	}

	/**
	 * Convert Radix <br />
	 * ex> convertRadix("8",10,2) -> return "1000"
	 *
	 * @param src
	 *            number string which is converted
	 * @param srcBase
	 *            base of src
	 * @param targetBase
	 *            base of target
	 * @return String converted number string
	 *
	 */
	public static String convertRadix(String src, int srcBase, int targetBase) {

		// we can treat only hex, oct, binary, decimal
		if ((srcBase != 16) && (srcBase != 2) && (srcBase != 8) && (srcBase != 10)) {
			return null;
		}

		// convert src number string to decimal
		int number = 0;
		int base = 1;
		for (int i = src.length() - 1; i >= 0; i--) {
			number += base * getRadixNumber(src.charAt(i), srcBase);
			base *= srcBase;
		}

		// convert decimal to target number string
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			int remainder = number % targetBase;
			number = number / targetBase;

			if (targetBase > 10 && remainder >= 10) {
				remainder += 87;
				sb.append((char) remainder);
			} else {
				sb.append(String.valueOf(remainder));
			}

		}
		String target = sb.reverse().toString();

		if (target.startsWith("0")) {
			int i = target.indexOf("0");
			target = target.substring(i + 1);
		}

		return target;

	}

	public static int getMaxCountOfOne(String binaryStr) {
		int len = 0;
		int maxLen = 0;

		char prevCh = binaryStr.charAt(0);
		if (prevCh == '1') {
			len = 1;
		}
		System.out.printf("[%s] : %d (max : %d)\n", prevCh, len, maxLen);
		for (int i = 1; i < binaryStr.length(); i++) {

			char c = binaryStr.charAt(i);

			if (c == prevCh) {
				if (c == '1') {
					len++;
				}

			} else {
				if (c == '1') {
					len++;
				} else {
					maxLen = maxLen >= len ? maxLen : len;
					len = 0;
				}
			}
			System.out.printf("[%s] : %d (max : %d)\n", c, len, maxLen);

		}

		maxLen = maxLen >= len ? maxLen : len;
		System.out.printf("(max : %d)\n", maxLen);

		return maxLen;

	}

	public static void main(String[] args) {
		String test1 = convertRadix("39683", 10, 2);
		String test2 = convertRadix("1239", 10, 8);
		String test3 = convertRadix("8", 10, 2);
		String test4 = convertRadix("39683", 10, 8);
		String test5 = convertRadix("39683", 10, 16);
		String test6 = convertRadix("439", 10, 2);

		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		System.out.println(test4);
		System.out.println(test5);
		System.out.println(test6);

		System.out.println(getMaxCountOfOne(Integer.toBinaryString(439)));

	}
}
