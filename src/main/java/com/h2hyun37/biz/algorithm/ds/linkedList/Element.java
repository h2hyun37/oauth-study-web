package com.h2hyun37.biz.algorithm.ds.linkedList;

public class Element<E> {

	private E value;
	private Element<E> next;

	public Element(E value) {
		this.value = value;
		next = null;
	}

	public void setNext(Element<E> next) {
		this.next = next;
	}

	public Element<E> getNext() {
		return next;
	}

	public E getElement() {
		return value;
	}

}
