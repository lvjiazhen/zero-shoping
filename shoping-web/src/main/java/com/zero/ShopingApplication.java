package com.zero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.retry.annotation.EnableRetry;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;


@SpringBootApplication(exclude=DruidDataSourceAutoConfigure.class)
@EnableRetry
@EnableJms
public class ShopingApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopingApplication.class, args);
	}
}
