package com.myekart.order;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({ "com.myekart" })
@EnableTransactionManagement
@EnableDiscoveryClient
public class MyEkartOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEkartOrderServiceApplication.class, args);
	}

	@Bean
	public DozerBeanMapper getMapper() {
		return new DozerBeanMapper();
	}
}
