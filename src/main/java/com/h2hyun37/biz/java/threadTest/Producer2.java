package com.h2hyun37.biz.java.threadTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Producer2 implements Runnable {

    ResourceQueue2<Character> queue;

    public Producer2(ResourceQueue2<Character> queue) {
		this.queue = queue;
	}

    @Override
    public void run() {

	System.out.println("Input : ");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String userInput = null;

	try {
	    while (true) {
		userInput = br.readLine();
		if (userInput == null) {
		    break;
		}
		System.out.println("user input : " + userInput);

		for (char c : userInput.toCharArray()) {
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
