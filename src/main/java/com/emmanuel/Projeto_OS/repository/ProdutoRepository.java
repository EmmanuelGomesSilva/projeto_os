package com.emmanuel.Projeto_OS.repository;

import com.emmanuel.Projeto_OS.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
// Repository do Produto
// Fornece métodos CRUD automáticos para a entidade Produto
// Permite criar consultas customizadas usando Spring Data JPA, caso necessário
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
