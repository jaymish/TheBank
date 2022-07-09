
package com.example.thebank.controller;

import com.example.thebank.model.Account;
import com.example.thebank.service.ValidateDataSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ValidateBankAccountTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ValidateDataSource validateDataSource;



    HttpHeaders headers = new HttpHeaders();

    Random random = new Random();



    @Test
    //test case with no source provided in input
    public void testWithNoSource() throws Exception {
        Account account =new Account();
        account.setAccountNumber("12345678");
        List<String> sources = new ArrayList<>();
        account.setSources(sources);
        Mockito.when(validateDataSource.defaultDataSourceResponse(Mockito.anyString(),Mockito.anyString())).thenReturn(random.nextBoolean());
        mockMvc.perform(MockMvcRequestBuilders.post("/account/validate")
                .content(asJsonString(account))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.results.length()").value(4));

    }

    @Test
    //test case with one source provided in input
    public void testWithOneSource() throws Exception {
        Account account =new Account();
        account.setAccountNumber("12345678");
        List<String> sources = new ArrayList<>();
        sources.add("source1");
        //sources.add("source2");
        account.setSources(sources);
        Mockito.when(validateDataSource.defaultDataSourceResponse(Mockito.anyString(),Mockito.anyString())).thenReturn(random.nextBoolean());
        mockMvc.perform(MockMvcRequestBuilders.post("/account/validate")
                        .content(asJsonString(account))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.results.length()").value(1));

    }

    @Test
    //test case with two source provided in input
    public void testWithTowSource() throws Exception {
        Account account =new Account();
        account.setAccountNumber("12345678");
        List<String> sources = new ArrayList<>();
        sources.add("source1");
        sources.add("source2");
        account.setSources(sources);
        Mockito.when(validateDataSource.defaultDataSourceResponse(Mockito.anyString(),Mockito.anyString())).thenReturn(random.nextBoolean());
        mockMvc.perform(MockMvcRequestBuilders.post("/account/validate")
                        .content(asJsonString(account))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.results.length()").value(2));

    }

    @Test
    //test case with three source provided in input
    public void testWithThreeSource() throws Exception {
        Account account =new Account();
        account.setAccountNumber("12345678");
        List<String> sources = new ArrayList<>();
        sources.add("source1");
        sources.add("source2");
        sources.add("source3");
        account.setSources(sources);
        Mockito.when(validateDataSource.defaultDataSourceResponse(Mockito.anyString(),Mockito.anyString())).thenReturn(random.nextBoolean());
        mockMvc.perform(MockMvcRequestBuilders.post("/account/validate")
                        .content(asJsonString(account))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.results.length()").value(3));

    }

    @Test
    //test case with four source provided in input
    public void testWithFourSource() throws Exception {
        Account account =new Account();
        account.setAccountNumber("12345678");
        List<String> sources = new ArrayList<>();
        sources.add("source1");
        sources.add("source2");
        sources.add("source3");
        sources.add("source4");
        account.setSources(sources);
        Mockito.when(validateDataSource.defaultDataSourceResponse(Mockito.anyString(),Mockito.anyString())).thenReturn(random.nextBoolean());
        mockMvc.perform(MockMvcRequestBuilders.post("/account/validate")
                        .content(asJsonString(account))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.results.length()").value(4));

    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}