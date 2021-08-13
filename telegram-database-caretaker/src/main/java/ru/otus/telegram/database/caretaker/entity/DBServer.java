package ru.otus.telegram.database.caretaker.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(value = "db_server")
@Builder
public class DBServer {
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

    @Field("user_name")
    private String userName;

    @Field("user_psw")
    private String userPsw;

}
