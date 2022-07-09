package com.example.thebank.model;

import lombok.Data;

import java.util.List;

//@Data
//used to store and respond list of result-model
public class Results {
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
