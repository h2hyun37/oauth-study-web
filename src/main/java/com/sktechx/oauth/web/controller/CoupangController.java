package com.sktechx.oauth.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/coupang")
public class CoupangController {

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
