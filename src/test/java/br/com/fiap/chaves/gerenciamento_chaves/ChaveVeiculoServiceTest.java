package br.com.fiap.chaves.gerenciamento_chaves;

import br.com.fiap.chaves.gerenciamento_chaves.model.ChaveRequest;
import br.com.fiap.chaves.gerenciamento_chaves.model.entity.ChaveAcessoEntity;
import br.com.fiap.chaves.gerenciamento_chaves.model.entity.VeiculoEntity;
import br.com.fiap.chaves.gerenciamento_chaves.repository.ChaveVeiculoRepository;
import br.com.fiap.chaves.gerenciamento_chaves.service.ChaveVeiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChaveVeiculoServiceTest {
    private static final String ID_VEICULO = UUID.randomUUID().toString();
    @Mock
    private ChaveVeiculoRepository repositoryMock;

    private ChaveVeiculoService service;

    @BeforeEach
    void setUp() {
        this.service = new ChaveVeiculoService(this.repositoryMock);
    }

    @Test
    void test_DeveCriar_ChaveAcessoVeiculo_Corretamente() {
        when(repositoryMock.save(any(ChaveAcessoEntity.class))).thenReturn(criarChaveAcessoEntity());

        String chave = service.criarChave(criarChaveRequest());

        assertNotNull(chave);
    }

    private static ChaveRequest criarChaveRequest() {
        ChaveRequest request = new ChaveRequest();
        request.setIdVeiculo(ID_VEICULO);

        return request;
    }

    private static ChaveAcessoEntity criarChaveAcessoEntity() {
        ChaveAcessoEntity entity = new ChaveAcessoEntity();
        entity.setVeiculo(new VeiculoEntity(ID_VEICULO));
        entity.setId(UUID.randomUUID());
        return entity;
    }
}
