package ma.sauvelle.controllers;

import ma.sauvelle.models.Discount;
import ma.sauvelle.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discounts")
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @PostMapping("/create")
    ResponseEntity<Object> createDiscount(@RequestParam double pourcentage){
        System.out.println(pourcentage);
        return new ResponseEntity<>(discountService.createDiscount(pourcentage), HttpStatus.OK);
    }

}
