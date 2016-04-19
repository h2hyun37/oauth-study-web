package com.sktechx.oauth.config;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sktechx.oauth.model.config.GoogleOAuthConfigModel;
import com.sktechx.oauth.model.config.OAuthConfigWebModel;

//@JsonInclude
@Service
public class OAuthConfig {

	@Autowired
	ObjectMapper mapper;

	@Autowired
	ResourceLoader loader;

	GoogleOAuthConfigModel model = null;
	OAuthConfigWebModel web = null;

	static String googleOAuthfilePath = "classpath:oauth/google/client_secret_452313409839-s2hk6pfvt740u6rlss8f4l310g2a0933.apps.googleusercontent.com.json";

	private OAuthConfigWebModel getGoogleOAuthInfo() {
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

		} catch (IOException e) {
			e.printStackTrace();
		}
		return web;
	}

	public OAuthConfigWebModel getInfo(String provider) {

		if (provider.equals("google")) {
			return getGoogleOAuthInfo();
		} else {
			return null;
		}

	}

}
