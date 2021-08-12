package ru.otus.telegram.database.caretaker.service.api;

import ru.otus.telegram.database.caretaker.model.CheckResult;
import ru.otus.telegram.database.caretaker.model.DBServerModel;

public interface CheckDBService {

    CheckResult checkDB(DBServerModel dbServerModel);
}
