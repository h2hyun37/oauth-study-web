package com.sktechx.oauth.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OAuthConfigModel {

	@JsonProperty("web")
	Web web;

}
