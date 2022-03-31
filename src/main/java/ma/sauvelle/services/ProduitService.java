package ma.sauvelle.services;

import ma.sauvelle.models.Produit;

import java.util.List;

public interface ProduitService {

    List<Produit> findAll();

    List<Produit> search(String category, String composition, String matierePremiere, String origine);
}
