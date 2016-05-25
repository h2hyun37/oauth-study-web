package com.h2hyun37.biz.oauth.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GoogleOAuthConfigModel {

	@JsonProperty("web")
	OAuthConfigWebModel web;

}
