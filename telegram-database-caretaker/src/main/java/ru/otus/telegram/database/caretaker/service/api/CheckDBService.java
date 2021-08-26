package ru.otus.telegram.database.caretaker.service.api;

import ru.otus.telegram.data.model.CheckResult;
import ru.otus.telegram.data.model.DBServerModel;

public interface CheckDBService {

    CheckResult checkDB(DBServerModel dbServerModel);
}
