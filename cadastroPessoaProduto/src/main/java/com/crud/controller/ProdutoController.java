/*package com.crud.controller;

import com.crud.model.entity.Produto;
import com.crud.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


//responsavel por fazer a comunicacao do brawser com a aplicacao

@RequestMapping("/api/produto")
@RestController
public class ProdutoController {

//    @GetMapping("/produto")
//    public String produto() {
//        return "cadastro de produto.";
//    }
    @Autowired
    private ProdutoRepository repository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody Produto produto) {
        return repository.save(produto) ;
    }

}*/
package com.crud.controller;

import com.crud.model.entity.Produto;
import com.crud.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvarProduto(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping("{id}")
    public Produto acharProdutoPorId(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Integer id) {
        repository.findById(id)
                .map(produto -> {
                    repository.delete(produto);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarProduto(@PathVariable Integer id, @RequestBody Produto produtoAtualizado) {
        repository.findById(id)
                .map(produto -> {
                    produtoAtualizado.setId(produto.getId());
                    return repository.save(produtoAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }
}

