package com.nhnacademy.controller.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.service.ResidentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ResidentControllerTest {

    private ResidentService residentService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        residentService = mock(ResidentService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new ResidentController(residentService)).build();
    }

//    @Test
//    void put요청테스트() throws Exception {
//        Long serialNumber = 10L;
//        String url = "/residents/";
//
//        ResidentDTO residentDTO = new ResidentDTO();
//        residentDTO.setName("testName");
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        mockMvc.perform(put("/residents/{serialNumber}", serialNumber)
//                        .content(mapper.writeValueAsString(residentDTO))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .characterEncoding(StandardCharsets.UTF_8)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print());
//    }
}