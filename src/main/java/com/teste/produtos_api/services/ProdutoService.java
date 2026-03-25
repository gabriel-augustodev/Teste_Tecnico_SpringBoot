package com.teste.produtos_api.services;


import com.teste.produtos_api.exceptions.ProdutoNotFoundException;
import com.teste.produtos_api.models.Produto;
import com.teste.produtos_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Camada de negócio da API
 */

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listar(){
        return repository.findAll();
    }

    public Produto buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("Produto com ID " + id + " não encontrado"));
    }

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto){
        Produto existente = repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("Produto com ID " + id + " não encontrado"));

         existente.setNome(produto.getNome());
         existente.setPreco(produto.getPreco());
         existente.setDescricao(produto.getDescricao());
         existente.setCategoria(produto.getCategoria());

         return repository.save(existente);

    }

    public void deletar(Long id){

        Produto existente = repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException("Produto com ID " + id + " não encontrado"));
        repository.delete(existente);
    }

}
