package com.proptiger.mortgage.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.proptiger.mortgage.dao"})
@EntityScan(basePackages = {"com.proptiger.mortgage.model"})
@ComponentScan(basePackages = { "com.proptiger" })
public class WebApplication
{
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}