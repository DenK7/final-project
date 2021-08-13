package ru.otus.telegram.database.caretaker.dto;

import org.springframework.stereotype.Component;
import ru.otus.telegram.database.caretaker.entity.DBServer;
import ru.otus.telegram.database.caretaker.model.DBServerModel;

@Component
public class DBServerModelDtoImpl implements DBServerModelDto{
    @Override
    public DBServerModel getDbServerModelFromDbServer(DBServer dbServer) {
        return DBServerModel.builder()
                .id(dbServer.getId())
                .serverName(dbServer.getServerName())
                .serverType(dbServer.getServerType())
                .serverHost(dbServer.getServerHost())
                .serverPort(dbServer.getServerPort())
                .dbName(dbServer.getDbName())
                .userName(dbServer.getUserName())
                .userPsw(dbServer.getUserPsw())
                .build();
    }

    @Override
    public void updateDbServerFromDbServerModel(DBServer dbServer, DBServerModel model) {
        dbServer.setServerName(model.getServerName());
        dbServer.setServerType(model.getServerType());
        dbServer.setServerHost(model.getServerHost());
        dbServer.setServerPort(model.getServerPort());
        dbServer.setDbName(model.getDbName());
        dbServer.setUserName(model.getUserName());
        dbServer.setUserPsw(model.getUserPsw());
    }

    @Override
    public DBServer getDbServerFromDbServerModel(DBServerModel dbServerModel) {
        return DBServer.builder()
                .serverName(dbServerModel.getServerName())
                .serverType(dbServerModel.getServerType())
                .serverHost(dbServerModel.getServerHost())
                .serverPort(dbServerModel.getServerPort())
                .dbName(dbServerModel.getDbName())
                .userName(dbServerModel.getUserName())
                .userPsw(dbServerModel.getUserPsw())
                .build();
    }
}
