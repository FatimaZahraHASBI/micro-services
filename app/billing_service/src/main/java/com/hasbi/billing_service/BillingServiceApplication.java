package com.hasbi.billing_service;

import com.hasbi.billing_service.dto.InvoiceRequestDTO;
import com.hasbi.billing_service.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(10000), "C01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(12000), "C01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(20000), "C02"));
        };
    }
}
