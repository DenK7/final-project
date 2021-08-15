package ru.otus.telegram.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
