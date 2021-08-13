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

    @Field("server_type")
    private String serverType;

    @Field("server_host")
    private String serverHost;

    @Field("server_port")
    private String serverPort;

    @Field("db_name")
    private String dbName;

    @Field("check_date")
    private Date checkDate;

    @Field("check_result")
    private String checkResult;

    @Field("is_working")
    private Boolean isWorking;
}
