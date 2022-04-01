package ma.sauvelle.services;

import ma.sauvelle.models.Produit;
import ma.sauvelle.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }


    @Override
    public List<Produit> findByCategorie(int categoryId) {
        return produitRepository.findByCategorieId(categoryId);
    }
}

