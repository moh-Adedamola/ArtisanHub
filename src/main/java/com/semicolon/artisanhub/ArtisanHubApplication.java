package com.semicolon.artisanhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.semicolon.artisanhub.data.repository")
public class ArtisanHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtisanHubApplication.class, args);
    }

}
