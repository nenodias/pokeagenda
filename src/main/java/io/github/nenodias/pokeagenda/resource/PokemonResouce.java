package io.github.nenodias.pokeagenda.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class PokemonResouce {

    @GetMapping()
    public Mono<String> index() {
        return Mono.justOrEmpty("Hello world");
    }
}
