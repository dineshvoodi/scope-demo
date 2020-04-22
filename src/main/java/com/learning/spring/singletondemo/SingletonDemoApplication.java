package com.learning.spring.singletondemo;

import com.learning.spring.singletondemo.controller.NumberCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class SingletonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonDemoApplication.class, args);
	}

}
