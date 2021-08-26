package ru.otus.telegram.schedule.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.otus.telegram.data.model.CheckResult;
import ru.otus.telegram.schedule.feign.BotProxyService;
import ru.otus.telegram.schedule.feign.CaretakerProxyService;

import java.util.List;

@Component
public class ScheduleService {

    private final CaretakerProxyService caretakerProxyService;
    private final BotProxyService proxyService;

    public ScheduleService(CaretakerProxyService caretakerProxyService, BotProxyService proxyService) {
        this.caretakerProxyService = caretakerProxyService;
        this.proxyService = proxyService;
    }

    @Scheduled(fixedDelayString = "${schedule.seconds}")
    public void checkDB() {
        List<CheckResult> checkResultList = caretakerProxyService.checkAll().getBody();
        assert checkResultList != null;
        for (CheckResult checkResult: checkResultList) {
            if (!checkResult.getIsWorking()) {
                String msg = "ВНИМАНИЕ!!! Не отвечает сервер: "
                        + checkResult.getServerName() + "; Host: " + checkResult.getServerHost()
                        + "; Тип базы данных: " + checkResult.getServerType()
                        + "; Дата проверки: " + checkResult.getCheckDate()
                        + "; Ошибка: " + checkResult.getCheckResult();
                proxyService.sendMessageOnTelegram(msg);
            }
        }
    }
}
