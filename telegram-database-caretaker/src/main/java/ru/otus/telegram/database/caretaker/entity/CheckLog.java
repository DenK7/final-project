package ru.otus.telegram.database.caretaker.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(value = "check_log")
@Builder
public class CheckLog {
    @Id
    private String id;

    @Field("server_name")
    private String serverName;

    @Field("check_date")
    private Date checkDate;
}
