package ru.otus.telegram.database.caretaker.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.event.ServerHeartbeatFailedEvent;
import com.mongodb.event.ServerHeartbeatStartedEvent;
import com.mongodb.event.ServerHeartbeatSucceededEvent;
import com.mongodb.event.ServerMonitorListener;
import org.bson.Document;
import org.springframework.stereotype.Service;
import ru.otus.telegram.data.model.CheckResult;
import ru.otus.telegram.data.model.DBServerModel;
import ru.otus.telegram.database.caretaker.service.api.CheckDBService;
import ru.otus.telegram.database.caretaker.service.api.CheckLogService;

import static ru.otus.telegram.database.caretaker.service.CommonService.parsObjectToJsonString;

@Service
public class CheckDBServiceMongoImpl implements CheckDBService, ServerMonitorListener {

    public static final String MONGODB = "mongodb";
    private final CheckLogService checkLogService;

    public CheckDBServiceMongoImpl(CheckLogService checkLogService) {
        this.checkLogService = checkLogService;
    }

    @Override
    public CheckResult checkDB(DBServerModel dbServerModel) {

            MongoClientOptions clientOptions = new MongoClientOptions.Builder()
                    .addServerMonitorListener(this)
                    .build();
        try (MongoClient client = new MongoClient(new ServerAddress(dbServerModel.getServerHost()
                    , Integer.parseInt(dbServerModel.getServerPort())), clientOptions)) {

            MongoDatabase database = client.getDatabase(dbServerModel.getDbName());
            Document commandResultDoc = database.runCommand(new BasicDBObject("hostInfo", 1));

            String result = parsObjectToJsonString(commandResultDoc);

            client.close();
            // можно хранить сжатый
            return checkLogService.saveLog(dbServerModel, result, true);
        } catch (Exception e) {
            // можно хранить сжатый стектрейс
            return checkLogService.saveLog(dbServerModel, e.getMessage(), false);
        }
    }

    @Override
    public void serverHearbeatStarted(ServerHeartbeatStartedEvent serverHeartbeatStartedEvent) {

    }

    @Override
    public void serverHeartbeatSucceeded(ServerHeartbeatSucceededEvent serverHeartbeatSucceededEvent) {

    }

    @Override
    public void serverHeartbeatFailed(ServerHeartbeatFailedEvent serverHeartbeatFailedEvent) {

    }
}
