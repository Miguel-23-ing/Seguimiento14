package com.example.bancoalfa.model;

import java.time.LocalDate;

public class Data {

    private double amount;
    private String description;
    private String type;
    private LocalDate date;

    public Data(double amount, String description, String type, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
