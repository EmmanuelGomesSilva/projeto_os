package com.emmanuel.Projeto_OS.controller;


import com.emmanuel.Projeto_OS.model.Cliente;
import com.emmanuel.Projeto_OS.model.Produto;
import com.emmanuel.Projeto_OS.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    // Endpoint para criar um produto
    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@Valid @RequestBody Produto produto){
        Produto salvo = service.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // Endpoint para criar múltiplos produtos
    @PostMapping("/varios")
    public ResponseEntity<List<Produto>> cadastrarVarios(@Valid @RequestBody List<Produto> produtos){
        List<Produto> salvos = new ArrayList<>();
        for (Produto p : produtos){
            salvos.add(service.salvar(p));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(salvos);
    }

    // Endpoint para listar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        return ResponseEntity.ok(service.listar());
    }

    // Endpoint para buscar produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto>BuscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }


    // Endpoint para atualizar um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Produto> AtualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produto){
        return ResponseEntity.ok(service.atualizar(id, produto));
    }

    // Endpoint para remover um produto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProdutoPorId(@PathVariable Long id){
       service.remover(id);
       return ResponseEntity.noContent().build();
    }

}
