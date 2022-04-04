package ma.sauvelle.services;

import ma.sauvelle.models.Client;
import ma.sauvelle.models.Panier;
import ma.sauvelle.models.PanierId;
import ma.sauvelle.models.Produit;
import ma.sauvelle.repository.ClientRepository;
import ma.sauvelle.repository.PanierRepository;
import ma.sauvelle.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PanierServiceImpl implements PanierService{

    @Autowired
    PanierRepository panierRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Panier addProduitToPanier(String username, int produitId, int quantity) {
        Panier panier = new Panier();
        Produit produit = produitRepository.findById(produitId);
        Client client = clientRepository.findClientByUsername(username);
        panier.setProduit(produit);
        panier.setClient(client);
        panier.setQuantite(quantity);

        return panierRepository.saveAndFlush(panier);

    }

    @Override
    public void removeProduitFromPanier(String username, int produitId) {
        panierRepository.deleteByPkClientUsernameAndPkProduitId(username, produitId);
    }




}
