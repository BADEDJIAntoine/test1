package com.example.demo.data;

import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
=======
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
>>>>>>> 411517846fb0d8b88839359999dddf83a09fa7a0

public class VoitureTest {

    @Test
<<<<<<< HEAD
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
=======
    void testCreationEtGetters() {
        Voiture voiture = new Voiture();
        voiture.setId(1L);
        voiture.setMarque("Renault");
        voiture.setPrix(15000);
        voiture.setEnPanne(false);
        assertEquals(1L, voiture.getId());
        assertEquals("Renault", voiture.getMarque());
        assertEquals(15000, voiture.getPrix());
        assertFalse(voiture.isEnPanne());
    }

    @Test
    void testEchouer() {
        Voiture voiture = new Voiture();
        voiture.setMarque("Peugeot");
        assertEquals("Citroen", voiture.getMarque(), "La marque ne correspond pas !");
    }
}
>>>>>>> 411517846fb0d8b88839359999dddf83a09fa7a0
