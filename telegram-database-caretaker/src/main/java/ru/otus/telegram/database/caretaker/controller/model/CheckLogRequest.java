package ru.otus.telegram.database.caretaker.controller.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Параметры запроса логов")
public class CheckLogRequest {
    @ApiModelProperty(value = "Дата начала периода")
    private String dateFrom;
    @ApiModelProperty(value = "Дата окончания периода")
    private String dateTo;
}
