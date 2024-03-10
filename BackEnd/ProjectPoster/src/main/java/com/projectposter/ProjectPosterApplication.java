package com.projectposter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages= {"Configuration","com.projectposter.controller","com.projectposter.Service",
		"com.projectposter.Error","com.projectposter.Advice","com.projectposter.DAO","com.projectposter.Exceptions"})
public class ProjectPosterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPosterApplication.class, args);
	}

}
