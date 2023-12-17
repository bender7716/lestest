package org.example.dto.technologicalprocess;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderDto {
    @JsonProperty("id")
    private Long id;


    @JsonProperty("name_order")
    private String nameOrder;


    @JsonProperty("number_order")
    private String numberOrder;
}
