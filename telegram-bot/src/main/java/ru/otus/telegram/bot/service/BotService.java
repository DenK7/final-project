package ru.otus.telegram.bot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.otus.telegram.bot.config.BotConfig;

@Component
public class BotService extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final ExternalService externalService;

    public BotService(BotConfig botConfig, ExternalService externalService) {
        this.botConfig = botConfig;
        this.externalService = externalService;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getUserName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage.SendMessageBuilder builder =SendMessage.builder();
        String messageText;
        String chatId;
        if (update.getMessage() != null) {
            chatId = update.getMessage().getChatId().toString();
            builder.chatId(chatId);
            messageText = update.getMessage().getText();
        } else {
            chatId = update.getChannelPost().getChatId().toString();
            builder.chatId(chatId);
            messageText = update.getChannelPost().getText();
        }

        try {
            if (messageText.contains("/help")) {
                builder.text(getHelp());
            } else if (messageText.contains("/servers")) {
                builder.text(externalService.getAllDBServiceInfo());
            } else if (messageText.contains("/servername")) {
                builder.text(externalService.getDBServerByServerName(messageText.substring(12)));
            } else if (messageText.contains("/checkall")) {
                builder.text(externalService.checkAll());
            } else if (messageText.contains(("/checkname"))) {
                builder.text(externalService.checkByDBServerName(messageText.substring(11)));
            } else {
                builder.text("Я вас не понимаю");
            }
            execute(builder.build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private String getHelp() {
        return new String("/help - вызов списка команд \n"+
                "/servers - краткая информация обо всех серверах, для которых может быть проведена проверка\n"+
                "/servername - краткая информация о сервере по его имени (имя указывается после команды через пробел)\n"+
                "/checkall - проверка всех серверов\n"+
                "/checkname - проверка сервера по его имени (имя указывается после команды через пробел)\n");
    }
}
