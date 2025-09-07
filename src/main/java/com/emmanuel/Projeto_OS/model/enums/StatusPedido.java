package com.emmanuel.Projeto_OS.model.enums;

// Enum para representar o status de uma Ordem de Serviço
public enum StatusPedido {
    ABERTO, //Ordem criada, ainda não concluída
    CONCLUIDO, // Ordem finalizada com sucesso
    CANCELADO // Ordem cancelada antes da conclusão
}
