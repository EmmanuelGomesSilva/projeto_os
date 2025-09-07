package com.emmanuel.Projeto_OS.controller;

import com.emmanuel.Projeto_OS.model.Cliente;
import com.emmanuel.Projeto_OS.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    // Endpoint para criar um cliente
    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@Valid @RequestBody Cliente cliente){
        Cliente salvo = service.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
    // Endpoint para criar múltiplos clientes
    @PostMapping("/varios")
    public ResponseEntity<List<Cliente>> salvarVariosClientes(@Valid @RequestBody List<Cliente> clientes){
        List<Cliente> salvos = new ArrayList<>();
        for (Cliente c : clientes){
            salvos.add(service.salvar(c));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(salvos);
    }

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.ok(service.listar());
    }

    // Endpoint para buscar cliente pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));

    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
        return ResponseEntity.ok(service.atualizar(id,cliente));
    }

    // Endpoint para remover um cliente pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerClientePorId(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
