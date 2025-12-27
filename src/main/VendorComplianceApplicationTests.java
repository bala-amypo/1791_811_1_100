package com.example.demo;

import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.model.DocumentType;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.service.impl.VendorDocumentServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VendorComplianceApplicationTests {

    private VendorRepository vendorRepository;
    private VendorDocumentRepository vendorDocumentRepository;
    private DocumentTypeRepository documentTypeRepository;
    private VendorDocumentServiceImpl vendorDocumentService;

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        vendorRepository = mock(VendorRepository.class);
        vendorDocumentRepository = mock(VendorDocumentRepository.class);
        documentTypeRepository = mock(DocumentTypeRepository.class);

        // Initialize service with mocked dependencies
        vendorDocumentService = new VendorDocumentServiceImpl(
                vendorDocumentRepository,
                vendorRepository,
                documentTypeRepository
        );
    }

    @Test
    public void testCreateVendorDocument() {
        // Sample objects
        Vendor vendor = new Vendor();
        vendor.setId(1L);
        vendor.setName("Acme Corp");

        DocumentType docType = new DocumentType();
        docType.setId(1L);
        docType.setName("License");

        VendorDocument vendorDocument = new VendorDocument();
        vendorDocument.setId(1L);
        vendorDocument.setVendor(vendor);
        vendorDocument.setDocumentType(docType);
        vendorDocument.setExpiryDate(LocalDate.of(2030, 12, 31));

        // Mock repository behavior
        when(vendorRepository.findById(1L)).thenReturn(Optional.of(vendor));
        when(documentTypeRepository.findById(1L)).thenReturn(Optional.of(docType));
        when(vendorDocumentRepository.save(any(VendorDocument.class))).thenReturn(vendorDocument);

        // Call the service method (replace with actual service method)
        VendorDocument result = vendorDocumentService.createVendorDocument(vendorDocument);

        // Assertions
        assertNotNull(result);
        assertEquals("Acme Corp", result.getVendor().getName());
        assertEquals("License", result.getDocumentType().getName());
        assertEquals(LocalDate.of(2030, 12, 31), result.getExpiryDate());
    }
}
