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
import ru.otus.telegram.database.caretaker.model.CheckResult;
import ru.otus.telegram.database.caretaker.model.DBServerModel;
import ru.otus.telegram.database.caretaker.service.api.CheckDBService;

@Service
public class CheckDBServiceMongoImpl implements CheckDBService, ServerMonitorListener {

    public static final String MONGODB = "mongodb";

    @Override
    public CheckResult checkDB(DBServerModel dbServerModel) {
        try {
            MongoClientOptions clientOptions = new MongoClientOptions.Builder()
                    .addServerMonitorListener(this)
                    .build();
            MongoClient client = new MongoClient(new ServerAddress("localhost", 27017), clientOptions);
            MongoDatabase database = client.getDatabase("admin");
            Document commandResultDoc = database.runCommand(new BasicDBObject("hostInfo", 1));

//            Object system = commandResultDoc.get("system");
//            String hostname = "";
//            if (system instanceof Document) {
//                final Document systemDoc = (Document) system;
//                hostname = systemDoc.getString("hostname");
//            }
//
//            final ArrayList<String> collNames = getCollectionNames(mongoDbAccessor, profilingReader.getDatabase());
//            final MongoDatabase db = mongoDbAccessor.getMongoDatabase(profilingReader.getDatabase());
//            for(String collName : collNames){
//                Document collStats = db.runCommand(new Document("collStats", collName));
//                final List<Object> row = Lists.newArrayList();
//                row.add(profilingReader.getProfiledServerDto().getLabel());
//                row.add(hostname);
//                row.add(profilingReader.getDatabase());
//                row.add(collName);
//                row.add(collStats.getBoolean("sharded"));
//                row.add(Util.getNumber(collStats, "size",0));
//                row.add(collStats.getInteger("count"));
//                row.add(Util.getNumber(collStats, "avgObjSize",0));
//                row.add(Util.getNumber(collStats, "storageSize",0));
//                row.add(collStats.getBoolean("capped"));
//                row.add(collStats.getInteger("nindexes"));
//                row.add(Util.getNumber(collStats, "totalIndexSize",0));
//                row.add(((Document)collStats.get("indexSizes")).toJson());
//                table.addRow(row);
//            }

            client.close();
        } catch (Exception e) {

        }

//        checkLogService.saveLog(null);
        return null;
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
