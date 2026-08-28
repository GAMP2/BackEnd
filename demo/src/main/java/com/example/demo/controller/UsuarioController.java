package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityReturnValueHandler;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuários")
public class UsuarioController {
//private final UsuarioController usuarioController;
//
//    public UsuarioController(UsuarioController usuarioController) {
//        this.usuarioController = usuarioController;
//    }

    List<Usuario> us = new ArrayList<>();
    @PostMapping
    ResponseEntity<String> criarUsuario(@Valid @RequestBody Usuario usuario){
        us.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário salvo no JSON com sucesso!");
    }


    @GetMapping
    public List<Usuario> mostrar(){
        return us;
    }
}
