package ru.otus.telegram.database.caretaker.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.telegram.database.caretaker.model.DBServerModel;
import ru.otus.telegram.database.caretaker.service.api.DBServerService;

import java.util.List;

@RestController
public class DBServerController {

    private final DBServerService dbServerService;

    public DBServerController(DBServerService dbServerService) {
        this.dbServerService = dbServerService;
    }

    @ApiOperation(value = "Сохранение сервера для мониторинга", response = DBServerModel.class)
    @PostMapping("/dbserver/server")
    public ResponseEntity<DBServerModel> add (
            @ApiParam("Описание сервера")
            @RequestBody DBServerModel dbServerModel) {
        return ResponseEntity.ok(dbServerService.saveDBServer(dbServerModel));
    }

    @ApiOperation(value = "Удаление сервера для мониторинга")
    @DeleteMapping("/dbserver/server/{id}")
    public ResponseEntity<?> deleteById (
            @ApiParam("Код сервера")
            @PathVariable String id) {
        dbServerService.deleteDBServer(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Получение сервера для мониторинга", response = DBServerModel.class)
    @GetMapping("/dbserver/server/{id}")
    public ResponseEntity<DBServerModel> getByServerId (
            @ApiParam("Код сервера")
            @PathVariable String id) {
        return ResponseEntity.ok(dbServerService.getDBServerById(id));
    }

    @ApiOperation(value = "Получение серверов для мониторинга", response = DBServerModel.class)
    @GetMapping("/dbserver/servers")
    public ResponseEntity<List<DBServerModel>> getAll () {
        return ResponseEntity.ok(dbServerService.getDBServers());
    }

}
