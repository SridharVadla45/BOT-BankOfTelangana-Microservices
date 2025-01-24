package com.bot.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts Microservice Rest API Documentation",
				description = "Bank Of Telangana - Accounts Service Rest API Documentation",
				version = "version 1",
				contact = @Contact(
						name = "Sridhar Vadla",
						email = "vadlasreedhar45@outlook.com",
						url="https://github.com/SridharVadla45/"
				),
				license = @License(
						name = "UnLicensed"
				)

		),
		externalDocs =@ExternalDocumentation(
				description = "Check for more detailed Documentation ",
				url = "https://github.com/SridharVadla45/BOT-BankOfTelangana-Microservices/blob/main/Readme.md"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
