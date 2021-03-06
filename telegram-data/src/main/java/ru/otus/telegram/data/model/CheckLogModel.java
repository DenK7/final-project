package ru.otus.telegram.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@ApiModel(description = "Лог опроса сервера")
public class CheckLogModel {
    @ApiModelProperty(value = "код")
    private String id;
    @ApiModelProperty(value = "Имя сервера")
    private String serverName;
    @ApiModelProperty(value = "Тип сбазы данных (mongodb, postgresql)")
    private String serverType;
    @ApiModelProperty(value = "host базы данных")
    private String serverHost;
    @ApiModelProperty(value = "порт базы данных")
    private String serverPort;
    @ApiModelProperty(value = "имя базы данных / если не обходимо")
    private String dbName;
    @ApiModelProperty(value = "Дата опроса")
    private Date checkDate;
    @ApiModelProperty(value = "Результат опроса")
    private Boolean isWorking;
    @ApiModelProperty(value = "Результат опроса")
    private String checkResult;
}
