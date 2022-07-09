package com.example.thebank.controller;

import com.example.thebank.config.SourceProperties;
import com.example.thebank.model.*;
import com.example.thebank.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class ValidateBankAccount {

    @Autowired
    private ValidationService validationService;


    @PostMapping("/validate")
    public Results validate(@RequestBody Account account){
        return validationService.defaultValidationService(account);//pass the input data to validation service to get response
    }

    //to get response
    /*@PostMapping("/response")
    public Response response(@RequestBody String accountNumber){
        System.out.println("Here is the account number and the response to it will be true");
        Response response = new Response();
        response.setValid(Boolean.TRUE);
        return response;
    }*/
}
