package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.dto.technologicalprocess.WorkplaceDto;

import java.util.Date;

@Data
public class TechnologicalProcessDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("time_start_work")
    private Date timeStartWork;

    @JsonProperty("time_finish_work")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date timeFinishWork;

    @JsonProperty("operation_code")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Integer operationCode;

    @JsonProperty("workplace")
    private WorkplaceDto workplace;
}
