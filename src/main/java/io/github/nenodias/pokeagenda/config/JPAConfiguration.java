package io.github.nenodias.pokeagenda.config;

import com.zaxxer.hikari.HikariConfig;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.Executors;

import io.github.nenodias.pokeagenda.PokeagendaApplication;
import lombok.Builder;
import lombok.Getter;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@RefreshScope
@Configuration
@EnableJpaRepositories(basePackageClasses = PokeagendaApplication.class)
public class JPAConfiguration {

    private final HikariConfig hikariConfig;

    public JPAConfiguration(final HikariConfig hikariConfig) {
        this.hikariConfig = hikariConfig;
    }

    @Bean
    public JdbcScheduler jdbcScheduler() {
        return JdbcScheduler
                .builder()
                .scheduler(Schedulers.fromExecutor(Executors.newFixedThreadPool(hikariConfig.getMaximumPoolSize())))
                .build();
    }

    @Builder
    public static class JdbcScheduler {

        @Getter
        private final Scheduler scheduler;
    }
}