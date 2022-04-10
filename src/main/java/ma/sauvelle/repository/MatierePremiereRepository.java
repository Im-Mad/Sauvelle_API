package ma.sauvelle.repository;

import ma.sauvelle.models.MatierePremiere;
import ma.sauvelle.models.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatierePremiereRepository extends JpaRepository<MatierePremiere, Integer> {
    MatierePremiere findById(int id);
}
