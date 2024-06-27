package com.example.HR.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class HrApplication {
    //  HrApplication sınıfı Spring Boot uygulamasının başlangıç noktasıdır.

        public static void main(String[] args) {
            // SpringApplication.run() metoduyla Spring Boot uygulaması başlatılır.
            SpringApplication.run(HrApplication.class, args);
        }
    }

