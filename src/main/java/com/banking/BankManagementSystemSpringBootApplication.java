package com.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.banking")
public class BankManagementSystemSpringBootApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(BankManagementSystemSpringBootApplication.class, args);
		System.out.println("Banking Management System!");
	}

}
