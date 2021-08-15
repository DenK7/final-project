package ru.otus.telegram.data.rest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import ru.otus.telegram.data.serializer.DateTimeSerializer;

import java.util.Date;

@Getter
@Setter
@ApiModel(description = "Параметры запроса логов")
public class CheckLogRequest {
    @ApiModelProperty(value = "Дата начала периода")
    @JsonSerialize(using = DateTimeSerializer.class)
    private Date dateFrom;
    @ApiModelProperty(value = "Дата окончания периода")
    @JsonSerialize(using = DateTimeSerializer.class)
    private Date dateTo;
}
