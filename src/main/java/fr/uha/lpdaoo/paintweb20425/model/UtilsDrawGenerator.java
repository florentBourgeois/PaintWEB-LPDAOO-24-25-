package fr.uha.lpdaoo.paintweb20425.model;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe utilitaire pour générer des dessins avec des formes aléatoires
 */
public class UtilsDrawGenerator {

    /**
     * Génère un dessin avec nbrShapes  formes aléatoires
     * @param nbrShapes nombre de formes à générer
     * @return le dessin généré
     */
    public static Dessin genereRandomDessin(int nbrShapes){

        List<Forme> formes = new ArrayList<>();
        for (int i = 0; i < nbrShapes; i++) {

            int x = ThreadLocalRandom.current().nextInt(0, 600 + 1);
            int y = ThreadLocalRandom.current().nextInt(0, 600 + 1);
            int randomType = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            switch (randomType){
                case 0 : formes.add(new Rectangle(15,25, x, y)); break;
                case 1 : formes.add(new Triangle(15, x, y)); break;
                case 2 : formes.add(new Cercle(10,x,y)); break;
                default:
            }
        }
        Faker f = new Faker();
        Dessin d =   new Dessin(f.artist().name(), formes);
        return d;
    }

    public static void main(String[] args) {
        Dessin d = genereRandomDessin(100);
        System.out.println(d);
    }

}
