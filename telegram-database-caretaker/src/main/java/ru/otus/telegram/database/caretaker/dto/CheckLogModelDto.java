package ru.otus.telegram.database.caretaker.dto;

import ru.otus.telegram.database.caretaker.entity.CheckLog;
import ru.otus.telegram.database.caretaker.model.CheckLogModel;

public interface CheckLogModelDto {
    CheckLogModel getCheckLogModelFromCheckLog(CheckLog checkLog);

    CheckLog getCheckLogFromCheckLogModel(CheckLogModel checkLogModel);
}
