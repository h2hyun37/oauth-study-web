package com.sktechx.oauth.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OAuthConfigWebModel {

	@JsonProperty("client_id")
	String clientId;

	@JsonProperty("project_id")
	String projectId;

	@JsonProperty("auth_uri")
	String authUri;

	@JsonProperty("token_uri")
	String tokenUri;

	@JsonProperty("auth_provider_x509_cert_url")
	String authProviderX509CertUrl;

	@JsonProperty("client_secret")
	String clientSecret;

	@JsonProperty("redirect_uris")
	String[] redirectUris;

	@JsonProperty("javascript_origins")
	String[] javascriptOrigins;

}
