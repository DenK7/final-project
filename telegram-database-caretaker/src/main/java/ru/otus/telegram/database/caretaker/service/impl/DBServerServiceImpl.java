package ru.otus.telegram.database.caretaker.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.telegram.database.caretaker.dto.DBServerModelDto;
import ru.otus.telegram.database.caretaker.entity.DBServer;
import ru.otus.telegram.database.caretaker.exception.DBServerAlreadyExistException;
import ru.otus.telegram.database.caretaker.exception.DBServerNotCorrectException;
import ru.otus.telegram.database.caretaker.exception.DBServerNotFoundException;
import ru.otus.telegram.database.caretaker.model.DBServerModel;
import ru.otus.telegram.database.caretaker.repositories.DBServerRepositories;
import ru.otus.telegram.database.caretaker.service.api.DBServerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DBServerServiceImpl implements DBServerService {

    private final DBServerRepositories dbServerRepositories;
    private final DBServerModelDto dbServerModelDto;

    public DBServerServiceImpl(DBServerRepositories dbServerRepositories, DBServerModelDto dbServerModelDto) {
        this.dbServerRepositories = dbServerRepositories;
        this.dbServerModelDto = dbServerModelDto;
    }

    @Override
    public void deleteDBServer(String id) {
        Optional<DBServer> dbServerOptional = dbServerRepositories.findById(id);
        dbServerOptional.ifPresent(dbServerRepositories::delete);
    }

    @Override
    public DBServerModel saveDBServer(DBServerModel model) {
        if (model == null) {
            throw new DBServerNotCorrectException();
        }
        if (model.getId() != null && !model.getId().isEmpty()) {
            Optional<DBServer> dbServerOptional = dbServerRepositories.findById(model.getId());
            if (dbServerOptional.isPresent()) {
                DBServer dbServer = dbServerOptional.get();
                dbServerModelDto.updateDbServerFromDbServerModel(dbServer, model);
                DBServer dbServerSave = dbServerRepositories.save(dbServer);
                return dbServerModelDto.getDbServerModelFromDbServer(dbServerSave);
            }
            throw new DBServerNotFoundException();
        } else {
            //проверка на дублирование, можно добавить еще критерии
            if (dbServerRepositories.findDBServerByServerName(model.getServerName()).isPresent()) {
                throw new DBServerAlreadyExistException();
            }
            return dbServerModelDto.getDbServerModelFromDbServer(dbServerRepositories.save(dbServerModelDto.getDbServerFromDbServerModel(model)));
        }
    }

    @Override
    public DBServerModel getDBServerById(String id) {
        Optional<DBServer> dbServerOptional = dbServerRepositories.findById(id);
        if (dbServerOptional.isPresent()) {
            return dbServerModelDto.getDbServerModelFromDbServer(dbServerOptional.get());
        }
        throw new DBServerNotFoundException();
    }

    @Override
    public List<DBServerModel> getDBServers() {
        List<DBServer> dbServerList = dbServerRepositories.findAll();
        if (dbServerList.isEmpty()) {
            return null;
        }
        List<DBServerModel> dbServerModelList = new ArrayList<>();
        for (DBServer dbServer: dbServerList){
            dbServerModelList.add(dbServerModelDto.getDbServerModelFromDbServer(dbServer));
        }
        return dbServerModelList;
    }
}
