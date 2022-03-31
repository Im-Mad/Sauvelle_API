package ma.sauvelle.controllers;

import ma.sauvelle.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public String sayHello() {
        System.out.println(clientService.findAll());
        return "Hello and Welcome tooooo the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint.";
    }
}
