package ru.otus.telegram.bot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class BotConfig {

    private String userName;
    private String token;
    private String chatId;

    public BotConfig(@Value("${telegram.bot.name}") String userName,
                     @Value("${telegram.bot.token}") String token,
                     @Value("${telegram.bot.chatId}") String chatId) {
        this.userName = userName;
        this.token = token;
        this.chatId = chatId;
    }

}
