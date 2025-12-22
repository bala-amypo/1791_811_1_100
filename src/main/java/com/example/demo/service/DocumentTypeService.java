package com.example.demo.service;

import com.example.demo.entity.DocumentType;

import java.util.List;

public interface DocumentTypeService {

    DocumentType createDocumentType(DocumentType documentType);

    List<DocumentType> getAllDocumentTypes();

    DocumentType getDocumentType(Long id);
}
