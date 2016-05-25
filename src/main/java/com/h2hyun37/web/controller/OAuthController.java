package com.h2hyun37.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.h2hyun37.common.config.OAuthConfig;


@Controller
@RequestMapping(value = "/oauth2")
public class OAuthController {

	@Autowired
	OAuthConfig oAuthConfig;


	@RequestMapping("/exception")
	public void exceptionTest() {
		throw new RuntimeException("test runtime exception");
	}

	@RequestMapping(value = "/requestForAuth")
	public void requestForAuth() {
		System.out.println("/oauth2/requestForAuth with no method param");
	}

	@RequestMapping(value = "/requestForAuth", params = { "provider=google" })
	public String requestForAuth(@RequestParam("provider") String provider, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		System.out.println("/oauth2/requestForAuth (provider = " + provider + ")");

		String requestUri = oAuthConfig.getGoogleAuthrizeUri();

		// ////////////////////////////////////////////////////////////////////////////////////
		// OAuth flow 시작
		// ////////////////////////////////////////////////////////////////////////////////////

		// 1. redirect 를 template engine 에게 맡긴다 : 동작함
		// return "redirect:" + requestUri;

		// 2. response Code 에 302 , Location Header 를 추가한다 : 동작함
		response.setStatus(302);
		response.setHeader("Location", requestUri);
		return null;

		// 3. Page 에서 javascript 로 redirect 시킨다 (locaion.href 이용. 이거 외에 방법 더 있을 듯) : 동작함.
		// 단 몇초뒤 이동은 실패. setTimeout 이 동작하는지도 모르겠고 , Thymeleaf 에서 attribute 를 치환하는게 잘 안됨...
		// location.href : 새로운 페이지 이동 / 속성을 변경 / 주소 히스토리에 기록됨
		// location.replace() : 새로운 페이지로 변경시킴 (덮어씀) / 메소드 / 기록되지 않음

		// System.out.println(requestUri);
		// model.addAttribute("uri", requestUri);
		// model.addAttribute("timeOut", 5000);
		// return "redirectPage";

		// 4. HTML Meta Tag 활용 : 이건 테스트하지 말자. 위 3개만 해도 충분할듯.
		// <meta http-equiv="refresh" content="5;url=http://www.example.com/" />
		// 위 내용은 5초 뒤 http://www.example.com/ 로 이동하는 내용이다

	}

	@RequestMapping(value = "/callback", params = { "code" })
	public void callBack(@RequestParam("code") String code,
			@RequestParam(value = "state", required = false) String state, HttpServletResponse response) {

		System.out.printf("/oauth2/callback?code - code = %s, state = %s \n", code, state);

		String tokenUri = oAuthConfig.getTokenExchangeUri(code);

		// POST 요청
		// 1. Apache Commons : HttpClient
		// 2. Spring RestTemplate
		// 3. Java 생짜 (java.net)
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		// HttpClifactory.getHttpClient();

	}

	@RequestMapping(value = "/callback", params = { "error" })
	public void callBack(@RequestParam("error") String error,
			@RequestParam(value = "state", required = false) String state) {

		System.out.println("/oauth2/callback?error - User denied : " + error);

	}

}
