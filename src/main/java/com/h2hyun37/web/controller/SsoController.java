package com.h2hyun37.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sso")
public class SsoController {

    public void cookieTest(HttpServletResponse response) {

	Cookie cookie = new Cookie("sso", "test");
	response.addCookie(cookie);

    }


}
