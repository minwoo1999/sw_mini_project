package com.example.sw_mini_project;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwMiniProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwMiniProjectApplication.class, args);
    }

    // 빈생성
    @Bean
    Hibernate5Module hibernate5Module(){
        return new Hibernate5Module();
    }

}
