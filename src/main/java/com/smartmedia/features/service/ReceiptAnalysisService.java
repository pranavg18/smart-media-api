package com.smartmedia.features.service;

import org.springframework.stereotype.Service;
import com.smartmedia.features.model.Receipt;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.InputStreamResource;
import org.springframework.util.MimeTypeUtils;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ReceiptAnalysisService {
    private final ChatClient chatClient;

    public ReceiptAnalysisService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public Receipt analyseReceipt(InputStream imageInputStream, String contentType) throws IOException {
        return chatClient.prompt()
                .system(systemSpec -> systemSpec
                        .text("You are an expert expense tracking assistant. Analyse the provided receipt image.")
                        .text("Extract the merchant name, date, total amount, and currency.")
                        .text("Extract a list of all line items, including name, price, and quantity (which should be 1 by default if not specified).")
                        .text("Categorize the expense into one of these categories: Food, Transport, Utilities, Entertainment, Shopping, or Other.")
                        .text("If a field is not visible, leave it null or 0."))
                .user(userSpec -> userSpec
                        .media(MimeTypeUtils.parseMimeType(contentType), new InputStreamResource(imageInputStream)))
                .call()
                .entity(Receipt.class);
    }
}
