package com.pantigoso.app.springbases.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pantigoso.app.springbases.models.User;
import com.pantigoso.app.springbases.models.dto.ParamDto;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.name}")
    private String name;
    @Value("${config.usermane}")
    private String username;
    @Value("${config.message}")
    private String message;
    @Value("${config.listValues}")
    private List<String> listValues;

    @Value("#{'${config.listValues}'.toUpperCase().split(',')}")
    private List<String> valuesList;

    @Value("#{'${config.listValues}'.toUpperCase()}")
    private String valuesString;


    @Value("${config.code}")
    private Integer code;

    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap;

    //otra forma de llamar a los values
    @Value("#{${config.valuesMap}.product}")
    private String product;
    @Value("#{${config.valuesMap}.description}")
    private String description;


    //Objeto Enviroment para leer configuraciones (otro ejemplo)
    @Autowired
    private Environment environment;


    @GetMapping("/baz/{kk}")
    public ParamDto baz(@PathVariable(name="kk") String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mixPathVariable(@PathVariable String product, @PathVariable Long id){

        Map<String,Object> json=new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    @PostMapping("/create") //RequestBody captura los datos enviados
    public User createUser(@RequestBody User user){
        //hacer algo en la BBDD
        user.setName(user.getName().toUpperCase());

        return user;
    }

    @GetMapping("/value")
    public Map<String,Object> values() {
        Map<String,Object> map = new HashMap<>();
        map.put("name",name);
        map.put("username",username);
        map.put("message",message);
        map.put("lista",listValues);
        map.put("valuesList",valuesList);
        map.put("valuesString",valuesString);
        map.put("codigo",code);
        map.put("valueMap",valuesMap);
        map.put("product",product);
        map.put("descripción",description);

        map.put("message2",environment.getProperty("config.lastName"));

        return map;
    }
    

}
