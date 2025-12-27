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

    /**
     * Safe data initializer.
     * - Does NOT insert duplicates
     * - Restart-safe
     * - Production-friendly
     */
    @Bean
    CommandLineRunner initData(
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository) {

        return args -> {

            // ----- Document Types -----
            DocumentType gst = documentTypeRepository
                    .findByName("GST Certificate")
                    .orElseGet(() ->
                            documentTypeRepository.save(
                                    new DocumentType("GST Certificate")));

            DocumentType pan = documentTypeRepository
                    .findByName("PAN Card")
                    .orElseGet(() ->
                            documentTypeRepository.save(
                                    new DocumentType("PAN Card")));

            // ----- Vendor -----
            Vendor vendor = vendorRepository.findAll()
                    .stream()
                    .findFirst()
                    .orElseGet(() ->
                            vendorRepository.save(
                                    new Vendor("ABC Vendor")));

            // ----- Link Vendor & DocumentType -----
            if (!vendor.getSupportedDocumentTypes().contains(gst)) {
                vendor.getSupportedDocumentTypes().add(gst);
                vendorRepository.save(vendor);
            }
        };
    }
}
