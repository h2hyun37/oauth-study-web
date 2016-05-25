package com.h2hyun37.biz.algorithm.ds.linkedList;

import org.springframework.stereotype.Service;

@Service
public class MyLinkedList {

	private Element<String> head;
	private Element<String> tail;
	private int count;

	{
		head = null;
		tail = null;
		count = 0;
	}

	public void add(Element<String> element) {
		if (head == null) {
			head = element;
			tail = element;
		} else {
			tail.setNext(element);
			tail = tail.getNext();
		}
		count++;
	}

	public void add(String value) {
		Element<String> elem = new Element<String>(value);
		add(elem);
	}

	private void checkIndexOutOfBound(int index) throws IndexOutOfBoundsException {
		if (index >= count) {
			throw new IndexOutOfBoundsException(String.format(
					"index out of bound : length of list = %s, your parameter = %s", count, index));
		}

	}

	public String get(int index) throws IndexOutOfBoundsException {

		checkIndexOutOfBound(index); // throws exception if index out of bound.

		int i = 0;
		Element<String> pointer = head;

		while (i < index) {
			pointer = pointer.getNext();
			i++;
		}

		return pointer.getElement();
	}

	public String remove(int index) throws IndexOutOfBoundsException {

		checkIndexOutOfBound(index);

		int i = 0;
		Element<String> pointer = head;
		Element<String> prev = null;

		while (i < index) {
			prev = pointer;
			pointer = pointer.getNext();
			i++;
		}

		if (pointer == head) {
			head = head.getNext();

			if (count == 1) {
				tail = null;
			}
		} else if (pointer == tail) {
			tail = prev;
			tail.setNext(null);

		} else {
			prev.setNext(pointer.getNext());
		}

		count--;

		return pointer.getElement();
	}

	public String printAll() {

		StringBuilder sb = new StringBuilder();

		Element<String> temp = head;
		while (temp != null) {
			sb.append(temp.getElement() + ",");
			temp = temp.getNext();
		}
		sb.append("");

		return sb.toString();
	}



}
