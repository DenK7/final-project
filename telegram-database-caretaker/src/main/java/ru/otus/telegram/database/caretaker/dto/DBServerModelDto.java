package ru.otus.telegram.database.caretaker.dto;

import ru.otus.telegram.data.model.DBServerModel;
import ru.otus.telegram.database.caretaker.entity.DBServer;

public interface DBServerModelDto {
    DBServerModel getDbServerModelFromDbServer(DBServer dbServer);
    void updateDbServerFromDbServerModel(DBServer dbServer, DBServerModel model);

    DBServer getDbServerFromDbServerModel(DBServerModel dbServerModel);
}
