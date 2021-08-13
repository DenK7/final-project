package ru.otus.telegram.database.caretaker.service.api;

import ru.otus.telegram.database.caretaker.model.DBServerModel;

import java.util.List;

public interface DBServerService {
    DBServerModel saveDBServer(DBServerModel model);
    void deleteDBServer (String id);
    DBServerModel getDBServerById (String id);
    List<DBServerModel> getDBServers();
}
