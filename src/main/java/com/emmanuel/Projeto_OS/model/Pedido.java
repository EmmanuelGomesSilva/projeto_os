package com.emmanuel.Projeto_OS.model;


import com.emmanuel.Projeto_OS.model.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único do pedido

    @PositiveOrZero(message = "Quantidade não pode ser negativa")
    private Long quantidade; //Quantidade do produto no pedido

    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.ABERTO; // Status inicial é aberto

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente; // Cliente responsável pela ordem

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produto_id")
    private Produto produto; // Produto relacionado à ordem
}
