package io.github.nenodias.pokeagenda.integration.pokeapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.nenodias.pokeagenda.integration.pokeapi.response.Pokemon;

@FeignClient(value = "pokemon", url = "https://pokeapi.co/api/v2")
public interface PokeApiClient {

    @GetMapping("/pokemon/{id}")
    Pokemon findOne(@PathVariable("id") Long id);

}
