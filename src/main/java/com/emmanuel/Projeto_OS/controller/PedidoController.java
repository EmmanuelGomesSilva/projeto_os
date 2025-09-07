package com.emmanuel.Projeto_OS.controller;


import com.emmanuel.Projeto_OS.model.Cliente;
import com.emmanuel.Projeto_OS.model.Pedido;
import com.emmanuel.Projeto_OS.model.Produto;
import com.emmanuel.Projeto_OS.repository.ClienteRepository;
import com.emmanuel.Projeto_OS.repository.ProdutoRepository;
import com.emmanuel.Projeto_OS.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService; // Serviço que contém a lógica do negócio
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    // Endpoint para criar um novo pedido
    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        // Buscar cliente completo
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Buscar produto completo
        Produto produto = produtoRepository.findById(pedido.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        pedido.setCliente(cliente);
        pedido.setProduto(produto);

        return pedidoService.salvar(pedido);
    }


    // Endpoint para criar múltiplos pedidos
    @PostMapping("/varios")
    public ResponseEntity<List<Pedido>> variosPedidos(@Valid @RequestBody List<Pedido> pedidos){
        List<Pedido> salvos = new ArrayList<>();
        for (Pedido p : pedidos){
            salvos.add(pedidoService.salvar(p));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(salvos);
    }


    // Endpoint para listar todas os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        return ResponseEntity.ok(pedidoService.listar());
    }

    // Endpoint para buscar uma ordem pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id){
        return ResponseEntity.ok(pedidoService.buscar(id));
    }

    // Endpoint para atualizar um pedido existente
    @PutMapping("/{id}")
    public Pedido atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.atualizarPedido(id, pedido);
    }


    // Endpoint para remover um pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPedido(@PathVariable Long id){
       pedidoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
