package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado!");
        }
        return usuarioRepository.save(usuario);
    }
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }
    public Usuario bloquearUsuario(String id, String motivo) {
        Usuario usuario = buscarPorId(id);
        usuario.setMotivoBloqueio(motivo);
        return usuarioRepository.save(usuario);
    }
}
