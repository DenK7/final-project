package ru.otus.telegram.database.caretaker.dto;

import org.springframework.stereotype.Component;
import ru.otus.telegram.database.caretaker.entity.CheckLog;
import ru.otus.telegram.database.caretaker.model.CheckLogModel;

@Component
public class CheckLogModelDtoImpl implements CheckLogModelDto{

    @Override
    public CheckLogModel getCheckLogModelFromCheckLog(CheckLog checkLog) {
        return CheckLogModel.builder()
                .id(checkLog.getId())
                .serverName(checkLog.getServerName())
                .checkDate(checkLog.getCheckDate())
                .build();
    }

    @Override
    public CheckLog getCheckLogFromCheckLogModel(CheckLogModel checkLogModel) {
        return CheckLog.builder()
                .serverName(checkLogModel.getServerName())
                .checkDate(checkLogModel.getCheckDate())
                .build();
    }
}
