package ru.otus.telegram.database.caretaker.service.api;

import ru.otus.telegram.database.caretaker.model.CheckLogModel;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface CheckLogService {
    CheckLogModel saveLog(CheckLogModel checkLogModel);
    List<CheckLogModel> getCheckLogs() throws ParseException;
    List<CheckLogModel> getCheckLogsByDate(Date dateFrom, Date dateTo);
}
