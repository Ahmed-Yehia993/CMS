package com.nagham;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.nagham.controller"})
@ComponentScan(basePackages = {"com.nagham.service"})
@ComponentScan(basePackages = {"com.nagham.configuration"})
@ComponentScan(basePackages = {"com.nagham.consume.ws"})
@ComponentScan(basePackages = { "com.oracle.brm.bill.services" })
@ComponentScan(basePackages = { "com.oracle.brm.cust.services" })
@EntityScan(basePackages = { "com.nagham.model" })
@EnableJpaRepositories(basePackages = {"com.nagham.repository"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
