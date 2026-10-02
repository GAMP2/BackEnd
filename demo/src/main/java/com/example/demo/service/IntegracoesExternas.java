package com.example.demo.service;

import com.example.demo.model.Usuario;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class IntegracoesExternas {
    @GeneratedValue
    @Id
    private long id;
    private LocalDate usuarioId;
    private String provedor;
    private long id_externo;
    private String tokenAcesso;
    private String tokenAtualizacao;
    private LocalDate dataExpiracao;
    private LocalDate dataCriacao;

    IntegracoesExternas(Usuario usuario) {

    }
}
