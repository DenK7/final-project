package ru.otus.telegram.bot.config;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.otus.telegram.bot.service.BotService;

import javax.annotation.PostConstruct;

@Component
public class BotInit {

    private final BotService botService;

    public BotInit(BotService botService) {
        this.botService = botService;
    }

    @PostConstruct
    public void Init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(botService);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
