package ru.otus.telegram.database.caretaker.service.api;

import ru.otus.telegram.data.model.CheckResult;

import java.util.List;

public interface CaretakerService {

    CheckResult checkDB(String dbServerModelName);
    List<CheckResult> checkAllDB();
}
