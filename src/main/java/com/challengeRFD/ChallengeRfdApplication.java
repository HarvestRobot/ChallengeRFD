package com.challengeRFD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class ChallengeRfdApplication {

	public static void main(String[] args) {
		//Timezone necessary for timestamp operations
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(ChallengeRfdApplication.class, args);
	}

}
