package me.codesmoo.demospringboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemospringboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemospringboardApplication.class, args);
    }

}
