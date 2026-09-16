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
@RequestMapping("usuarios")
public class UsuarioController {
    List<Usuario> usuarios = new ArrayList<>();
    private long nextId = 1L;

    @PostMapping
    public String criarUsuarios(@RequestBody Usuario usuario) {
        usuario.setId(nextId++);
        usuarios.add(usuario);
        return "Usuario criado com sucesso!";
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarios;

    }

    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable long id) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                usuarios.remove(u);
                return "Usuário removido com sucesso";
            }
        }
        return "Usuário não encontrado";
    }

    @PatchMapping("/{id}")
    public String alterarUsuario(@PathVariable long id, @RequestBody Usuario dados) {
        for (Usuario u : usuarios)
            if (u.getId().equals(id)) {
                if (u.getNome() != null) {
                    u.setNome(dados.getNome());
                    return "Nome redefinido com sucesso!";
//email,idade,datnsc,senha
                }
                if (u.getEmail() != null) {
                    u.setEmail(dados.getEmail());
                    return "Email redefinido com sucesso!";
                }
                if (u.getDtNasc() != null) {
                    u.setDtNasc(dados.getDtNasc());
                    return "Data de nascimento redefinida com sucesso";
                }
                if (u.getIdade() != 0) {
                    u.setIdade(dados.getIdade());
                    return "Idade redefinida com sucesso";
                }
                if (u.getSenha() != null) {
                    u.setSenha(dados.getSenha());
                    return "Senha redefinida com sucesso";
                }
                return "Usuario nao encontrado";
            }
        return "";
    }
            @PutMapping("/{id}")
            public String atualizarUsuario ( @PathVariable long id, @RequestBody Usuario dados){

                for (Usuario usuario : usuarios) {

                    if (usuario.getId().equals(id)) {

                        usuario.setNome(dados.getNome());
                        usuario.setEmail(dados.getEmail());
                        usuario.setIdade(dados.getIdade());
                        usuario.setDtNasc(dados.getDtNasc());
                        usuario.setSenha(dados.getSenha());

                        return "Usuário atualizado com sucesso!";
                    }return "Usuário nâo encontrado";
            }

                return "";
            }}



