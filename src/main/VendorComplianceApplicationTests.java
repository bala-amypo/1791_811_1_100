package com.example.demo;

import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.service.impl.VendorDocumentServiceImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorComplianceApplicationTests {

    @Test
    void testUploadAndRetrieveDocument() {
        VendorDocumentRepository docRepo = new VendorDocumentRepository();
        VendorDocumentServiceImpl service = new VendorDocumentServiceImpl(docRepo);

        Vendor vendor = new Vendor(1L, "Vendor A", "IT");
        DocumentType docType = new DocumentType(1L, "Passport", 5);
        vendor.addSupportedDocumentType(docType);

        VendorDocument document = new VendorDocument(vendor, docType);
        document.setFileUrl("file.pdf");
        document.setExpiryDate(LocalDate.of(2030, 1, 1));

        service.uploadDocument(vendor.getId(), docType.getId(), document);

        VendorDocument retrieved = service.getDocument(docType.getId());
        assertEquals("file.pdf", retrieved.getFileUrl());
    }
}
