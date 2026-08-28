package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityReturnValueHandler;

@RestController
@RequestMapping("/usuários")
public class UsuarioController {
private final UsuarioController usuarioController;

    public UsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }
    @PostMapping
    ResponseEntity<String> criarUsuario(@Valid @RequestBody Usuario usuario){
        UsuarioService.salvarUsuarioEmJson(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário salvo no JSON com sucesso!");
    }
}
