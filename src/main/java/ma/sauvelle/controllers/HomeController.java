package ma.sauvelle.controllers;

import ma.sauvelle.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public String sayHello(@PathVariable(value = "id") Long employeeId) {
        System.out.println(employeeId);
        return "Hello and Welcome tooooo the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint.";
    }
}
