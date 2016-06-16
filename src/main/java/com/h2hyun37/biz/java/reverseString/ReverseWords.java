package com.h2hyun37.biz.java.reverseString;

public class ReverseWords {

	public void reverseWords(char[] s) {
		int i = 0;

		// space 기준으로 word reverse : output> eht yks si blue
		for (int j = 0; j < s.length; j++) {
			if (s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}

		System.out.println(s);

		// 맨 마지막 word reverse : output> eht yks si eulb
		reverse(s, i, s.length - 1);

		System.out.println(s);

		// 전체를 reverse -> 맨 처음 input과 비교해보면 단어 순서는 그대로이고 스페이스 기준으로 역순 출력된다
		// ex>
		// input : the sky is blue
		// output : blue is sky the
		reverse(s, 0, s.length - 1);

		System.out.println(s);

	}

	public void reverse(char[] s, int i, int j) {
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {

		ReverseWords rw = new ReverseWords();

		char[] arr = "the sky is blue".toCharArray();

		rw.reverseWords(arr);

	}

}
