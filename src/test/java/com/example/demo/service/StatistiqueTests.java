package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest 
public class StatistiqueTests {

    @Autowired
    private StatistiqueImpl statistique; 

    @Test
    void testStatistique() {
        Voiture v1 = new Voiture("Ferrari", 3000);
        Voiture v2 = new Voiture("Porsche", 3000);

        statistique.ajouter(v1);
        statistique.ajouter(v2);
        
        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(3000, echantillon.getPrixMoyen(), "Le prix moyen calculé est incorrect.");
        assertEquals(2, echantillon.getNombreDeVoitures(), "Le nombre de voitures dans l'échantillon est incorrect.");
    }
}