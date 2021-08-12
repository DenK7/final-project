package ru.otus.telegram.database.caretaker.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class CheckResult {

    private String serverName;
    private Date checkDate;
    private Boolean checkResult;
}
