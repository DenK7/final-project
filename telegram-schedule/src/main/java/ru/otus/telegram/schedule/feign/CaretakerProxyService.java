package ru.otus.telegram.schedule.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.telegram.data.model.CheckResult;

import java.util.List;

@FeignClient(name = "telegram-database-caretaker")
public interface CaretakerProxyService {

    @GetMapping("/caretaker/all")
    ResponseEntity<List<CheckResult>> checkAll();
}
