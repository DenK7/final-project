package ru.otus.telegram.database.caretaker.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.telegram.database.caretaker.model.CheckResult;
import ru.otus.telegram.database.caretaker.model.DBServerModel;
import ru.otus.telegram.database.caretaker.service.api.CheckDBService;
import ru.otus.telegram.database.caretaker.service.api.CheckLogService;

import java.sql.*;

@Service
public class CheckDBServicePostgresImpl implements CheckDBService {

    private final CheckLogService checkLogService;
    public static final String POSTGRESQL = "postgresql";

    public CheckDBServicePostgresImpl(CheckLogService checkLogService) {
        this.checkLogService = checkLogService;
    }

    @Override
    public CheckResult checkDB(DBServerModel dbServerModel) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://"+dbServerModel.getServerHost()
                        +":"+dbServerModel.getServerPort()+"/"
                        +dbServerModel.getDbName(), dbServerModel.getUserName(),
                dbServerModel.getUserPsw())) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery( "select version()" );

                String version = null;
                while ( rs.next() ) {
                    version = rs.getString("version");
                }
                return checkLogService.saveLog(dbServerModel, version, true);
            } else {
                return checkLogService.saveLog(dbServerModel, "Failed connection", false);
            }

        } catch (SQLException e) {
            return checkLogService.saveLog(dbServerModel,
                    "SQL State:" + e.getSQLState() + " \n Error: " +e.getMessage(), false);
        } catch (Exception e) {
            return checkLogService.saveLog(dbServerModel, e.getMessage(), false);
        }
    }
}
