package com.teste.produtos_api.repository;

import com.teste.produtos_api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * responsável por fazer a comunicação com o banco de dados.
 */

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
