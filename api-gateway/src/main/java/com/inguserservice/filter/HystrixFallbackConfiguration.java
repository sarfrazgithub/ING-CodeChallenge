package com.inguserservice.filter;


import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;

@Component
public class HystrixFallbackConfiguration implements FallbackProvider { private static final String DEFAULT_MESSAGE = "User service is not available. Cannot view or update user information. Please try again later.";

@Override
public String getRoute() {
    return "user-service";
}

@Override
public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
    if (cause instanceof HystrixTimeoutException) {
        return new FallBackClientResponse(HttpStatus.GATEWAY_TIMEOUT, DEFAULT_MESSAGE);
    } else {
        return new FallBackClientResponse(HttpStatus.INTERNAL_SERVER_ERROR, DEFAULT_MESSAGE);
    }
}}