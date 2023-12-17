package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CutterDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("cutter_name")
    private String cutterName;
}
