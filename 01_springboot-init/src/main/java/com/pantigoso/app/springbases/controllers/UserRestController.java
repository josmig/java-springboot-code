package com.pantigoso.app.springbases.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.pantigoso.app.springbases.models.User;
import com.pantigoso.app.springbases.models.dto.UserDto;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Controllers
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class UserRestController {


    @GetMapping("/saludo")
    public UserDto saludo(){
        
        UserDto userDto = new UserDto();
        User user = new User("José","Puraca");

        userDto.setUser(user);
        userDto.setTitle("Hola utilizando UserDTO");

        return userDto;
    }

    @GetMapping("/saludo2")
    public Map<String,Object> saludoRest() {
        
        Map<String,Object> body = new HashMap<>();
        User usuario = new User("Miguel", "Pantigoso");
        body.put("title", "Hola mundo");
        body.put("user",usuario);

        return body; //aca la vista no es un html si no una presentacion osea un JSON
    }


    @GetMapping("/list")
    public List<User> list(){
        User user= new User("Gabriel", "Rincon");
        User user2 = new User("Jonathan", "Achahui");
        User user3 = new User("Miguel", "Pantigoso") ;

        List<User> users = Arrays.asList(user,user2,user3);
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);
        return users;
    }

    
}
