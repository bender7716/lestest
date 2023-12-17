package org.example.dto.technologicalprocess;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WorkplaceDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name_workplace")
    private String nameWorkplace;
}
