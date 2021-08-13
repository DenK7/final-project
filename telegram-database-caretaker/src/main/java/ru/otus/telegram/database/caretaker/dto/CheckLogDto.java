package ru.otus.telegram.database.caretaker.dto;

import ru.otus.telegram.database.caretaker.entity.CheckLog;
import ru.otus.telegram.database.caretaker.model.CheckLogModel;
import ru.otus.telegram.database.caretaker.model.CheckResult;
import ru.otus.telegram.database.caretaker.model.DBServerModel;

public interface CheckLogDto {
    CheckLogModel getCheckLogModelFromCheckLog(ru.otus.telegram.database.caretaker.entity.CheckLog checkLog);

    CheckLog getCheckLogFromDBServerModel(DBServerModel dbServerModel);

    CheckResult getCheckResultFromCheckLog(CheckLog checkLog);
}
