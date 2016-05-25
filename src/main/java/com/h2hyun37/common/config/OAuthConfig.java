package com.h2hyun37.common.config;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.h2hyun37.biz.oauth.model.config.GoogleOAuthConfigModel;
import com.h2hyun37.biz.oauth.model.config.OAuthConfigWebModel;

//@JsonInclude
@Service
public class OAuthConfig {

	@Autowired
	ObjectMapper mapper;

	@Autowired
	ResourceLoader loader;

	GoogleOAuthConfigModel model = null;

	// TODO : web 객체 추상화 + spring bean ?
	// TODO : provider 에 맞게 Model 객체 추상화. (지금처럼 구글용 , 페북용 따로 두지 말고...추상화)
	OAuthConfigWebModel web = null;


	static String googleOAuthfilePath = "classpath:oauth/google/client_secret_452313409839-s2hk6pfvt740u6rlss8f4l310g2a0933.apps.googleusercontent.com.json";
	static String tokenExchangeUri = "https://www.googleapis.com/oauth2/v4/token";

	public String getGoogleAuthrizeUri() {

		if (web == null) {
			getGoogleOAuthInfo();
		}

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

		String queryString = assembleQueryString(queryMap);

		String requestUri = authUri + "?" + queryString;
		System.out.println(requestUri);
		return requestUri;
	}

	public String getTokenExchangeUri(String code) {

		if (web == null) {
			getGoogleOAuthInfo();
		}

		String tokenUri = web.getTokenUri();
		String clientId = web.getClientId();
		String clientSecret = web.getClientSecret();
		String redirectUri = web.getRedirectUris()[0];
		String grantType = "authorization_code";

		Map<String, String> queryMap = new HashMap<>();

		queryMap.put("code", code);
		queryMap.put("client_id", clientId);
		queryMap.put("client_secret", clientSecret);
		queryMap.put("grant_type", grantType);

		try {
			queryMap.put("redirect_uri", URLEncoder.encode(redirectUri, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String queryString = assembleQueryString(queryMap);

		String requestUri = tokenUri + "?" + queryString;
		System.out.println(requestUri);
		return requestUri;
	}

	private void getGoogleOAuthInfo() {
		try {
			if (model == null) {

				// Read Json File
				File file = loader.getResource(googleOAuthfilePath).getFile();
				String filePath2 = file.getAbsolutePath();
				System.out.println("JSON file : " + filePath2);

				JsonNode node = mapper.readTree(file);
				System.out.println("JSON Tree : " + node.toString());

				// mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				model = mapper.readValue(file, GoogleOAuthConfigModel.class);

				web = model.getWeb();

			}

			System.out.println("clientID : " + web.getClientId());
			System.out.println("load Google OAuth JSON config file load success");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param queryMap
	 * @return
	 */
	private String assembleQueryString(Map<String, String> queryMap) {

		StringBuilder queryString = new StringBuilder();

		// TODO : 뭔가 python 의 map join 처럼 쉬운 방법이 있을 것 같다
		// map.join()
		// List<String> list = new ArrayList<>();
		for (Entry<String, String> entry : queryMap.entrySet()) {
			// list.add(entry.getKey() + "=" + entry.getValue());
			if (queryString.length() > 0) {
				queryString.append("&");
			}
			queryString.append(entry.getKey() + "=" + entry.getValue());
		}
		return queryString.toString();
	}


}
