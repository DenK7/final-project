package ru.otus.telegram.database.caretaker.dto;

import ru.otus.telegram.database.caretaker.entity.DBServer;
import ru.otus.telegram.database.caretaker.model.DBServerModel;

public interface DBServerModelDto {
    DBServerModel getDbServerModelFromDbServer(DBServer dbServer);
    void updateDbServerFromDbServerModel(DBServer dbServer, DBServerModel model);

    DBServer getDbServerFromDbServerModel(DBServerModel dbServerModel);
}
