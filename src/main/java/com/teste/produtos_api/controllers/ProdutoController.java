package com.teste.produtos_api.controllers;


import com.teste.produtos_api.models.Produto;
import com.teste.produtos_api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *Esse controller expõe os endpoints REST para gerenciamento de produtos.
 */

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto){
        return service.salvar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
        return service.atualizar(id,produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

}
