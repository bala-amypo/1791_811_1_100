package com.example.demo.service;

import com.example.demo.model.DocumentType;

import java.util.List;

public interface DocumentTypeService {

    DocumentType save(DocumentType documentType);

    List<DocumentType> getRequiredDocumentTypes();
}
