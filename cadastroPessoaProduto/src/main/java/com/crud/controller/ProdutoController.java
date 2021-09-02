package com.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//responsavel por fazer a comunicacao do brawser com a aplicacao


@RestController
public class ProdutoController {

    @GetMapping("/produto")
    public String produto() {
        return "cadastro de produto.";
    }
}
