package ma.sauvelle.controllers;

import ma.sauvelle.models.Produit;
import ma.sauvelle.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("")
    public ResponseEntity<Object> getAllProduits(){
        System.out.println("getAll");
        return new ResponseEntity<>(produitService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{produitId}")
    public ResponseEntity<Object> getProduit(@PathVariable int produitId){
        return new ResponseEntity<>(produitService.findById(produitId), HttpStatus.OK);
    }

   @GetMapping("/{categoryId}")
    public ResponseEntity<Object> getProduitsByCategory(@PathVariable int categoryId){
       return new ResponseEntity<>(produitService.findByCategorie(categoryId), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchProduits(@RequestParam(name = "categorie",required = false) String categrieName,
                                                 @RequestParam(name = "unite",required = false) String uniteName,
                                                 @RequestParam(name = "cooperative",required = false) String cooperativeName)
    {
        System.out.println(categrieName+uniteName+cooperativeName);
        return new ResponseEntity<>(produitService.search(categrieName,uniteName,cooperativeName), HttpStatus.OK);
    }
}
