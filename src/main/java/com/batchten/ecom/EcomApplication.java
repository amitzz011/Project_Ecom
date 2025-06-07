package com.batchten.ecom;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.batchten.ecom")
@OpenAPIDefinition(
		info = @Info(
				title = "Ecom application API",
				version = "v1.0",
				description = "This API will manage your Product"
		),
		servers = @Server(
				url = "http://localhost:8083/EcomApi",
				description = "This application is deployed in following url location"

		)
)
public class EcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
	}

}
