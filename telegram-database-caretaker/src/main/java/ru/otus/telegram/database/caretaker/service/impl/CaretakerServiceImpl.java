package ru.otus.telegram.database.caretaker.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.telegram.database.caretaker.exception.CheckDBNotCorrectException;
import ru.otus.telegram.database.caretaker.model.CheckResult;
import ru.otus.telegram.database.caretaker.model.DBServerModel;
import ru.otus.telegram.database.caretaker.service.api.CaretakerService;
import ru.otus.telegram.database.caretaker.service.api.CheckDBService;
import ru.otus.telegram.database.caretaker.service.api.DBServerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.otus.telegram.database.caretaker.service.impl.CheckDBServiceMongoImpl.MONGODB;
import static ru.otus.telegram.database.caretaker.service.impl.CheckDBServicePostgresImpl.POSTGRESQL;

@Service
public class CaretakerServiceImpl implements CaretakerService {

    private final CheckDBServicePostgresImpl checkDBServicePostgres;
    private final CheckDBServiceMongoImpl checkDBServiceMongo;
    private final DBServerService dbServerService;
    private final Map<String, CheckDBService> checkDBServiceMap = new HashMap<>();


    public CaretakerServiceImpl(CheckDBServicePostgresImpl checkDBServicePostgres,
                                CheckDBServiceMongoImpl checkDBServiceMongo, DBServerService dbServerService) {
        this.checkDBServicePostgres = checkDBServicePostgres;
        this.checkDBServiceMongo = checkDBServiceMongo;
        this.dbServerService = dbServerService;
        checkDBServiceMap.put(POSTGRESQL, checkDBServicePostgres);
        checkDBServiceMap.put(MONGODB, checkDBServiceMongo);
    }

    @Override
    public CheckResult checkDB(String dbServerModelId) {
        DBServerModel dbServerModel = dbServerService.getDBServerById(dbServerModelId);
        return checkOneDB(dbServerModel);
    }

    @Override
    public List<CheckResult> checkAllDB() {
        List<DBServerModel> dbServerModelList = dbServerService.getDBServers();
        List<CheckResult> resultList = new ArrayList<>();
        for (DBServerModel dbServerModel: dbServerModelList) {
            resultList.add(checkOneDB(dbServerModel));
        }
        return resultList;
    }

    private CheckResult checkOneDB(DBServerModel dbServerModel) {
        if (dbServerModel != null && !dbServerModel.getServerType().isEmpty() && checkDBServiceMap.containsKey(dbServerModel.getServerType())) {
            return checkDBServiceMap.get(dbServerModel.getServerType()).checkDB(dbServerModel);
        }
        throw new CheckDBNotCorrectException();
    }

}
