package com.h2hyun37.biz.java.langTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 *
 * 1. <T> 에 T의 자식 클래스가 가능한가?
 *  -> 불가능. A가 B의 자식클래스인 경우 Generic<A> 는 Generic<B> 의 하위 클래스가 아니다.
 *  -> 이런 것을 되도록 하기 위해 extends 가 존재
 *
 * 2. <T extends Number> , <? extends number> 뭐가 되는건지 확인
 *
 *  -> 2번은 메소드 파라미터에 선언할때에 가능
 *
 * 3. <? extends T> , <U extends T> 문법이 안맞는지 확인
 *  -> 클래스에 선언시
 *  	<T>, <T extends Number> 형식 가능, <T extends U> 안됨 (U가 뭔지 모르니까)
 *  	<?> , <? extends Number> , <? extends T> 안됨
 *  -> 메소드에 선언시
 *		<T>, <T extends Number> 가능, <T extends U> 가능 (단 U가 먼저 선언되어 있어야 함)
 *		<?>, <? extends Number> 불가. 단 메소드 파라미터에는 가능
 *
 *	-> 메소드 파라미터
 *
 *
 * 클래스에 선언시
 * 형식 : class [ClassName] <TypeParameter> { ... }
 * 	- <T> 가능
 *  - <T extends Number> 가능
 *  - <? extends Number> 불가
 *  - <?> 불가
 *
 * 메소드에 선언시
 * 형식 : [access Modifier] <TypeParameter> [return type] [methodName]
 *
 *
 */

public class GenericTest1<T> {

	List<T> list = new ArrayList<T>();

	public void add(T t) {
		list.add(t);
	}

	public <U> void test1(List<U> generic) {

	}

	public void test2() {

	}

	static void gPrint(List<? extends Number> l) {
		for (Number n : l) {
			System.out.println(n);
		}
	}

	static <T extends Number> void gPrintA(List<T> l) {
		for (Number n : l) {
			System.out.println(n);
		}
	}

	public static void main(String[] args) {

		GenericTest1<Number> genericTest1 = new GenericTest1<Number>();

		Integer i = new Integer(10);

		genericTest1.add(i);

		for (Number number : genericTest1.list) {
			System.out.println(number + "," + (number instanceof Integer));
		}

	}

}
