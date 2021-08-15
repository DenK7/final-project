package ru.otus.telegram.bot.service;

import org.springframework.stereotype.Service;
import ru.otus.telegram.bot.feign.CaretakerProxyService;
import ru.otus.telegram.data.model.CheckResult;
import ru.otus.telegram.data.model.DBServerModel;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class ExternalServiceImpl implements ExternalService{

    private final CaretakerProxyService proxyService;

    public ExternalServiceImpl(CaretakerProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @Override
    public String getAllDBServiceInfo() {
        List<DBServerModel> dbServerModelList = proxyService.getAllDBServer().getBody();
        if (dbServerModelList == null) {
            return "Any server not found";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (DBServerModel dbServerModel: dbServerModelList) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(getStringDBServer(dbServerModel));
        }
        return stringBuilder.toString();
    }

    @Override
    public String getDBServerByServerName(String name) {
        return getStringDBServer(Objects.requireNonNull(proxyService.getDBServerByServerName(name).getBody()));
    }

    private String getStringDBServer(DBServerModel dbServerModel) {
        return new String(" -> Server name: "+dbServerModel.getServerName()+
                "; Server host: "+dbServerModel.getServerHost()+"; Server type: "+dbServerModel.getServerType());
    }

    @Override
    public String checkAll() {
        List<CheckResult> checkResultList = proxyService.checkAll().getBody();
        if (checkResultList == null) {
            return "Any server not found";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (CheckResult checkResult: checkResultList) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(getStringCheckResult(checkResult));
        }
        return stringBuilder.toString();
    }

    @Override
    public String checkByDBServerName(String name) {
        return getStringCheckResult(Objects.requireNonNull(proxyService.checkByDBServerName(name).getBody()));
    }

    private String getStringCheckResult(CheckResult checkResult) {
        return new String(" -> Server name: "+checkResult.getServerName()+
                "; Server host: "+checkResult.getServerHost()+"; Server type: "+checkResult.getServerType()+
                "; Date check: " +checkResult.getCheckDate()+
                "; Result: "+checkResult.getIsWorking().toString().toUpperCase(Locale.ROOT));
    }

}
