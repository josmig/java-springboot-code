package com.pantigoso.app.springbases.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping({"", "/", "/home"})
    public String home() {
        // return "redirect:/list"; //redirect redirecciona a otro controlador
        return "index";
        
        // return "forward:/list";
        //El forward se mantiene dentro de la petición http, no pierdes los parametros que tienes dentro del request, tampoco cambia la ruta url
        //osea no hace un refresh su objetivo es despachar a otro controlador pero sin recargar la pagina mientras el redirect actualiza todo.
    }
    
}
