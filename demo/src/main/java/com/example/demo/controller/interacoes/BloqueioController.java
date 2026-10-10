package com.example.demo.controller.interacoes;

import com.example.demo.model.interacoes.Bloqueios;
import com.example.demo.service.interacoes.BloqueioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloqueios")
public class BloqueioController {

    @Autowired
    private BloqueioService bloqueioService;

    @PostMapping
    public ResponseEntity<String> bloquear(@RequestParam String idBloqueador,
                                           @RequestParam String idBloqueado,
                                           @RequestParam(required = false) String motivo) {
        String resposta = BloqueioService.bloquearUsuario(idBloqueador, idBloqueado, motivo);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping
    public ResponseEntity<String> desbloquear(@RequestParam String idBloqueador,
                                              @RequestParam String idBloqueado) {
        String resposta = bloqueioService.desbloquearUsuario(idBloqueador, idBloqueado);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{idBloqueador}")
    public ResponseEntity<List<Bloqueios>> listarBloqueados(@PathVariable String idBloqueador) {
        List<Bloqueios> lista = bloqueioService.listarBloqueados(idBloqueador);
        return ResponseEntity.ok(lista);
    }
}