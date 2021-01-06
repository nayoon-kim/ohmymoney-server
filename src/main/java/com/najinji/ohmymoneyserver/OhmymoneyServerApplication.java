package com.najinji.ohmymoneyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OhmymoneyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OhmymoneyServerApplication.class, args);
    }

}
