package ru.otus.telegram.bot.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.telegram.bot.service.SendMessageService;

@RestController
public class BotController {

    private final SendMessageService sendMessageService;

    public BotController(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @ApiOperation(value = "Отправка сообщения в телеграм")
    @PostMapping("/send-message")
    public ResponseEntity<?> sendMessageOnTelegram (
            @ApiParam("Сообщение")
            @RequestBody String message) {
        if (message == null || message.isEmpty()) {
            return ResponseEntity.ok().build();
        }

        sendMessageService.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
