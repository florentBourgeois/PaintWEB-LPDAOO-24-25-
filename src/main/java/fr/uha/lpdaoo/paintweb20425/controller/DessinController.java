package fr.uha.lpdaoo.paintweb20425.controller;

import fr.uha.lpdaoo.paintweb20425.dao.DessinRepository;
import fr.uha.lpdaoo.paintweb20425.dao.JustIdDTO;
import fr.uha.lpdaoo.paintweb20425.model.Dessin;
import fr.uha.lpdaoo.paintweb20425.model.UtilsDrawGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dessin")
public class DessinController {

    private final DessinRepository dessinRepository;

    public DessinController(DessinRepository dessinRepository) {
        this.dessinRepository = dessinRepository;


        getAllDessinsID().forEach(j -> System.out.println(j.getID()));

    }


    @GetMapping
    public List<Dessin> getAllDessins() {
        return dessinRepository.findAll();
    }

    @GetMapping("/listID")
    public List<JustIdDTO> getAllDessinsID() {
        return dessinRepository.getDessinsIDs();
    }




}
