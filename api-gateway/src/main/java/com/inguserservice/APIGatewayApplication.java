package com.inguserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableZuulProxy
@EnableEurekaClient
public class APIGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(APIGatewayApplication.class);
	}

	/*
	 * @Bean
	 * 
	 * @ConditionalOnMissingBean public SimpleHostRoutingFilter
	 * simpleHostRoutingFilter(ProxyRequestHelper helper, ZuulProperties
	 * zuulProperties, ApacheHttpClientConnectionManagerFactory
	 * connectionManagerFactory, ApacheHttpClientFactory httpClientFactory) { return
	 * new CustomErrorHostRoutingFilter(helper, zuulProperties,
	 * connectionManagerFactory, httpClientFactory); }
	 */
}
