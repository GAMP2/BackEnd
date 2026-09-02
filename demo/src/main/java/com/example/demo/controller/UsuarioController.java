package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityReturnValueHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    ResponseEntity<String> criarUsuario(@Valid @RequestBody Usuario usuario) {
        us.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário salvo no JSON com sucesso!");
    }

    // HTTP Status: 200 OK
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodas() {
        return ResponseEntity.ok(us);

    }

    @GetMapping("/{id}")
    ResponseEntity<Usuario> buscarPorId(@PathVariable long id) {
        for (Usuario u : us) {
            //Se achar um usuário com o mesmo id fornecido, retorna o usuário encontrado com Status 200 OK
            if (u.getId().equals(id)) {
                return ResponseEntity.ok(u);
            }
        }//Caso o loop acabe sem encontrar nenhum usuário compatível, retorna o código de Status 404 Not Found
        return ResponseEntity.notFound().build();
    }// PATCH - Atualização parcial (ex: http://localhost:8080/usuários/1)

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> atualizarParcial(@PathVariable Long id, @RequestBody Usuario dados) {
        for (Usuario u : us) {
            if (u.getId().equals(id)) {

                // Só altera o nome se um novo nome for enviado no JSON
                if (dados.getNome() != null) {
                    u.setNome(dados.getNome());
                }

                // Só altera o e-mail se um novo e-mail for enviado no JSON
                if (dados.getEmail() != null) {
                    u.setEmail(dados.getEmail());
                }

                return ResponseEntity.ok(u); // Devolve o usuário com os dados atualizados (Status 200)
            }
        }
        return ResponseEntity.notFound().build(); // Se não achar o ID (Status 404)
    }

    //Usa a função removeIf para procurar na lista us o usuário que possui aquele id e removê-lo.
    // Retorna true se achou e removeu, ou false se não encontrou.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = us.removeIf(u -> u.getId().equals(id));
        if (removido) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

