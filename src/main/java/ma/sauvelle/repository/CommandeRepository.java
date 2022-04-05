package ma.sauvelle.repository;

import ma.sauvelle.models.Commande;
import ma.sauvelle.models.Status;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    List<Commande> findAll();
    List<Commande> findAll(Sort sort);
    List<Commande> findAllByStatus(Status status);
    Commande findById(int commandId);
    Commande save(Commande commande);

}
