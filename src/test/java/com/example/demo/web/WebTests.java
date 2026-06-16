package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;
    @Test
    void testCreerVoiture() throws Exception {
        String jsonBody = "{\"marque\":\"f\",\"prix\":100}";

        mockMvc.perform(post("/voiture")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk());
        verify(statistiqueImpl, times(1)).ajouter(any(Voiture.class));
    }

    @Test
    void testGetStatistiques_Success() throws Exception {
        Echantillon mockEchantillon = new Echantillon(); 
        when(statistiqueImpl.prixMoyen()).thenReturn(mockEchantillon);

        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(statistiqueImpl, times(1)).prixMoyen();
    }

    @Test
    void testGetStatistiques_ArithmeticException() throws Exception {
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());
        mockMvc.perform(get("/statistique"))
                .andDo(print())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof PasDeVoitureException));
    }
}