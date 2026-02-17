package com.theMungai.learning_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(Main.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);

		System.out.println(myFirstService.tellAStory());
	}

}
