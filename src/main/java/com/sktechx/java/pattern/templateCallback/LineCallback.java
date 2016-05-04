package com.sktechx.java.pattern.templateCallback;


public interface LineCallback<T> {

	T doSomethingWithLine(String line, T value);
}
