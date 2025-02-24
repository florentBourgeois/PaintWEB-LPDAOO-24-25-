package fr.uha.lpdaoo.paintweb20425.dao;

import fr.uha.lpdaoo.paintweb20425.model.Dessin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DessinRepository extends JpaRepository<Dessin, Long> {


    @Query(value = "select d.id as ID from Dessin as d")
    List<JustIdDTO> getDessinsIDs();

}
