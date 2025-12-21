package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.company",
        "com.customer",
        "com.contact",
        "com.deal",
        "com.note",
        "com.lead",
        "com.application"
})
@EnableJpaRepositories(basePackages = {
        "com.company",
        "com.customer",
        "com.contact",
        "com.deal",
        "com.note",
        "com.lead"
})
@EntityScan(basePackages = {
        "com.company",
        "com.customer",
        "com.contact",
        "com.deal",
        "com.note",
        "com.lead"
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
