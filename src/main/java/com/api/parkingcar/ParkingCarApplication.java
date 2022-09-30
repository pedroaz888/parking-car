package com.api.parkingcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingCarApplication.class, args);
	}



}
