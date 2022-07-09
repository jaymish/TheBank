package com.example.thebank.model;

import lombok.Data;

import java.util.List;

//@Data
//to store incoming account number and optional list of sources
public class Account {
    private String accountNumber;
    private List<String> sources;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }
}
