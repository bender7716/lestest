package org.example.dto.technologicalprocess;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TechnologicalProcessDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("time_start_work")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date timeStartWork;

    @JsonProperty("time_finish_work")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date timeFinishWork;

    @JsonProperty("operation_code")
    private Integer operationCode;

    @JsonProperty("workplace")
    private WorkplaceDto workplace;

    @JsonProperty("order")
    private OrderDto order;
}
