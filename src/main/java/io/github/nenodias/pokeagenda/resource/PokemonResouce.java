package io.github.nenodias.pokeagenda.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.nenodias.pokeagenda.integration.pokeapi.PokeApiClient;
import io.github.nenodias.pokeagenda.integration.pokeapi.response.Pokemon;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemon")
public class PokemonResouce {

    @Autowired
    private PokeApiClient pokeApiClient;

    @GetMapping(value = "/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public Mono<Pokemon> index(@PathVariable("id") Long id) {
        return Mono
                .justOrEmpty(id)
                .map(pokeApiClient::findOne);
    }
}
