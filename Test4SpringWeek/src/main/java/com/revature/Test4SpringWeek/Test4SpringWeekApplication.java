package com.revature.Test4SpringWeek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.revature")
@EntityScan("com.revature.models")
@EnableJpaRepositories("com.revature.DAOs")
public class Test4SpringWeekApplication {

	public static void main(String[] args) {
		SpringApplication.run(Test4SpringWeekApplication.class, args);
	}

}
