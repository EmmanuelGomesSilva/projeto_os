package com.emmanuel.Projeto_OS.repository;

import com.emmanuel.Projeto_OS.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repository do pedido
// Fornece métodos CRUD para a entidade pedido
// É aqui que a camada de Service interage para salvar, buscar, atualizar e remover ordens
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
