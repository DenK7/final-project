package ru.otus.telegram.database.caretaker.service.api;

import ru.otus.telegram.database.caretaker.model.CheckResult;

import java.util.List;

public interface CaretakerService {

    CheckResult checkDB(String dbServerModelId);
    List<CheckResult> checkAllDB();
}
