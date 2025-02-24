package fr.uha.lpdaoo.paintweb20425.controller;

import fr.uha.lpdaoo.paintweb20425.model.Cercle;
import fr.uha.lpdaoo.paintweb20425.model.Forme;
import fr.uha.lpdaoo.paintweb20425.model.Rectangle;
import fr.uha.lpdaoo.paintweb20425.model.Triangle;

public class PostFormeDTO {

    private String type;

    private int x;
    private int y;
    private int longueur;
    private int hauteur;
    private int rayon;
    private int cote;

    public Forme toForme(){
        switch (type){
            case "Rectangle":
                return new Rectangle(hauteur, longueur, x, y);
            case "Cercle":
                return new Cercle(rayon, x, y);
            case "Triangle":
                return new Triangle(cote, x, y);
            default:
                return new Rectangle(0,0,0,0);
        }
    }

    public PostFormeDTO() {
    }

    public PostFormeDTO(String type, int x, int y, int longueur, int hauteur, int rayon, int cote) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.longueur = longueur;
        this.hauteur = hauteur;
        this.rayon = rayon;
        this.cote = cote;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }
}
