package com.example.demo.service; // ou .data selon votre architecture

public class Echantillon {
    private double valeurMoyenne;
    private int taille;

    public Echantillon(double valeurMoyenne, int taille) {
        this.valeurMoyenne = valeurMoyenne;
        this.taille = taille;
    }

    public double getValeurMoyenne() {
        return valeurMoyenne;
    }

    public int getTaille() {
        return taille;
    }
}