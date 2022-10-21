package com.hacorp.authen.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "serer.jwt.security")
public class JwtSecurityProperties {

	private String secretKey;
	
	private String issuer;

	public JwtSecurityProperties() {
		super();
	}

	public JwtSecurityProperties(String secretKey, String issuer) {
		super();
		this.secretKey = secretKey;
		this.issuer = issuer;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	
	
	
}
