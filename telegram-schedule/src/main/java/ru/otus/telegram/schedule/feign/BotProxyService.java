package ru.otus.telegram.schedule.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "telegram-bot")
public interface BotProxyService {

    @PostMapping("/send-message")
    ResponseEntity<?> sendMessageOnTelegram(@RequestBody String message);

}
