package ma.sauvelle.repository;

import ma.sauvelle.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    List<Produit> findAll();

    List<Produit> search(String category, String composition, String matierePremiere, String origine);
}
