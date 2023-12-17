package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaguetteDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("baguette_name")
    private String baguetteName;
}
