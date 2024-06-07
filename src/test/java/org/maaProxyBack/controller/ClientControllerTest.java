package org.maaProxyBack.controller;

import org.junit.jupiter.api.Test;
import org.maaProxyBack.model.BankClient;
import org.maaProxyBack.service.AccountService;
import org.maaProxyBack.service.ClientService;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClientService service;

    @MockBean
    private AccountService accountService;

    @Test
    void post_coffee_should_return_coffee() throws Exception{
        BDDMockito.given(service.save(any(BankClient.class))).willReturn(new BankClient());
        mvc.perform(post("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        """
                                {
                                    "identity": {
                                      "firstName": "Bob",
                                      "lastName": "Smith"
                                    },
                                    "contactDetails": {
                                      "mail": "bob.smith@example.com",
                                      "phoneNumber": "555-5678",
                                      "address": "456 Oak Avenue",
                                      "city": "Rivertown",
                                      "postalCode": "67890"
                                    },
                                    "savingAccounts": [
                                      {
                                        "balance": 3200.00,
                                        "openingDate": "2024-06-03T10:24:45.232Z",
                                        "interestRate": 1.8
                                      }
                                    ],
                                    "currentAccounts": [
                                      {
                                        "balance": 150.20,
                                        "openingDate": "2024-06-03T10:24:45.232Z",
                                        "authorizedOverdraft": 300
                                      },
                                      {
                                        "balance": -50.00,
                                        "openingDate": "2024-06-03T10:24:45.232Z",
                                        "authorizedOverdraft": 400
                                      }
                                    ]
                                  }
                                """
                )).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void post_coffee_empty_should_return_400() throws Exception{
        //BDDMockito.given(service.save(any(BankClient.class))).willReturn(new BankClient());
        mvc.perform(post("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                        {}
                                        """
                        )).andDo(print())
                .andExpect(status().is(400))
                .andExpect(jsonPath("$.['identity.lastName']").value("Last name cannot be empty"));
    }
}