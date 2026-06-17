package com.example.demo.data;

// On remplace jakarta.* par javax.*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Voiture {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id; 

    String marque;
    int prix;
    int i;

    // Le reste de ton code (constructeurs, getters, setters) reste EXACTEMENT le même !

    public Voiture(){
    }

    public Voiture(String marque, int prix) {
        this.marque = marque;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Car{" +
                "marque='" + marque + '\'' +
                ", prix=" + prix +
                ", id=" + id +
                '}';
    }
}