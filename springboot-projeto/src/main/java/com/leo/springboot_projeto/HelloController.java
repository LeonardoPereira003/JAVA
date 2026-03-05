package com.leo.springboot_projeto;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

        @GetMapping("/")
    public String hello() {
        return "Projeto Spring Boot funcionando!";
    }


}




