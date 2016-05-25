package com.h2hyun37.biz.designPattern.templateCallback;


public interface LineCallback<T> {

	T doSomethingWithLine(String line, T value);
}
