package fr.uha.lpdaoo.paintweb20425.model;

import jakarta.persistence.Entity;

@Entity
public class Triangle extends Forme{

    private int cote = 10;

    public Triangle() {
    }

    public Triangle(int cote) {
        this.cote = cote;
    }

    public Triangle(int cote, int x, int y) {
        super(x,y);
        this.cote = cote;
    }

    @Override
    public String getType() {
        return "Triangle";
    }

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

    public int getPerimetre(){
        return this.cote*3;
    }

    public String toHTMLCanvas(){
        String res = "drawEquilateralTriangle(ctx,";
        res += this.getX() + ",";
        res += this.getY() + ",";
        res += this.cote + ",";
        res += "\"green\", \"black\");";
        return res;
    }

    @Override
    public String toString() {
        return "paint.Triangle{" +
                "cote1=" + cote +
                "cote2=" + cote +
                "cote3=" + cote +
                '}';
    }
}
