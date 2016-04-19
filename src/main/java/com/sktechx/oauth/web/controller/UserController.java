package com.sktechx.oauth.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sktechx.oauth.config.OAuthConfig;
import com.sktechx.oauth.model.User;
import com.sktechx.oauth.model.config.OAuthConfigWebModel;

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

	OAuthConfigWebModel web;

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
	public void loginProcess(@RequestParam(value = "email", required = false) String email,
			@RequestParam("provider") String provider) {
		System.out.printf("/user/loginProcess : email = %s , provider = %s\n", email, provider);

		// TODO : provider 에 맞게 Model 객체 추상화. (지금처럼 구글용 , 페북용 따로 두지 말고...추상화)
		// TODO : provider 보고 if-else 빼자. 뭔가 설정기반으로 ?
		if ("google".equals(provider)) {
			web = oAuthConfig.getInfo(provider);

			String requestUri = getGoogleAuthrizeUri();

		}

		// OAuth flow 시작

	}

	/**
	 *
	 */
	private String getGoogleAuthrizeUri() {
		String authUri = web.getAuthUri();
		String clientId = web.getClientId();
		String redirectUri = web.getRedirectUris()[0];

		Map<String, String> queryMap = new HashMap<>();

		queryMap.put("response_type", "code");
		queryMap.put("client_id", clientId);
		queryMap.put("state", "xyz"); // 임시 state 값

		try {
			queryMap.put("redirect_uri", URLEncoder.encode(redirectUri, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			queryMap.put("scope", URLEncoder.encode("email profile", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO : 뭔가 python 의 map join 처럼 쉬운 방법이 있을 것 같다
		// map.join()
		// List<String> list = new ArrayList<>();
		StringBuilder queryString = new StringBuilder();
		for (Entry<String, String> entry : queryMap.entrySet()) {
			// list.add(entry.getKey() + "=" + entry.getValue());
			if (queryString != null) {
				queryString.append("&");
			}
			queryString.append(entry.getKey() + "=" + entry.getValue());
		}

		String requestUri = web.getAuthUri() + "?" + queryString.toString();
		System.out.println(requestUri);
		return requestUri;
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
