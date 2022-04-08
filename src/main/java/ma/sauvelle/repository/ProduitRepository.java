package ma.sauvelle.repository;

import ma.sauvelle.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    Produit save(Produit produit);

    List<Produit> findAll();

    Produit findById(int produitId);

    List<Produit> findByCategorieId(int categorieId);

    List<Produit> findByCategorieNom(String categorieName);

    List<Produit> findByCategorieNomAndAndUniteNom(String categorieName,String uniteName);

    List<Produit> findByCategorieNomAndUniteNomAndCooperativeNom(String categorieName,String uniteName, String cooperativeName);

    List<Produit> findByCooperativeNom(String cooperativeName);

    List<Produit> findByUniteNom(String uniteName);

    List<Produit> findByCooperativeNomAndUniteNom(String cooperativeName, String uniteName);

    List<Produit> findByCooperativeNomAndCategorieNom(String cooperativeName, String categoryName);

    List<Produit> findByUniteNomAndCategorieNom(String uniteName, String categoryName);

    List<Produit> findByCompositionsPkMatieresPremiereNom(String matierePremiereNom);
}