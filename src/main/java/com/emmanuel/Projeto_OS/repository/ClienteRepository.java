package com.emmanuel.Projeto_OS.repository;

import com.emmanuel.Projeto_OS.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repository do Cliente
// Extende JpaRepository para fornecer métodos CRUD prontos (save, findAll, findById, deleteById, etc)
// Aqui podemos adicionar queries customizadas se necessário
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
