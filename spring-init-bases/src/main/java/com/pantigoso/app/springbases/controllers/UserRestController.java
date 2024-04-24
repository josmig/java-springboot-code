package com.pantigoso.app.springbases.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pantigoso.app.springbases.models.User;

import java.util.HashMap;
import java.util.Map;

//Controllers
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/saludo")
    public Map<String,Object> saludoRest() {
        
        Map<String,Object> body = new HashMap<>();
        User usuario = new User("Miguel", "Pantigoso");
        body.put("title", "Hola mundo");
        body.put("user",usuario);

        return body; //aca la vista no es un html si no una presentacion osea un JSON
    }
    
}
