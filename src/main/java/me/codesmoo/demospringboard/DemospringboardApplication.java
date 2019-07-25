package me.codesmoo.demospringboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemospringboardApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "/home/config/demospringboard/real-application.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemospringboardApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
