package com.example.thebank.service;

import com.example.thebank.config.SourceProperties;
import com.example.thebank.model.Account;
import com.example.thebank.model.Result;
import com.example.thebank.model.Results;
import com.example.thebank.model.Sources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationService {
    SourceProperties sourceProperties;
    ValidateDataSource validateDataSource;

    public ValidationService(SourceProperties sourceProperties,ValidateDataSource validateDataSource) {
        this.sourceProperties = sourceProperties;
        this.validateDataSource=validateDataSource;
    }

    public Results defaultValidationService(Account account){
        List<Sources> source = sourceProperties.getSources();
        List<Result> results = new ArrayList<>();
        Results res = new Results();
        Result result = new Result();
        if(account.getSources().isEmpty()){//is input source empty check for all the available sources
            for (int i=0; i<source.size(); i++){
                result.setSource(source.get(i).getName());
                result.setIsValid(validateDataSource.defaultDataSourceResponse(source.get(i).getUrl(),account.getAccountNumber()));
                results.add(result);
                result = new Result();
            }
        }
        else{//check for the sources stated in input
            for (int i=0; i<account.getSources().size(); i++){
                result.setSource(account.getSources().get(i));
                result.setIsValid(Boolean.FALSE);
                for (int j=0; j<source.size(); j++){
                    if (account.getSources().get(i).equals(source.get(j).getName())){
                        result.setIsValid(validateDataSource.defaultDataSourceResponse(source.get(j).getUrl(),account.getAccountNumber()));
                        break;
                    }
                }
                results.add(result);
                result = new Result();
            }
        }
        res.setResults(results);
        return res;
    }
}
