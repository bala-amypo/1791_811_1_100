package com.example.demo;

import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(VendorRepository repository) {
        return (args) -> {
            Vendor vendor = new Vendor("Vendor1", Arrays.asList("PASSPORT", "ID_CARD"));
            repository.save(vendor);

            DocumentType docType1 = new DocumentType("PASSPORT");
            DocumentType docType2 = new DocumentType("DRIVER_LICENSE");

            System.out.println(docType1.isSupportedBy(vendor)); // true
            System.out.println(docType2.isSupportedBy(vendor)); // false
        };
    }
}
