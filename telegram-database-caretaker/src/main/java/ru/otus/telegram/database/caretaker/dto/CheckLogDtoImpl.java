package ru.otus.telegram.database.caretaker.dto;

import org.springframework.stereotype.Component;
import ru.otus.telegram.data.model.CheckLogModel;
import ru.otus.telegram.data.model.CheckResult;
import ru.otus.telegram.data.model.DBServerModel;
import ru.otus.telegram.database.caretaker.entity.CheckLog;

@Component
public class CheckLogDtoImpl implements CheckLogDto {

    @Override
    public CheckLogModel getCheckLogModelFromCheckLog(ru.otus.telegram.database.caretaker.entity.CheckLog checkLog) {
        return CheckLogModel.builder()
                .id(checkLog.getId())
                .serverName(checkLog.getServerName())
                .serverType(checkLog.getServerType())
                .serverHost(checkLog.getServerHost())
                .serverPort(checkLog.getServerPort())
                .dbName(checkLog.getDbName())
                .checkDate(checkLog.getCheckDate())
                .isWorking((checkLog.getIsWorking()))
                .checkResult(checkLog.getCheckResult())
                .build();
    }

    @Override
    public CheckLog getCheckLogFromDBServerModel(DBServerModel dbServerModel) {
        return CheckLog.builder()
                .serverName(dbServerModel.getServerName())
                .serverType(dbServerModel.getServerType())
                .serverHost(dbServerModel.getServerHost())
                .serverPort(dbServerModel.getServerPort())
                .dbName(dbServerModel.getDbName())
                .build();
    }

    @Override
    public CheckResult getCheckResultFromCheckLog(CheckLog checkLog){
        return CheckResult.builder()
                .serverName(checkLog.getServerName())
                .serverType(checkLog.getServerType())
                .serverHost(checkLog.getServerHost())
                .dbName(checkLog.getDbName())
                .checkDate(checkLog.getCheckDate())
                .isWorking(checkLog.getIsWorking())
                .checkResult(checkLog.getCheckResult())
                .build();
    };
}
