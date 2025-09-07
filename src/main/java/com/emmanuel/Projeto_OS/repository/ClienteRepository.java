package com.emmanuel.Projeto_OS.repository;

import com.emmanuel.Projeto_OS.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repository do Cliente
// Fornece métodos CRUD automáticos (save, findAll, findById, deleteById, etc)
// Permite criar consultas customizadas se necessário
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
