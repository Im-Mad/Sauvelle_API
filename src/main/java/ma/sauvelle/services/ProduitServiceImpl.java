package ma.sauvelle.services;

import ma.sauvelle.models.Produit;
import ma.sauvelle.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Produit> search(String categoryName, String uniteName, String cooperativeName) {
        if(categoryName == null) {
            if(uniteName == null ) {
                if(cooperativeName == null ) {
                    return produitRepository.findAll();
                } return produitRepository.findByCooperativeNom(cooperativeName);
            } else {
                if(cooperativeName == null ) {
                    return produitRepository.findByUniteNom(uniteName);
                } return produitRepository.findByCooperativeNomAndUniteNom(cooperativeName, uniteName);
            }
        } else {
            if(uniteName == null ) {
                if(cooperativeName == null ) {
                    return produitRepository.findByCategorieNom(categoryName);
                } return produitRepository.findByCooperativeNomAndCategorieNom(cooperativeName, categoryName);
            } else {
                if(cooperativeName == null ) {
                    return produitRepository.findByUniteNomAndCategorieNom(uniteName, categoryName);
                } return produitRepository.findByCategorieNomAndUniteNomAndCooperativeNom(categoryName, uniteName,cooperativeName);
            }
        }
    }

    @Override
    public Optional<Produit> findById(int produitId) {
        return produitRepository.findById(produitId);
    }
}

