package ru.otus.telegram.database.caretaker.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.telegram.database.caretaker.dto.CheckLogModelDto;
import ru.otus.telegram.database.caretaker.entity.CheckLog;
import ru.otus.telegram.database.caretaker.model.CheckLogModel;
import ru.otus.telegram.database.caretaker.repositories.CheckLogRepositories;
import ru.otus.telegram.database.caretaker.service.api.CheckLogService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CheckLogServiceImpl implements CheckLogService {

    private final CheckLogRepositories checkLogRepositories;
    private final CheckLogModelDto checkLogModelDto;

    public CheckLogServiceImpl(CheckLogRepositories checkLogRepositories, CheckLogModelDto checkLogModelDto) {
        this.checkLogRepositories = checkLogRepositories;
        this.checkLogModelDto = checkLogModelDto;
    }

    @Override
    public CheckLogModel saveLog(CheckLogModel checkLogModel) {
        return checkLogModelDto.getCheckLogModelFromCheckLog(checkLogRepositories.save(checkLogModelDto.getCheckLogFromCheckLogModel(checkLogModel)));
    }

    @Override
    public List<CheckLogModel> getCheckLogs() {
        List<CheckLog> checkLogList = checkLogRepositories.findAll();
        return getListModelFromListCheckLog(checkLogList);
    }

    @Override
    public List<CheckLogModel> getCheckLogsByDate(Date dateFrom, Date dateTo) {
        List<CheckLog> checkLogList = checkLogRepositories.findAllByCheckDateAfterAndCheckDateBefore(dateFrom, dateTo);
        return getListModelFromListCheckLog(checkLogList);
    }

    private List<CheckLogModel> getListModelFromListCheckLog(List<CheckLog> checkLogList) {
        if (checkLogList.isEmpty()) {
            return null;
        }
        List<CheckLogModel> checkLogModelList = new ArrayList<>();
        for (CheckLog checkLog: checkLogList) {
            checkLogModelList.add(checkLogModelDto.getCheckLogModelFromCheckLog(checkLog));
        }
        return checkLogModelList;
    }
}
