package ru.otus.telegram.database.caretaker.service.api;

import ru.otus.telegram.database.caretaker.model.DBServerModel;

import java.util.List;

public interface DBServerService {
    DBServerModel addDBServer (DBServerModel model);
    void deleteDBServer (String id);
    DBServerModel updateDBServer (DBServerModel model);
    DBServerModel getDBServerById (String id);
    List<DBServerModel> getDBServers();
}
