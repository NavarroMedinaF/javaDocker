package com.facundo.javaDocker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/api/hola")
    public ResponseEntity<String> helloWord(){
        return ResponseEntity.ok("Facu");
    }
}
