package br.com.fiap.chaves.gerenciamento_chaves.repository;

import br.com.fiap.chaves.gerenciamento_chaves.model.entity.ChaveAcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChaveVeiculoRepository extends JpaRepository<ChaveAcessoEntity, UUID> {
}
