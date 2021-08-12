package ru.otus.telegram.database.caretaker.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.telegram.database.caretaker.model.CheckResult;
import ru.otus.telegram.database.caretaker.model.DBServerModel;
import ru.otus.telegram.database.caretaker.service.api.CheckDBService;

@Service
public class CheckDBServicePostgresImpl implements CheckDBService {

    public static final String POSTGRESQL = "postgresql";

    @Override
    public CheckResult checkDB(DBServerModel dbServerModel) {


//        checkLogService.saveLog(null);
        return null;
    }
}
