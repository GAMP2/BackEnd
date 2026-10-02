package com.example.demo.service;

import com.example.demo.model.Usuario;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
//-----------preciso terminar
public class Suspensoes {
    @Id
    @GeneratedValue
    private int id;
    private String motivo;
    private boolean status;
    private LocalDate dataSolicitacao;
    private LocalDate dataRevisao;
    private LocalDate dataEntrega;
    private String observacaoDecisao;

    public Suspensoes() {
    }

    public String solicitarSuspensao() {
        dataSolicitacao = LocalDate.now();
        return motivo;
    }


}
