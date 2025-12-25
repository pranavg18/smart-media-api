package com.smartmedia.features.model;

import java.util.List;

public class Receipt {
    private String merchantName;
    private String transactionDate;
    private double totalAmount;
    private String currency;
    private String category; // like food, transport, entertainment, etc.
    private List<LineItem> items;

    // Getters and setters
    public String getMerchantName() { return merchantName; }
    public String getTransactionDate() { return transactionDate; }
    public double getTotalAmount() { return totalAmount; }
    public String getCurrency() { return currency; }
    public String getCategory() { return category; }
    public List<LineItem> getItems() { return items; }
    public void setMerchantName(String merchantName) { this.merchantName = merchantName; }
    public void setTransactionDate(String transactionDate) { this.transactionDate = transactionDate; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setCategory(String category) { this.category = category; }
    public void setItems(List<LineItem> items) { this.items = items; }
}
