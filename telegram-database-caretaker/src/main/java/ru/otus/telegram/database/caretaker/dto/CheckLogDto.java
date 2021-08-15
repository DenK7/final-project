package ru.otus.telegram.database.caretaker.dto;

import ru.otus.telegram.data.model.CheckLogModel;
import ru.otus.telegram.data.model.CheckResult;
import ru.otus.telegram.data.model.DBServerModel;
import ru.otus.telegram.database.caretaker.entity.CheckLog;

public interface CheckLogDto {
    CheckLogModel getCheckLogModelFromCheckLog(ru.otus.telegram.database.caretaker.entity.CheckLog checkLog);

    CheckLog getCheckLogFromDBServerModel(DBServerModel dbServerModel);

    CheckResult getCheckResultFromCheckLog(CheckLog checkLog);
}
