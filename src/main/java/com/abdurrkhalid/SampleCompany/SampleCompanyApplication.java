package com.abdurrkhalid.SampleCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SampleCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleCompanyApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello!";
	}

}
