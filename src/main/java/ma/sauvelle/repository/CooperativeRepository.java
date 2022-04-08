package ma.sauvelle.repository;

import ma.sauvelle.models.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CooperativeRepository extends JpaRepository<Cooperative, Integer> {
    List<Cooperative> findAll();
    Cooperative findById(int cooperativeId);
    List<Cooperative> findAllBySecteurNom(String secteurNom);
}
