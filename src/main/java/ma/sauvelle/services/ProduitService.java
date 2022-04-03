package ma.sauvelle.services;

import ma.sauvelle.models.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    List<Produit> findAll();

    List<Produit> findByCategorie(int categoryId);

    List<Produit> search(String categoryName,String uniteName,String cooperativeName );

    Optional<Produit> findById(int produitId);
}
