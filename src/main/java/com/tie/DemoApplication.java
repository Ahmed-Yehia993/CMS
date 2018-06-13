package com.tie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.tie.controller" })
@ComponentScan(basePackages = { "com.tie.service" })
@ComponentScan(basePackages = { "com.tie.configuration" })
@ComponentScan(basePackages = { "com.tie.consume.ws" })
@ComponentScan(basePackages = { "com.oracle.brm.bill.services" })
@ComponentScan(basePackages = { "com.oracle.brm.cust.services" })
@EntityScan(basePackages = { "com.tie.model" })
@EnableJpaRepositories(basePackages = { "com.tie.repository" })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
