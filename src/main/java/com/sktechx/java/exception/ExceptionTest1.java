package com.sktechx.java.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest1 {

    public class IOException2 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8119773642063640544L;

	public IOException2(Throwable throwable) {
	    super(throwable);
	}

    }

    public void throwException() throws IOException2 {
	throw new IOException2(new IOException(new FileNotFoundException("init exception")));
    }


    public static void main(String[] args) throws IOException2 {

	ExceptionTest1 ex = new ExceptionTest1();

	ex.throwException();
    }


}
