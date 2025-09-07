package com.emmanuel.Projeto_OS.service;

import com.emmanuel.Projeto_OS.model.Cliente;
import com.emmanuel.Projeto_OS.repository.ClienteRepository;
import com.emmanuel.Projeto_OS.repository.PedidoRepository;
import com.emmanuel.Projeto_OS.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

// Serviço responsável pela lógica de negócio de Cliente
// Usamos @RequiredArgsConstructor para injetar o repository automaticamente
@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    // Salva um cliente no banco de dados
    public Cliente salvar(Cliente cliente){
        log.info("Cadastrando cliente: {}", cliente);
        return repository.save(cliente);
    }

    // Retorna todos os clientes cadastrados
    public List<Cliente> listar(){
        List<Cliente> clientes = repository.findAll();
        log.info("Listando {} clientes", clientes);
        return clientes;
    }

    // Busca um cliente pelo ID, lança exceção se não encontrado
    public Cliente buscar(Long id){
        log.info("Buscando cliente por ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    // Atualiza um cliente existente
    public Cliente atualizar(Long id, Cliente clienteAtualizado){

        return repository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            Cliente atualizado = repository.save(cliente);
            log.info("Cliente atualizado: {}", atualizado);
            return atualizado;
        }).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    // Remove um cliente pelo ID
    public void remover(Long id){
        log.info("Removendo cliente ID: {}", id);
        if (!repository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado");
        }
        repository.deleteById(id);
    }
}
