package com.example.thebank.model;

import lombok.Data;

//@Data
//used to store result from each source
public class Result {
    private String source;
    private Boolean isValid;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean valid) {
        isValid = valid;
    }
}
