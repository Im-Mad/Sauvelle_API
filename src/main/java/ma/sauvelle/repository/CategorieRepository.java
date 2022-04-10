package ma.sauvelle.repository;

import ma.sauvelle.models.Categorie;
import ma.sauvelle.models.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Categorie findById(int id);
}
