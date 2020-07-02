package com.yethi.ngfms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yethi")
@EntityScan("com.yethi")
@EnableFeignClients
public class NGMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(NGMicroserviceApplication.class, args);
	}
}
