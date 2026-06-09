package com.example.demo.service;

import com.example.demo.data.Voiture;
import java.util.ArrayList;
import java.util.List;

public class StatistiqueImpl implements Statistique {
    private final List<Voiture> voitures = new ArrayList<>();

    @Override
    public void ajouter(Voiture voiture) {
        if (voiture != null) {
            voitures.add(voiture);
        }
    }

    @Override
    public Echantillon prixMoyen() throws ArithmeticException {
        if (voitures.isEmpty()) {
            throw new ArithmeticException("Impossible de calculer la moyenne d'un échantillon vide.");
        }

        double somme = 0;
        for (Voiture v : voitures) {
            somme += v.getPrix(); // On suppose que Voiture a une méthode getPrix()
        }

        double moyenne = somme / voitures.size();
        return new Echantillon(moyenne, voitures.size()); // On suppose le constructeur d'Echantillon
    }
}