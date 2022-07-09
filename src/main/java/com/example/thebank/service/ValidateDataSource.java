package com.example.thebank.service;

import com.example.thebank.model.Response;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ValidateDataSource {
    public Boolean defaultDataSourceResponse(String url,String accountNumber){
        RestTemplate restTemplate = new RestTemplate();
        Response result = restTemplate.postForObject(url, accountNumber, Response.class); //post request to url provided, pass account number and get Response-model as response
        return result.getValid();
    }
}
