package ma.sauvelle.controllers;

import ma.sauvelle.services.CooperativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cooperatives")
public class CooperativeController {


    @Autowired
    CooperativeService cooperativeService;

    @GetMapping("")
    public ResponseEntity getAllCooperatives(){
        return new ResponseEntity<>(cooperativeService.findAll(),HttpStatus.OK);
    }
}
