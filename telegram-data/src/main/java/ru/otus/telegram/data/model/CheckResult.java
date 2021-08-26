package ru.otus.telegram.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
