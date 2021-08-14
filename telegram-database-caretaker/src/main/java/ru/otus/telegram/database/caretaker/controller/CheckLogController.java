package ru.otus.telegram.database.caretaker.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.telegram.database.caretaker.controller.model.CheckLogRequest;
import ru.otus.telegram.database.caretaker.exception.DateIsNotCorrectException;
import ru.otus.telegram.database.caretaker.model.CheckLogModel;
import ru.otus.telegram.database.caretaker.service.api.CheckLogService;

import java.util.Date;
import java.util.List;

@RestController
public class CheckLogController {

    private final CheckLogService checkLogService;

    public CheckLogController(CheckLogService checkLogService) {
        this.checkLogService = checkLogService;
    }

    @ApiOperation(value = "Список логов за период", response = CheckLogModel.class)
    @PostMapping("/check-log/logs")
    public ResponseEntity<List<CheckLogModel>> getCheckLogsByDate (
            @ApiParam("Начало периода")
            @RequestBody CheckLogRequest param) {
        if (param.getDateFrom() == null) {
            throw new DateIsNotCorrectException("Start date not specified");
        }
        if (param.getDateTo() == null) {
            throw new DateIsNotCorrectException("End date not specified");
        }
        return ResponseEntity.ok(checkLogService.getCheckLogsByDate(param.getDateFrom(), param.getDateTo()));
    }
}
