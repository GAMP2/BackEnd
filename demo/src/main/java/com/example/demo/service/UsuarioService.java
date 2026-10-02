package com.example.demo.service;

import com.example.demo.model.Usuario;
import jakarta.validation.Valid;

import java.time.LocalDate;

public class UsuarioService {


    public static void salvarUsuarioEmJson(@Valid Usuario usuario) {
        Usuario usuario1 = new Usuario();
        usuario1.setId(usuario.getId());
        usuario1.setNome(usuario.getNome());
        usuario1.setDataCriacao(LocalDate.now());
    }
}
