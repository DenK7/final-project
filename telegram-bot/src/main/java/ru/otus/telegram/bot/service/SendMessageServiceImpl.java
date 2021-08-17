package ru.otus.telegram.bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.otus.telegram.bot.config.BotConfig;
import ru.otus.telegram.bot.exception.SendMessageRuntimeException;

@Service
public class SendMessageServiceImpl implements SendMessageService {

    private final BotService botService;
    private final BotConfig botConfig;

    public SendMessageServiceImpl(BotService botService, BotConfig botConfig) {
        this.botService = botService;
        this.botConfig = botConfig;
    }

    @Override
    public void sendMessage(String message) {
        SendMessage.SendMessageBuilder messageBuilder = SendMessage.builder();
        messageBuilder.chatId(botConfig.getChatId());

        messageBuilder.parseMode(ParseMode.HTML);
        messageBuilder.text(message);
        try {
            botService.execute(messageBuilder.build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
            throw new SendMessageRuntimeException(e.getMessage());
        }
    }
}
