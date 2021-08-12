package ru.otus.telegram.database.caretaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories(basePackages = "ru.otus.telegram.database.caretaker.repositories")
public class TelegramDatabaseCaretakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramDatabaseCaretakerApplication.class, args);
	}

}
