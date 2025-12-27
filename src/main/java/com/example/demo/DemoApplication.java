package com.example.demo;

import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository) {

        return args -> {

            DocumentType gst = new DocumentType("GST Certificate");
            DocumentType pan = new DocumentType("PAN Card");

            documentTypeRepository.saveAll(List.of(gst, pan));

            Vendor vendor = new Vendor("ABC Vendor");
            vendor.getSupportedDocumentTypes().add(gst); // ✅ ENTITY, not String

            vendorRepository.save(vendor);
        };
    }
}
