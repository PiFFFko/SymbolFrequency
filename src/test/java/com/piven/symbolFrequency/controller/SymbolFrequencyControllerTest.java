package com.piven.symbolFrequency.controller;

import com.piven.symbolFrequency.service.SymbolFrequencyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = SymbolFrequencyController.class)
class SymbolFrequencyControllerTest {

    @MockBean
    private SymbolFrequencyService service;
    @Autowired
    private MockMvc mvc;

    @Test
    void getSymbolFrequency() throws Exception {
        when(service.getFrequencySymbol(Mockito.anyString()))
                .thenReturn(Map.of('a',5));
        mvc.perform(get("/frequency")
                        .param("string","sdffdsdfs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("a").value(5));
    }

    @Test
    void getSymbolFrequencyWithoutParameter() throws Exception {
        when(service.getFrequencySymbol(Mockito.anyString()))
                .thenReturn(Map.of('a',5));
        mvc.perform(get("/frequency"))
                .andExpect(status().is4xxClientError());
    }
}