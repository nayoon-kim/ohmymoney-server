package com.najinji.ohmymoneyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
@EnableCaching
public class OhmymoneyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OhmymoneyServerApplication.class, args);
    }
}
