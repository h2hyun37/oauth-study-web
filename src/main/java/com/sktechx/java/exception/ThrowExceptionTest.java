package com.sktechx.java.exception;

import java.io.IOException;

public class ThrowExceptionTest {

	public static void main(String[] args) {


		try {
		throwException(true);
		} catch (IOException e) {
			System.out.println("exception catched");
			System.out.println(e);
		}
	}

	public static void throwException(boolean isThrow) throws IOException {

		try {

			if (isThrow) {
				System.out.println("ready to throw exception");
				throw new IOException("temp exception");
			}

		} catch (IOException e) {
			System.out.println("catched");
			throw e;
		} finally {
			System.out.println("finally called");
		}

	}

}
