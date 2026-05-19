package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VoitureTest {

    @Test
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
