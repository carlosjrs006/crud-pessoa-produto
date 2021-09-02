package com.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @GetMapping("/pessoas")
    public String pessoa() {
        return "cadastro de pessoas";
    }
}

