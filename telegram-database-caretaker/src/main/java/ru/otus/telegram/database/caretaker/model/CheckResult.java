package ru.otus.telegram.database.caretaker.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@ApiModel(description = "Результат опроса сервера")
public class CheckResult {

    @ApiModelProperty(value = "Имя сервера")
    private String serverName;
    @ApiModelProperty(value = "Тип сбазы данных (mongodb, postgresql)")
    private String serverType;
    @ApiModelProperty(value = "host базы данных")
    private String serverHost;
    @ApiModelProperty(value = "имя базы данных")
    private String dbName;
    @ApiModelProperty(value = "Результат опроса")
    private Boolean isWorking;
    @ApiModelProperty(value = "Дата опроса")
    private Date checkDate;
    @ApiModelProperty(value = "Результат опроса")
    private String checkResult;
}
