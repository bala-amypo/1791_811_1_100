package com.example.demo;

import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.impl.VendorDocumentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VendorComplianceApplicationTests {

    private VendorDocumentRepository vendorDocumentRepository;
    private VendorRepository vendorRepository;
    private DocumentTypeRepository documentTypeRepository;

    private VendorDocumentServiceImpl vendorDocumentService;

    @BeforeEach
    public void setup() {
        // Mock repositories
        vendorDocumentRepository = mock(VendorDocumentRepository.class);
        vendorRepository = mock(VendorRepository.class);
        documentTypeRepository = mock(DocumentTypeRepository.class);

        // Initialize service with only VendorDocumentRepository
        vendorDocumentService = new VendorDocumentServiceImpl(vendorDocumentRepository);

        // Sample Vendor and DocumentType
        Vendor vendor = new Vendor();
        vendor.setId(1L);
        vendor.setName("Vendor A");

        DocumentType docType = new DocumentType();
        docType.setId(1L);
        docType.setName("Passport");

        // Mock repository calls
        when(vendorRepository.findById(1L)).thenReturn(Optional.of(vendor));
        when(documentTypeRepository.findById(1L)).thenReturn(Optional.of(docType));
    }

    @Test
    public void testUploadDocument() {
        Vendor vendor = new Vendor();
        vendor.setId(1L);

        DocumentType documentType = new DocumentType();
        documentType.setId(1L);

        VendorDocument doc = new VendorDocument();
        doc.setVendor(vendor);
        doc.setDocumentType(documentType);
        doc.setFileUrl("file.pdf");
        doc.setExpiryDate(LocalDate.of(2026, 12, 31));

        // Mock save
        when(vendorDocumentRepository.save(doc)).thenReturn(doc);

        VendorDocument saved = vendorDocumentService.uploadDocument(1L, 1L, doc);

        assertNotNull(saved);
        assertEquals("file.pdf", saved.getFileUrl());
        assertEquals(LocalDate.of(2026, 12, 31), saved.getExpiryDate());
    }

    @Test
    public void testGetVendorDocument() {
        VendorDocument doc = new VendorDocument();
        doc.setId(1L);
        doc.setFileUrl("file.pdf");

        when(vendorDocumentRepository.findById(1L)).thenReturn(Optional.of(doc));

        Optional<VendorDocument> fetched = vendorDocumentService.getDocument(1L);
        assertTrue(fetched.isPresent());
        assertEquals("file.pdf", fetched.get().getFileUrl());
    }
}
