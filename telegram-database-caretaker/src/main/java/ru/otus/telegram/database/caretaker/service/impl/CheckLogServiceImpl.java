package ru.otus.telegram.database.caretaker.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.telegram.data.model.CheckLogModel;
import ru.otus.telegram.data.model.CheckResult;
import ru.otus.telegram.data.model.DBServerModel;
import ru.otus.telegram.database.caretaker.dto.CheckLogDto;
import ru.otus.telegram.database.caretaker.entity.CheckLog;
import ru.otus.telegram.database.caretaker.repositories.CheckLogRepositories;
import ru.otus.telegram.database.caretaker.service.api.CheckLogService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CheckLogServiceImpl implements CheckLogService {

    private final CheckLogRepositories checkLogRepositories;
    private final CheckLogDto checkLogModelDto;

    public CheckLogServiceImpl(CheckLogRepositories checkLogRepositories, CheckLogDto checkLogModelDto) {
        this.checkLogRepositories = checkLogRepositories;
        this.checkLogModelDto = checkLogModelDto;
    }

    @Override
    public CheckResult saveLog(DBServerModel dbServerModel, String result, Boolean isWorking) {
        CheckLog logModel = checkLogModelDto.getCheckLogFromDBServerModel(dbServerModel);
        logModel.setCheckResult(result);
        logModel.setIsWorking(isWorking);
        logModel.setCheckDate(new Date());
        return checkLogModelDto.getCheckResultFromCheckLog(
                checkLogRepositories.save(logModel));
    }

    @Override
    public List<CheckLogModel> getCheckLogs() {
        List<ru.otus.telegram.database.caretaker.entity.CheckLog> checkLogList = checkLogRepositories.findAll();
        return getListModelFromListCheckLog(checkLogList);
    }

    @Override
    public List<CheckLogModel> getCheckLogsByDate(Date dateFrom, Date dateTo) {
        List<CheckLog> checkLogList = checkLogRepositories.findAllByCheckDateBetween(dateFrom, dateTo);
        return getListModelFromListCheckLog(checkLogList);
    }

    private List<CheckLogModel> getListModelFromListCheckLog(List<CheckLog> checkLogList) {
        if (checkLogList.isEmpty()) {
            return null;
        }
        List<CheckLogModel> checkLogModelModelList = new ArrayList<>();
        for (ru.otus.telegram.database.caretaker.entity.CheckLog checkLog: checkLogList) {
            checkLogModelModelList.add(checkLogModelDto.getCheckLogModelFromCheckLog(checkLog));
        }
        return checkLogModelModelList;
    }
}
