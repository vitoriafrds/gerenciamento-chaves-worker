package br.com.fiap.chaves.gerenciamento_chaves.controller;

import br.com.fiap.chaves.gerenciamento_chaves.model.ChaveRequest;
import br.com.fiap.chaves.gerenciamento_chaves.service.ChaveVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chaves")
public class ChaveController {
    private ChaveVeiculoService service;

    @Autowired
    public ChaveController(ChaveVeiculoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ChaveRequest request) {
        service.criarChave(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
