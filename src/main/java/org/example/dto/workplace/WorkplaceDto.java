package org.example.dto.workplace;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class WorkplaceDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name_workplace")
    private String nameWorkplace;

    @JsonProperty("technological_processes")
    private Set<TechnologicalProcessDto> technologicalProcesses;
}
