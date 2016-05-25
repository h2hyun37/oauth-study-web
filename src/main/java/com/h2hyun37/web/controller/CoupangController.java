package com.h2hyun37.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/coupang")
public class CoupangController {

	public class ListElement<T> {

		T data;
		ListElement<T> next = null;

		public ListElement(T value) {
			data = value;
		}

		public ListElement<T> next() {
			return next;
		}

		public T value() {
			return data;
		}

		public void setNext(ListElement<T> elem) {
			next = elem;
		}

		public void setValue(T value) {
			data = value;
		}

	}

	@RequestMapping("/ge")
	@ResponseBody
	public String genericTest() {

		String strings = Arrays.toString(new int[] { 2, 3, 4, 5, 6 });
		System.out.println(strings);

		ListElement<String> header = null;
		ListElement<String> current = null;

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		for (int i : list) {

			if (header == null) {
				header = new ListElement<>(Integer.toString(i));
				current = header;
			} else {
				current.setNext(new ListElement<>(Integer.toString(i)));
				current = current.next();
			}
		}

		StringBuilder sb = new StringBuilder();

		current = header;
		while (current != null) {
			sb.append(current.value() + "<br />\n");
			current = current.next();
		}

		return sb.toString();


	}

    public static List<Integer> convertStringToInteger(String[] subCipherText) {
	List<Integer> result = new ArrayList<Integer>();

	for (int i = 0; i < subCipherText.length; i++) {
	    result.add(Integer.parseInt(subCipherText[i]));
	}
	return result;
    }

    public static String convertIntegerToAscii(List<Integer> listOfInteger) {
	String plainText = "";

	for (int i = 0; i < listOfInteger.size(); i++) {
	    plainText += (char) listOfInteger.get(i).intValue();
	}

	return plainText;
    }

    public static List<Integer> shiftRight(List<Integer> listOfInteger) {
	for (int i = 0; i < listOfInteger.size(); i++) {
	    listOfInteger.set(i, listOfInteger.get(i) >> 1);
	}
	return listOfInteger;
    }

    public static String decryptText(String cipherText) {
	String[] subCipherText = cipherText.split("\\.");

	List<Integer> listOfInteger = convertStringToInteger(subCipherText);
	listOfInteger = shiftRight(listOfInteger);

	String plainText = convertIntegerToAscii(listOfInteger);

	return plainText;
    }

    @RequestMapping("/")
    public String coupangCode(Model model) {

	String cipherText = "212.242.214.194.220.206.128.198.222.234.224.194.220.206.92.198.222.218";

	String info = "blah blah";

	String plainText = decryptText(cipherText);

	model.addAttribute("plainText", plainText);

	return "coupang";

    }

}
