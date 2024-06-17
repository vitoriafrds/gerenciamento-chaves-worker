package br.com.fiap.chaves.gerenciamento_chaves.service;

import br.com.fiap.chaves.gerenciamento_chaves.model.entity.ChaveAcessoEntity;
import br.com.fiap.chaves.gerenciamento_chaves.model.entity.VeiculoEntity;
import br.com.fiap.chaves.gerenciamento_chaves.model.ChaveRequest;
import br.com.fiap.chaves.gerenciamento_chaves.repository.ChaveVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ChaveVeiculoService {
    private ChaveVeiculoRepository repository;

    @Autowired
    public ChaveVeiculoService(ChaveVeiculoRepository repository) {
        this.repository = repository;
    }

    public void criarChave(ChaveRequest evento) {
        ChaveAcessoEntity chave = new ChaveAcessoEntity();
        chave.setDataCriacao(LocalDate.now());
        chave.setVeiculo(new VeiculoEntity(evento.getIdVeiculo()));

        repository.save(chave);
    }
}
