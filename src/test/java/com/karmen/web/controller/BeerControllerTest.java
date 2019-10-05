package com.karmen.web.controller;

import com.karmen.web.model.BeerDto;
import com.karmen.web.service.BeerService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    private BeerDto beer;

    @MockBean
    BeerService service;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        beer = BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getBeer() throws Exception {
        given(service.getBeerById(any())).willReturn(beer);


        mockMvc.perform(get("/api/v1/beer/" + beer.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
