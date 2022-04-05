package ma.sauvelle.controllers;

import ma.sauvelle.models.Commande;
import ma.sauvelle.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping("")
    public ResponseEntity<Object> getAllCommandes(){
        return new ResponseEntity<>(commandeService.getAllCommandes(), HttpStatus.OK);
    }

    @GetMapping("/{commandeId}")
    public ResponseEntity<Object> getCommande(@PathVariable int commandeId){
        return new ResponseEntity<>(commandeService.getCommande(commandeId), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Object> getCommandesByCategory(@PathVariable String status){
        return new ResponseEntity<>(commandeService.getAllCommandesByStatus(status), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCommandes(@RequestBody Commande commande)
    {
        return new ResponseEntity<>(commandeService.createCommande(commande), HttpStatus.OK);
    }
}
