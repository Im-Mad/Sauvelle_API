package ma.sauvelle.services;


import ma.sauvelle.models.Panier;

public interface PanierService {

    Panier addProduitToPanier(String username, int productId, int quantity);

    void removeProduitFromPanier(String username, int produitId);
}
