package fr.uha.lpdaoo.paintweb20425;

import fr.uha.lpdaoo.paintweb20425.dao.DessinRepository;
import fr.uha.lpdaoo.paintweb20425.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PaintWeb20425Application {

    public static void main(String[] args) {
        SpringApplication.run(PaintWeb20425Application.class, args);
    }



    @Bean
    CommandLineRunner initRepos(DessinRepository dessinRepository) {
        return args -> {
            System.out.println("\n\nInitialisation du projet\n---------------");
            Dessin d = new Dessin("DesSinple");
            d.addForme(new Rectangle(10,100, 50,50));
            d.addForme(new Cercle(15, 100,100));
            d.addForme(new Triangle(20, 150,1));

            dessinRepository.save(d);

            dessinRepository.save(new Dessin("dessin vide"));

            dessinRepository.save(UtilsDrawGenerator.genereRandomDessin(5));
            dessinRepository.save(UtilsDrawGenerator.genereRandomDessin(50));
            dessinRepository.save(UtilsDrawGenerator.genereRandomDessin(1));
            dessinRepository.save(UtilsDrawGenerator.genereRandomDessin(0));
            dessinRepository.save(UtilsDrawGenerator.genereRandomDessin(100));

            System.out.println("\nil y a " + dessinRepository.count() + "dessins dans la bdd");
            dessinRepository.getDessinsShort().forEach(j -> System.out.println(j.getID() + " | " + j.getNom()));


            System.out.println("\nFIN \n---------------");
        };
    }
}
