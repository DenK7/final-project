package ru.otus.telegram.database.caretaker.service.api;

import ru.otus.telegram.data.model.DBServerModel;

import java.util.List;

public interface DBServerService {
    DBServerModel saveDBServer(DBServerModel model);
    void deleteDBServer (String id);
    DBServerModel getDBServerByName(String name);
    List<DBServerModel> getDBServers();
}
