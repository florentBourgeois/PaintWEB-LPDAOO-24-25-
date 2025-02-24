package fr.uha.lpdaoo.paintweb20425.model;

import jakarta.persistence.Entity;

@Entity
public class Cercle extends Forme{

    private int rayon = 10;

    public Cercle() {
    }


    public Cercle(int rayon) {
        this.rayon = rayon;
    }

    public Cercle(int rayon, int x, int y) {
        super(x,y);
        this.rayon = rayon;
    }

    @Override
    public String getType() {
        return "Cercle";
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public int getPerimetre(){
        return (int) (this.rayon*2 * Math.PI);
    }

    public String toHTMLCanvas(){
        String res = "drawCircle(ctx,";
        res += this.getX() + ",";
        res += this.getY() + ",";
        res += this.rayon + ",";
        res += "\"red\", \"purple\");";
        return res;
    }

    @Override
    public String toString() {
        return "paint.Cercle{" +
                "rayon=" + rayon +
                super.toString()+
                '}';
    }
}
