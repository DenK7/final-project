package ru.otus.telegram.database.caretaker.service.api;

import ru.otus.telegram.database.caretaker.model.CheckLogModel;
import ru.otus.telegram.database.caretaker.model.CheckResult;
import ru.otus.telegram.database.caretaker.model.DBServerModel;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface CheckLogService {
    CheckResult saveLog(DBServerModel checkLogModel, String result, Boolean isWorked);
    List<CheckLogModel> getCheckLogs() throws ParseException;
    List<CheckLogModel> getCheckLogsByDate(Date dateFrom, Date dateTo);
}
