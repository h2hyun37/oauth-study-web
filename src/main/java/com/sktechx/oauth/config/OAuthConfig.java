package com.sktechx.oauth.config;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sktechx.oauth.model.config.OAuthConfigModel;
import com.sktechx.oauth.model.config.Web;

//@JsonInclude
@Service
public class OAuthConfig {

	@Autowired
	ObjectMapper mapper;

	OAuthConfigModel model;

	static String filePath = "oauth/google/client_secret_452313409839-s2hk6pfvt740u6rlss8f4l310g2a0933.apps.googleusercontent.com.json";

	public Web getInfo() {

		Web web = null;

		try {

			if (model == null) {
				// mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				model = mapper.readValue(new File(filePath), OAuthConfigModel.class);
			}

			web = model.getWeb();

			System.out.println("clientID : " + web.getClientId());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return web;
	}

}
