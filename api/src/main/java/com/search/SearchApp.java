package com.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SearchApp {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(SearchApp.class, args);
    }
}
