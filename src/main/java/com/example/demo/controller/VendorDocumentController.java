package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
public class VendorDocumentController {

    @GetMapping("/status")
    public String getStatus() {
        return "Vendor Document Controller is working";
    }

}
