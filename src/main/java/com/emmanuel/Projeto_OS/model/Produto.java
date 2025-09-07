package com.emmanuel.Projeto_OS.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único do produto

    @NotBlank(message = "Nome é obrigatório")
    private String nome; // Nome do produto

    @Positive(message = "Preço deve ser maior que zero")
    private Double preco; // Preço do produto

    @PositiveOrZero(message = "Quantidade não pode ser negativa")
    private Long quantidade; // Quantidade do disponível
}
