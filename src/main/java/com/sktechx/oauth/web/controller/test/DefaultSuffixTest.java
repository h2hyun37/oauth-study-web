package com.sktechx.oauth.web.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * test for default suffix
 * 
 * if you access to /authtest/login.* (for example, /login, /login.html, /login.
 * , ...)
 * 
 * you can see "method called" string on your screen.
 * 
 * @author hyunho
 *
 */
@Controller
@RequestMapping("/authtest/*")
public class DefaultSuffixTest {

    @RequestMapping("login")
    @ResponseBody
    public String doLogin() {
	return "method called";
    }

}
