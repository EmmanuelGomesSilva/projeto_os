package com.emmanuel.Projeto_OS.service;

import com.emmanuel.Projeto_OS.model.Pedido;
import com.emmanuel.Projeto_OS.repository.PedidoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    // Criar pedido a partir de DTO
    public Pedido salvar(@Valid @RequestBody Pedido pedido) {
        log.info("Cadastrando pedido: {}", pedido);
        return pedidoRepository.save(pedido);
    }
    // Listar todos
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    // Buscar por ID
    public Pedido buscar(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    // Atualizar
    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setQuantidade(pedidoAtualizado.getQuantidade());
            pedido.setStatus(pedidoAtualizado.getStatus());
            pedido.setCliente(pedidoAtualizado.getCliente());
            pedido.setProduto(pedidoAtualizado.getProduto());
            Pedido atualizado = pedidoRepository.save(pedido);
            log.info("Pedido atualizado : {}", atualizado);
            return atualizado;
        }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

    }

    // Remover
    public void remover(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }
        pedidoRepository.deleteById(id);
        log.info("Pedido removido ID: {}", id);
    }
}
