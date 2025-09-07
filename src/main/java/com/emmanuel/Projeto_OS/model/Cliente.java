package com.emmanuel.Projeto_OS.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único do cliente no banco

    @NotBlank(message = "Nome é obrigatório")
    private String nome; // Nome do cliente

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email; // Email do cliente

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;// Telefone do cliente


}
