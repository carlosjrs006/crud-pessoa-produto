//package com.crud.controller;
//
//import com.crud.model.entity.Pessoa;
//import com.crud.model.repository.PessoaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RequestMapping("/api/pessoa") // url quando quiser refirir a classe
//@RestController // responsavel por fazer a comunicacao do brawser com aplicacao.
//public class PessoaController {
//
//    //    @GetMapping("/pessoas") // quando o usuario acessar essa url vai fazer o metodo que esta em baixo.
////    public String pessoa() {
////        return "cadastro de pessoas";
////    }
//    @Autowired // vai importa classe
//    private PessoaRepository repository;
//
//    @PostMapping  // insiri no banco de dados
//    @ResponseStatus(HttpStatus.CREATED)  //qual status vai sair quando de ter certo a funcao
//    public Pessoa salvar(@RequestBody Pessoa pessoa) {
//        return repository.save(pessoa);
//    }



package com.crud.controller;

import com.crud.model.entity.Pessoa;
import com.crud.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin("*")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @GetMapping("{id}")
    public Pessoa acharPessoaPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPessoa(@PathVariable Integer id) {
        repository.findById(id)
                .map(pessoa -> {
                    repository.delete(pessoa);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPessoa(@PathVariable Integer id, @RequestBody Pessoa pessoaAtualizado) {
        repository.findById(id)
                .map(pessoa -> {
                    pessoaAtualizado.setId(pessoa.getId());
                    return repository.save(pessoaAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }
}