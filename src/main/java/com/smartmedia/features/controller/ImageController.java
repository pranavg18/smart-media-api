package com.smartmedia.features.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smartmedia.features.service.ReceiptAnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ReceiptAnalysisService receiptService;

    public ImageController(ReceiptAnalysisService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/analyse-receipt")
    public ResponseEntity<?> analyseReceipt(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(receiptService.analyseReceipt(
                file.getInputStream(), file.getContentType()
        ), HttpStatus.OK);
    }
}
