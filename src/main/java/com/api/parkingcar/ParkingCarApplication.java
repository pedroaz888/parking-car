package com.api.parkingcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ParkingCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingCarApplication.class, args);

		System.out.println(new BCryptPasswordEncoder().encode("1234"));


	}



}
