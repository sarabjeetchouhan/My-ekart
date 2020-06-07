package com.myekart.utilities.config.feignclient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = { "com.myekart" })
public class FeignClientConfig {

}
