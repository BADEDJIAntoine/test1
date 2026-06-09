package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StatistiqueTests {

    private Statistique statistique;

    @BeforeEach
    public void setUp() {
        this.statistique = new StatistiqueImpl();
    }

    @Test
    public void testPrixMoyen_2voitures() {
        statistique.ajouter(new Voiture("Audi", 30000));
        statistique.ajouter(new Voiture("BMW", 50000));
        Echantillon resultat = statistique.prixMoyen();
        assertEquals(40000.0, resultat.getValeurMoyenne(), 0.001);
        assertEquals(2, resultat.getTaille());
    }

    @Test
    public void testPrixMoyen_1Voiture() {
        statistique.ajouter(new Voiture("Fiat", 10000));
        Echantillon resultat = statistique.prixMoyen();
        assertEquals(10000.0, resultat.getValeurMoyenne(), 0.001);
        assertEquals(1, resultat.getTaille());
    }

    @Test
    public void testPrixMoyen_EchantillonVide() {
        assertThrows(ArithmeticException.class, () -> {
            statistique.prixMoyen();
        }, "Une ArithmeticException aurait dû être levée pour une liste vide");
    }
}