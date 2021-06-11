package com.mat37.SafetyNet_Alerts.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.mat37.safetynet.alerts")
public class CustomProperties {
	private String apiUrl;

}
