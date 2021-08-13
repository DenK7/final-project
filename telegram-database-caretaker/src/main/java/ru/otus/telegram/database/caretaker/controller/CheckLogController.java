package ru.otus.telegram.database.caretaker.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.telegram.database.caretaker.controller.model.CheckLogRequest;
import ru.otus.telegram.database.caretaker.model.CheckLogModel;
import ru.otus.telegram.database.caretaker.service.api.CheckLogService;

import java.util.List;

@RestController
public class CheckLogController {

    private final CheckLogService checkLogService;

    public CheckLogController(CheckLogService checkLogService) {
        this.checkLogService = checkLogService;
    }

    @ApiOperation(value = "Список логов за период", response = CheckLogModel.class)
    @GetMapping("/check-log/logs")
    public ResponseEntity<List<CheckLogModel>> getCheckLogsByDate (
            @ApiParam("Дата начала")
            @RequestBody CheckLogRequest param) {
        checkLogService.getCheckLogsByDate(param.getDateFrom(), param.getDateTo());
        return ResponseEntity.ok().build();
    }
}
