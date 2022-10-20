package com.facundo.javaDocker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDockerApplication.class, args);
	}
@Bean
public CommandLineRunner initData(){
return (args) ->{};
}
}
