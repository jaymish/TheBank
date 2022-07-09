package com.example.thebank.config;

import com.example.thebank.model.Sources;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties // no prefix, root level.
//get sources from properties and store in source
public class SourceProperties {

    private List<Sources> source = new ArrayList<>();


    public List<Sources> getSources() {
        return source;
    }

    public void setSources(List<Sources> sources) {
        this.source = sources;
    }

    @Override
    public String toString() {
        return "{" + this.getSources() +  "}";
    }
}
