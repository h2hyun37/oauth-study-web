package com.h2hyun37.biz.java.reflectTest;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class ReflectClient {

	public void runProxyTest() {

		ReflectInterface proxy = (ReflectInterface) Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class[] { ReflectInterface.class }, new ReflectUppercaseProxy(new ReflectTarget()));


	}

	public static void main(String[] args) {

		ReflectClient client = new ReflectClient();

		client.runProxyTest();

	}

}
