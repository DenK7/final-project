package ru.otus.telegram.telegramzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class TelegramZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramZuulApplication.class, args);
	}

}
