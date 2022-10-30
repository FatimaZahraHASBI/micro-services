package com.hasbi.customer_service;

import com.hasbi.customer_service.dto.CustomerRequestDTO;
import com.hasbi.customer_service.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C01", "Fatima Zahra", "hasbi.fatimazahra@gmail.com"));
            customerService.save(new CustomerRequestDTO("C02", "Hasnaa", "hasbi.hasnaa@gmail.com"));
        };
    }
}
