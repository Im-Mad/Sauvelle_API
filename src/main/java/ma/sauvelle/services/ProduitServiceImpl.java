package ma.sauvelle.services;

import ma.sauvelle.dto.ProduitDto;
import ma.sauvelle.models.Composition;
import ma.sauvelle.models.MatierePremiere;
import ma.sauvelle.models.Produit;
import ma.sauvelle.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    UniteRepository uniteRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    CooperativeRepository cooperativeRepository;

    @Autowired
    MatierePremiereRepository matierePremiereRepository;

    @Autowired
    CompositionRepository compositionRepository;

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
    public List<Produit> searchByMatierePremiere(String matierePremiereNom) {
        return produitRepository.findByCompositionsPkMatieresPremiereNom(matierePremiereNom);
    }

    @Override
    public Produit findById(int produitId) {
        return produitRepository.findById(produitId);
    }

    @Override
    public Produit create(ProduitDto produitDto) {
        Produit produit = new Produit();
        produit.setNom(produitDto.getNom());
        produit.setDescription(produitDto.getDescription());
        produit.setPrix(produitDto.getPrix());
        produit.setUnite(uniteRepository.findById(produitDto.getUniteId()));
        produit.setCategorie(categorieRepository.findById(produitDto.getCategorieId()));
        produit.setCooperative(cooperativeRepository.findById(produitDto.getCooperativeId()));
        List<Composition> compositions = new ArrayList<>();
        produitDto.getCompositions().stream().forEach(compositionDto -> {
            Composition composition = new Composition();
            composition.setPourcentage(compositionDto.getPourcentage());
            MatierePremiere matierePremiere = matierePremiereRepository.findById(compositionDto.getMatierePremiereId());
            composition.setMatieresPremiere(matierePremiere);
            compositions.add(composition);
        });
        produit.setCompositions(compositions);
        Produit savedProduit = produitRepository.save(produit);
        produit.getCompositions().stream().forEach(composition -> {
            composition.setProduit(savedProduit);
            compositionRepository.save(composition);
        });
        return savedProduit;
    }
}

