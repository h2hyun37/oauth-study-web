package com.h2hyun37.biz.oauth.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.h2hyun37.BeanAnnotationTest.StringVO;

@Controller
public class BeanAnnotationController {

	@Autowired
	StringVO userName;


	@RequestMapping("/bean")
	@ResponseBody
	public String printUserName() {


		System.out.println(userName.getValue());
		return "userName bean == " + userName.getValue();

	}

}
