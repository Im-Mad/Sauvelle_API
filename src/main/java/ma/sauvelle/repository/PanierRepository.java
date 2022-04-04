package ma.sauvelle.repository;

import ma.sauvelle.models.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Integer> {

    Panier saveAndFlush(Panier panier);

    void deleteByPkClientUsernameAndPkProduitId(String clientUserName, int produitId);

}
