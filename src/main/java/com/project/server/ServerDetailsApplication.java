package com.project.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServerDetailsApplication {

	@GetMapping("/welcome")
	public String welcome(){
		return "Hello welcome to CI-CD sample application";
	}
	public static void main(String[] args) {
		SpringApplication.run(ServerDetailsApplication.class, args);
	}

}
