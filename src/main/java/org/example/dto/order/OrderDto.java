package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class OrderDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name_order")
    private String nameOrder;

    @JsonProperty("number_order")
    private String numberOrder;

    @JsonProperty("start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @JsonProperty("finish_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date finishDate;

    @JsonProperty("color")
    private String color;

    @JsonProperty("quadrature")
    private Float quadrature;

    @JsonProperty("cutters")
    private Set<CutterDto> cutters;

    @JsonProperty("baguettes")
    private Set<BaguetteDto> baguettes;

    @JsonProperty("technological_processes")
    private Set<TechnologicalProcessDto> technologicalProcesses;


}
