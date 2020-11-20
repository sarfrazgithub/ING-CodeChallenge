package com.inguserservice.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.cloud.commons.httpclient.ApacheHttpClientConnectionManagerFactory;
import org.springframework.cloud.commons.httpclient.ApacheHttpClientFactory;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.SimpleHostRoutingFilter;

import com.netflix.zuul.exception.ZuulException;

public class CustomErrorHostRoutingFilter extends SimpleHostRoutingFilter {
    public CustomErrorHostRoutingFilter(ProxyRequestHelper helper, ZuulProperties properties, ApacheHttpClientConnectionManagerFactory connectionManagerFactory, ApacheHttpClientFactory httpClientFactory) {
        super(helper, properties, connectionManagerFactory, httpClientFactory);
    }

    @Override
    protected ZuulException handleException(Exception ex) {
        if (ex instanceof ConnectTimeoutException) {
            return new ZuulException(ex, "Downstream timeout", HttpServletResponse.SC_GATEWAY_TIMEOUT, ex.getMessage());
        }

        if (ex instanceof IOException) {
            return new ZuulException(ex, "Downstream I/O error", HttpServletResponse.SC_SERVICE_UNAVAILABLE, ex.getMessage());
        }
        
        if ( ex instanceof com.netflix.client.ClientException) {
        	return new ZuulException(ex, "User Service unavailble. Plese try again later", HttpServletResponse.SC_SERVICE_UNAVAILABLE, ex.getMessage());
        }
        return super.handleException(ex);
    }
}
