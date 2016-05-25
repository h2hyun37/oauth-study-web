package com.h2hyun37.common.exception;

import java.util.Formatter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 특정 패키지 등을 값으로 지정하면 해당 패키지만 해당됨
// @ControllerAdvice(value = "com.sktechx.oauth.web.controller.test")
@ControllerAdvice()
public class ControllerAdviceTest {

	private Formatter formatter;

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String exception(Exception e) {

		e.printStackTrace();

		StringBuilder sb = new StringBuilder();
		for (StackTraceElement elem : e.getStackTrace()) {
			sb.append(elem.toString() + "<br />\n");
		}

		formatter = new Formatter();
		String str = formatter
				.format("e.toString() : %s, <br /><br />\ne.printStackTrace() : %s,<br /><br />\ne.getMessage() : %s,<br /><br />\ne.getLocalizedMessage() : %s,<br /><br />\n",
						e.toString(), sb.toString(), e.getMessage(), e.getLocalizedMessage()).toString();

		return str;

	}

}

