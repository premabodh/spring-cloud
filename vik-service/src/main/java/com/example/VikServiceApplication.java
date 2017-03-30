package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class VikServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VikServiceApplication.class, args);
	}
}

@RestController
class RestApp
{
	 @RequestMapping("/vik")
	    public String getProduct() {
	    	
	    	System.out.println("Inside vikash Service *********************************");

	        return "Return from Vik";
	    }
}
