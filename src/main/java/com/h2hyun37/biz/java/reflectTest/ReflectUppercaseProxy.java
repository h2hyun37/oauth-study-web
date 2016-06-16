package com.h2hyun37.biz.java.reflectTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ReflectUppercaseProxy implements InvocationHandler {

	private ReflectInterface target;

	public ReflectUppercaseProxy(ReflectInterface target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		String ret = (String) method.invoke(target, args);
		return ret.toUpperCase();

	}

}
