package com.h2hyun37.biz.java.threadTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Producer1 implements Runnable {

    ResourceQueue1<Character> queue;

    public Producer1(ResourceQueue1<Character> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

	System.out.println("Input : ");
	String inputStr = null;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	try {

	    while (true) {
		inputStr = br.readLine();

		if (inputStr == null) {
		    break;
		}

		for (char c : inputStr.toCharArray()) {
		    // System.out.println("[" + Thread.currentThread().getName()
		    // + "] : produce : " + c);
		    queue.put(c);
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		System.out.println("[" + Thread.currentThread().getName() + "] : br.close()");
		br.close();
	    } catch (IOException e) {
	    }
	}

    }

}
