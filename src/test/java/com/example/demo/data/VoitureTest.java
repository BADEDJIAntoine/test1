package com.example.demo.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VoitureTest {

    private Voiture voiture;

    @BeforeEach
    public void setUp() {
        voiture = new Voiture("Ferrari", 200000);
    }

    @Test
    public void testGetMarque() {
        assertEquals("Ferrari", voiture.getMarque());
    }

    @Test
    public void testSetMarque() {
        voiture.setMarque("Porsche");
        assertEquals("Porsche", voiture.getMarque());
    }

    @Test
    public void testGetPrix() {
        assertEquals(200000, voiture.getPrix());
    }

    @Test
    public void testSetPrix() {
        voiture.setPrix(250000);
        assertEquals(250000, voiture.getPrix());
    }
    
    @Test
    public void testConstructorVide() {
        Voiture vVide = new Voiture();
        assertNull(vVide.getMarque());
        assertEquals(0, vVide.getPrix());
    }
}
