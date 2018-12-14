package com.galvanize.assessment.newzorktimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.delivery.request"})
public class NewzorktimesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewzorktimesApplication.class, args);
	}

}

