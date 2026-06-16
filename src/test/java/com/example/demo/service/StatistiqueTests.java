package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatistiqueTests {

    private StatistiqueImpl statistique;

    @BeforeEach
    void setUp() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void testPrixMoyenAvecUneVoiture() {
        Voiture ferrari = new Voiture("Ferrari", 5000);
        statistique.ajouter(ferrari);
        Echantillon resultat = statistique.prixMoyen();
        assertNotNull(resultat, "L'échantillon ne devrait pas être nul");
        assertEquals(1, resultat.getNombreDeVoitures(), "Le nombre de voitures doit être de 1");
    }

    @Test
    void testPrixMoyenAvecPlusieursVoitures() {
        Voiture voiture1 = new Voiture("Ferrari", 5000);
        Voiture voiture2 = new Voiture("Clio", 1000);
        statistique.ajouter(voiture1);
        statistique.ajouter(voiture2);
        Echantillon resultat = statistique.prixMoyen();
        assertNotNull(resultat);
        assertEquals(2, resultat.getNombreDeVoitures(), "Le nombre de voitures doit être de 2");
    }

    @Test
    void testPrixMoyenLanceUneExceptionSiAucuneVoiture() {
        assertThrows(ArithmeticException.class, () -> {
            statistique.prixMoyen();
        }, "Une ArithmeticException aurait dû être levée à cause de la division par zéro");
    }
}