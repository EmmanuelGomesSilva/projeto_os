package com.emmanuel.Projeto_OS.repository;

import com.emmanuel.Projeto_OS.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repository do Pedido
// Fornece métodos CRUD automáticos para a entidade Pedido
// Permite criar consultas customizadas usando Spring Data JPA, caso necessário
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
