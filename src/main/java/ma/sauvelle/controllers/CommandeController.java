package ma.sauvelle.controllers;

import ma.sauvelle.dto.CommandeDto;
import ma.sauvelle.models.Commande;
import ma.sauvelle.services.CommandeService;
import ma.sauvelle.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private DiscountService discountService;

    @GetMapping("")
    public ResponseEntity<Object> getAllCommandes(){
        return new ResponseEntity<>(commandeService.getAllCommandes(), HttpStatus.OK);
    }

    @GetMapping("/{commandeId}")
    public ResponseEntity<Object> getCommande(@PathVariable int commandeId){
        System.out.println(commandeId);
        return new ResponseEntity<>(commandeService.getCommande(commandeId), HttpStatus.OK);
    }

    @GetMapping("/{commandeId}/apply-discount")
    public ResponseEntity<Object> applyDiscount(@PathVariable int commandeId,@RequestParam(name = "coupon") String discountCode){
        return new ResponseEntity<>(discountService.applyDiscount(commandeId, discountCode), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/create")
    public ResponseEntity<Object> createCommandes(@RequestBody CommandeDto commande, HttpServletRequest request)
    {
        return new ResponseEntity<>(commandeService.createCommande(commande, (String) request.getAttribute("username")), HttpStatus.OK);
    }
}
