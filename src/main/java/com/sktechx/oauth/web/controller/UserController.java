package com.sktechx.oauth.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sktechx.oauth.config.OAuthConfig;
import com.sktechx.oauth.model.User;
import com.sktechx.oauth.model.config.Web;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	String redirectToLoginPage = "redirect:/user/login";
	String redirectToInfoPage = "redirect:/user/info";
	String loginPage = "login";

	@Autowired
	HttpSession session;

	@Autowired
	OAuthConfig oAuthConfig;

	// 세션 정보가 존재하면 사용자정보를 보여주고, 정보가 존재하지 않으면 로그인으로 이동
	private boolean isLogin() {
		if (session.getAttribute("userInfo") == null) {
			return false;
		} else {
			return true;
		}
	}

	@RequestMapping({ "", "/" })
	public String getUserInfo() {
		System.out.println("/user/");

		if (isLogin()) {
			return redirectToInfoPage;
		} else {
			return redirectToLoginPage;
		}
	}

	@RequestMapping("/login")
	public String login() {
		System.out.println("/user/login");

		if (isLogin()) {
			return redirectToInfoPage;
		}

		return loginPage;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public void loginProcess(@RequestParam("email") String email, @RequestParam("provider") String provider) {
		System.out.printf("/user/loginProcess : email = %s , provider = %s\n", email, provider);

		Web web = oAuthConfig.getInfo();

		System.out.println(web.getClientId());


	}

	@RequestMapping(value = "/info")
	@ResponseBody
	public String userInfo() {
		return "/user/info ...";
	}



	@RequestMapping("/1")
	// @ResponseBody
	String home(Model model) {

		System.out.println("in home() - 2");

		// ModelAndView mav = new ModelAndView();
		// mav.setViewName("hello");

		// return mav;
		return "hello"; // jsp?
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {

		System.out.println("in greeting() - 2");

		model.addAttribute("name", name);
		return "greeting";
	}

	@RequestMapping(value = "/{userNumber}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long userNumber) {

		System.out.println("getUser() : " + userNumber);
		User user = new User();

		user.setNumber(userNumber);

		return user;

	}

}
