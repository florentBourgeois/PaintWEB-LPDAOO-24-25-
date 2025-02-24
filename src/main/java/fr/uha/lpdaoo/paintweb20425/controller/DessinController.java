package fr.uha.lpdaoo.paintweb20425.controller;

import fr.uha.lpdaoo.paintweb20425.dao.DessinRepository;
import fr.uha.lpdaoo.paintweb20425.dao.DessinShort;
import fr.uha.lpdaoo.paintweb20425.model.Dessin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dessin")
public class DessinController {

    private final DessinRepository dessinRepository;

    public DessinController(DessinRepository dessinRepository) {
        this.dessinRepository = dessinRepository;
    }


    @GetMapping
    public List<Dessin> getAllDessins() {
        return dessinRepository.findAll();
    }

    @GetMapping("/short")
    public List<DessinShort> getAllDessinsID() {
        return dessinRepository.getDessinsShort();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dessin> getDessinID(@PathVariable(name="id") Long id){
        Optional<Dessin> optionalDessin = dessinRepository.findById(id);
        if (optionalDessin.isEmpty())
            return ResponseEntity.badRequest().build();

        Dessin d = optionalDessin.get();
        return ResponseEntity.ok(d);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dessin> deleteDessin(@PathVariable(name="id") Long id){
        Optional<Dessin> optionalDessin = dessinRepository.findById(id);
        if (optionalDessin.isEmpty())
            return ResponseEntity.badRequest().build();

        Dessin d = optionalDessin.get();
        dessinRepository.delete(d);
        return ResponseEntity.ok(d);
    }

    @PostMapping
    public ResponseEntity<Dessin> addDessin(@RequestBody PostDessinDTO dto){
        Dessin d = new Dessin();
        d.setNom(dto.getNom());
        d = dessinRepository.save(d);
        return ResponseEntity.ok(d);
    }


    @PostMapping("/{id}")
    public ResponseEntity<Dessin> addFormeToDessin(@PathVariable(name = "id") Long id,@RequestBody PostFormeDTO dto){
        Optional<Dessin> optionalDessin = dessinRepository.findById(id);
        if (optionalDessin.isEmpty())
            return ResponseEntity.badRequest().build();

        Dessin d = optionalDessin.get();
        d.addForme(dto.toForme());

        dessinRepository.save(d);
        return ResponseEntity.ok(d);
    }


}
