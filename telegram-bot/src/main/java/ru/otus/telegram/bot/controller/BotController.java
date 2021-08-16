package ru.otus.telegram.bot.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    @ApiOperation(value = "Отправка сообщения в телеграм")
    @PostMapping("/send-message")
    public ResponseEntity<?> sendMessageOnTelegram (
            @ApiParam("Сообщение")
            @RequestBody String message) {
        if (message == null || message.isEmpty()) {
            return ResponseEntity.ok().build();
        }

        System.out.println(message);
        return ResponseEntity.ok().build();
    }
}
