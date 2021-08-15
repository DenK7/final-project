package ru.otus.telegram.bot.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.telegram.data.model.CheckResult;
import ru.otus.telegram.data.model.DBServerModel;

import java.util.List;

@FeignClient(name = "telegram-database-caretaker")
public interface CaretakerProxyService {

    @GetMapping("/dbserver/server/{name}")
    ResponseEntity<DBServerModel> getDBServerByServerName(@PathVariable String name);

    @GetMapping("/dbserver/servers")
    ResponseEntity<List<DBServerModel>> getAllDBServer();

    @GetMapping("/caretaker/all")
    ResponseEntity<List<CheckResult>> checkAll();

    @GetMapping("/caretaker/check/{name}")
    ResponseEntity<CheckResult> checkByDBServerName(@PathVariable String name);
}
