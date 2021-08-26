package ru.otus.telegram.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TelegramConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramConfigApplication.class, args);
	}

}
