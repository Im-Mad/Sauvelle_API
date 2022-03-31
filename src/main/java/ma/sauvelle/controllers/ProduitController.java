package ma.sauvelle.controllers;

import ma.sauvelle.models.Produit;
import ma.sauvelle.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllProduits(){
        return new ResponseEntity<>(produitService.findAll(), HttpStatus.OK);
    }

   /*
   @GetMapping("/search")
    public List<Produit> searchProduits(@RequestParam String category,
                                        @RequestParam String composition,
                                        @RequestParam String matierePremiere,
                                        @RequestParam String origine){
        return produitService.search(category,composition,matierePremiere,origine);
    }
    */
}
