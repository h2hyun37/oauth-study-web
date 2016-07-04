package com.h2hyun37.biz.java.threadTest;

public interface ResourceQueue<T> {

	public void put(T element);

	public T get();
}
