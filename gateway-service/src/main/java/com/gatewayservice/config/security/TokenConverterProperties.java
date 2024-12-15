package com.gatewayservice.config.security;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@ConfigurationProperties(prefix = "token.converter")
public class TokenConverterProperties {
    private String resourceId;

    private String principalAttribue;

    public String getResourceId() {
        return resourceId;
    }
    public Optional<String> getPrincipalAttribue() {
        return Optional.ofNullable(principalAttribue);
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
    public void setPrincipalAttribue(String principalAttribue) {
        this.principalAttribue = principalAttribue;
    }
}
