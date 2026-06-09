package com.example.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class WebTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAjouterVoitureEtCalculerStatistiques() throws Exception {
        this.mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"marque\":\"Ford\",\"prix\":20000}"))
                .andExpect(status().isOk());
        this.mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"marque\":\"Peugeot\",\"prix\":10000}"))
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/statistiques")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valeurMoyenne").value(15000.0))
                .andExpect(jsonPath("$.taille").value(2));
    }
}
