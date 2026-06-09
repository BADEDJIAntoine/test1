package com.example.demo.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VoitureTest {

    @Test
    void testConstructeurEtGetters() {
        String marqueAttendue = "Ferrari";
        int prixAttendu = 150000;
        Voiture voiture = new Voiture(marqueAttendue, prixAttendu);
        assertEquals(marqueAttendue, voiture.getMarque());
        assertEquals(prixAttendu, voiture.getPrix());
    }

    @Test
    void testSettersEtId() {
        Voiture voiture = new Voiture();
        voiture.setId(10);
        voiture.setMarque("Porsche");
        voiture.setPrix(90000);
        assertEquals(10, voiture.getId());
        assertEquals("Porsche", voiture.getMarque());
        assertEquals(90000, voiture.getPrix());
    }

    @Test
    void testToString() {
        Voiture voiture = new Voiture("Renault", 15000);
        voiture.setId(1);
        String resultat = voiture.toString();
        String attendu = "Car{marque='Renault', prix=15000, id=1}";
        assertEquals(attendu, resultat);
    }
}