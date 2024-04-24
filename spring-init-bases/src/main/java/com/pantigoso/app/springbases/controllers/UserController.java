package com.pantigoso.app.springbases.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pantigoso.app.springbases.models.User;

@Controller
public class UserController {

    @GetMapping("/")
    public String saludo(Model model){
        
        User usuario = new User("Miguel", "Pantigoso");
        // con model podemos pasar datos a la vista
        model.addAttribute("title", "Hola mundo desde SpringBoot");
        // model.addAttribute("name", "Miguel");
        // model.addAttribute("lastname", "Pantigoso");
        model.addAttribute("usuario", usuario);


        return "index"; //Aca devolvemos la plantilla
    }
}
