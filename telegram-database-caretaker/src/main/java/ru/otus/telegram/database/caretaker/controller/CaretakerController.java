package ru.otus.telegram.database.caretaker.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.telegram.database.caretaker.model.CheckResult;
import ru.otus.telegram.database.caretaker.service.api.CaretakerService;

import java.util.List;

@RestController
public class CaretakerController {

    private final CaretakerService caretakerService;

    public CaretakerController(CaretakerService caretakerService) {
        this.caretakerService = caretakerService;
    }

    @ApiOperation(value = "Опрос всех серверов в списке", response = CheckResult.class)
    @GetMapping("/caretaker/all")
    public ResponseEntity<List<CheckResult>> checkAll () {
        return ResponseEntity.ok(caretakerService.checkAllDB());
    }

    @ApiOperation(value = "Проверка сервера по id", response = CheckResult.class)
    @GetMapping("/caretaker/check/{id}")
    public ResponseEntity<CheckResult> getByServerId (
            @ApiParam("Код сервера")
            @PathVariable String id) {
        return ResponseEntity.ok(caretakerService.checkDB(id));
    }
}
