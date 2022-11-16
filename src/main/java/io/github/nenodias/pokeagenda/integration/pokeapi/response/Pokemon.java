package io.github.nenodias.pokeagenda.integration.pokeapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Pokemon {

    @JsonProperty("base_experience")
    private Long baseExperience;
    private BigDecimal height;
    private Long id;
    @JsonProperty("is_default")
    private Boolean isDefault;
    private String name;
    private Integer order;
    private BigDecimal weight;

}
