package io.github.nenodias.pokeagenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableAutoConfiguration
@SpringBootApplication
public class PokeagendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeagendaApplication.class, args);
	}

}
