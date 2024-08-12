package com.dani.api_restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerExample {

    @RequestMapping("/iniciaSesion")
    public String hola(){
        return "ingresa  sesion!";
    }
}
