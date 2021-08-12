package ru.otus.telegram.database.caretaker.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DBServerModel {
    private String id;
    private String serverName;
    private String serverType;
}
