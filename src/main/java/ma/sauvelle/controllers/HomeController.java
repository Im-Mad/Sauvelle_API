package ma.sauvelle.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String sayHello() {
        return "Hello and Welcome tooooo the EasyNotes application. You can create a new Note by making a POST request to /api/notes endpoint.";
    }
}
