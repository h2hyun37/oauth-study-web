package com.h2hyun37.biz.java.threadTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * 한 클래스 내의 서로 다른 synchronized method 를 동시에 접근이 불가한건지 테스트
 * 
 * <pre>
 * 테스트 방식은
 *  - 두개 쓰레드 + 두개 인스턴스 , 두개 쓰레드 + 한개의 동일 인스턴스
 *  - synchronized method (testMethod1,2) , synchronized block (testMethod3,4)
 *  	-> 서로 다른 메소드 testMethod1,2 / testMethod3,4 를 부르는 것으로 테스트 예정
 *  
 *  
 *  
 *  
 * 중간 결과 정리
 * 
 *  - 락 객체가 중요 : 인스턴스가 동일한 객체를 바라봐야 synchronized 동작 
 *  - 두개쓰레드+두개인스턴스 case
 *  	- synchronized block : lock 객체를 static Object로 잡으면 동작 (당연)
 *  	- synchronized method : 인스턴스가 다르기 때문에, lock 객체가 서로 다름, 그래서 동시 동작 
 * 
 *  - 두개쓰레드+한개인스턴스 case
 *  	- synchronized block : 잘 동작
 *  	- synchronized method : 잘 동작
 * 
 * </pre>
 * 
 * @author hyunho
 *
 */
public class SynchronizedTest1 implements Runnable {

    public String callMethodName = null;

    private Object lockObj = new Object();

    public SynchronizedTest1(String callMethodName) {
	this.callMethodName = callMethodName;
    }

    public String getNow(Calendar cal) {
	String year = Integer.toString(cal.get(Calendar.YEAR));
	String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
	String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
	String hour = Integer.toString(cal.get(Calendar.HOUR));
	String min = Integer.toString(cal.get(Calendar.MINUTE));
	String second = Integer.toString(cal.get(Calendar.SECOND));
	String millisec = Integer.toString(cal.get(Calendar.MILLISECOND));

	return String.format("[%s-%s-%s %s:%s:%s.%s]", year, month, day, hour, min, second, millisec);

    }

    public synchronized void methodTest1() {
	String thName = Thread.currentThread().getName();
	String now = getNow(Calendar.getInstance());
	System.out.println(now + " methodTest1() called (" + thName + ")");
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println(now + " methodTest1() finished (" + thName + ")");
    }

    public synchronized void methodTest2() {
	String thName = Thread.currentThread().getName();
	String now = getNow(Calendar.getInstance());
	System.out.println(now + " methodTest2() called (" + thName + ")");
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println(now + " methodTest2() finished (" + thName + ")");
    }

    public void methodTest3() {
	synchronized (lockObj) {
	    String thName = Thread.currentThread().getName();
	    String now = getNow(Calendar.getInstance());
	    System.out.println(now + " methodTest3() called (" + thName + ")");
	    try {
		Thread.sleep(5000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    System.out.println(now + " methodTest3() finished (" + thName + ")");

	}

    }

    public void methodTest4() {
	synchronized (lockObj) {
	    String thName = Thread.currentThread().getName();
	    String now = getNow(Calendar.getInstance());
	    System.out.println(now + " methodTest4() called (" + thName + ")");
	    try {
		Thread.sleep(5000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    System.out.println(now + " methodTest4() finished (" + thName + ")");

	}

    }

    public static void main(String[] args) {
	
	SynchronizedTest1 test1 = new SynchronizedTest1("methodTest1");
	SynchronizedTest1 test2 = new SynchronizedTest1("methodTest2");

	Thread t1 = new Thread(test1, "t1");
	Thread t2 = new Thread(test2, "t2");

	t1.start();
	t2.start();
	


    }

    @Override
    public void run() {
	
	String thName = Thread.currentThread().getName();

	System.out.println("run() - " + thName);

	if ("t1".equals(thName)) {
	    methodTest1();
	} else {
	    methodTest2();

	}
	
    }

    public void runOld() {
	Class<? extends SynchronizedTest1> clazz = this.getClass();
	try {
	    Method method = clazz.getDeclaredMethod(callMethodName, null);
	    method.invoke(this, null);

	} catch (NoSuchMethodException | SecurityException e) {
	    e.printStackTrace();
	} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
	    e.printStackTrace();
	}
    }

}
