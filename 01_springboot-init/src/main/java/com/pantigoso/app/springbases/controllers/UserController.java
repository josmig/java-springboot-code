package com.pantigoso.app.springbases.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.pantigoso.app.springbases.models.User;

@Controller
public class UserController {

    @GetMapping("/saludo")
    public String saludo(Model model){
        
        User usuario = new User("Miguel", "Pantigoso");
        usuario.setEmail("pantigosomiguel59@gmail.com");

        // con model podemos pasar datos a la vista
        model.addAttribute("title", "Hola mundo desde SpringBoot");
        // model.addAttribute("name", "Miguel");
        // model.addAttribute("lastname", "Pantigoso");
        model.addAttribute("usuario", usuario);
        // model.addAttribute("email", usuario);


        return "redirect:/list"; //Aca devolvemos la plantilla
    }


    @GetMapping("/list")
    public String list(ModelMap model) {
        
        // List<User> users = new ArrayList<>();
        List<User>users = Arrays.asList(
            new User("Pepa","Gonzales"),
            new User("Cañota", "Pera","cañita69@gmail.com"),
            new User("Sebastian", "Delgado"),
            new User("Arnold", "Puti","mariapila@gmail.com")
        );
        model.addAttribute("users", users);
        model.addAttribute("title", "Probando Listas");
        return "list";
    }
    
}
