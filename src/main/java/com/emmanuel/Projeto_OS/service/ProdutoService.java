package com.emmanuel.Projeto_OS.service;

import com.emmanuel.Projeto_OS.model.Produto;
import com.emmanuel.Projeto_OS.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    // Salva um produto no banco de dados
    public Produto salvar(Produto produto){
        log.info("Cadastrando produto: {}", produto);
        return repository.save(produto);
    }

    // Lista todos os produtos cadastrados
    public List<Produto> listar(){
        List<Produto> produtos = repository.findAll();
        log.info("Listando {} produtos", produtos.size());
        return produtos;
    }

    // Busca o produto pelo ID
    public Produto buscar(Long id){
        log.info("Buscando produto por ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Atualiza um produto existente
    public Produto atualizar(Long id, Produto produtoAtualizado){
        log.info("Atualizando produto ID: {}", id);
        return repository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidade(produtoAtualizado.getQuantidade());
            Produto atualizado = repository.save(produto);
            log.info("Produto atualizado: {}", atualizado);
            return atualizado;
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Remove um produto pelo ID
    public void remover(Long id){
        log.info("Removendo produto ID: {}", id);
        if (!repository.existsById(id)){
            throw new RuntimeException("Produto não encontrado");
        }
        try{
            repository.deleteById(id);
        } catch (Exception e) {
            log.info("Erro ao deletar produto: ", e);
            throw e;
        }

    }
}
