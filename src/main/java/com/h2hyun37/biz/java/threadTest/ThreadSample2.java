package com.h2hyun37.biz.java.threadTest;

public class ThreadSample2 {

    class ChildWorker implements Runnable {

	private String name;
	private String threadName;
	private String threadGroupName;

	public ChildWorker(String name) {
	    this.name = name;
	}

	public String getName() {
	    return name;
	}

	@Override
	public void run() {

	    if (threadName == null) {
		threadName = Thread.currentThread().getName();
	    }

	    if (threadGroupName == null) {
		threadGroupName = Thread.currentThread().getThreadGroup().getName();
	    }

	    while (true) {
		System.out.println(name + " working <<<<<<<<<< (thread name : " + threadName + ", thread group name : "
			+ threadGroupName + ")");

		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}

    }

    public static void main(String[] args) {

	System.out.println("main() start");

	ThreadSample2 sample2 = new ThreadSample2();

	Runnable r1 = sample2.new ChildWorker("worker1");
	Runnable r2 = sample2.new ChildWorker("worker2");

	Thread th1 = new Thread(r1, ((ChildWorker) r1).getName());
	Thread th2 = new Thread(r2, ((ChildWorker) r2).getName());

	th1.start();
	th2.start();

	System.out.println("thread name : " + Thread.currentThread().getName());
	System.out.println("thread group name : " + Thread.currentThread().getThreadGroup().getName());

	System.out.println("main() finish");

    }

}
