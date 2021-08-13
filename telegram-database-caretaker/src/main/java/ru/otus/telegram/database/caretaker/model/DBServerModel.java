package ru.otus.telegram.database.caretaker.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Getter
@Setter
@ApiModel(description = "Описание сервера")
public class DBServerModel {
    @ApiModelProperty(value = "код")
    private String id;
    @ApiModelProperty(value = "Краткое наименование")
    private String serverName;
    @ApiModelProperty(value = "Тип сбазы данных (mongodb, postgresql)")
    private String serverType;
    @ApiModelProperty(value = "host базы данных")
    private String serverHost;
    @ApiModelProperty(value = "порт базы данных")
    private String serverPort;
    @ApiModelProperty(value = "имя базы данных / если не обходимо")
    private String dbName;
    @ApiModelProperty(value = "login / если не обходимо")
    private String userName;
    @ApiModelProperty(value = "password / если не обходимо")
    private String userPsw;

}
