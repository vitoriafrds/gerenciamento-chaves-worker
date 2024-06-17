package br.com.fiap.chaves.gerenciamento_chaves.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MANUTENCAO")
public class ManutencaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    @Column(name = "QUILOMETRAGEM_ATUAL")
    private long quilometragemAtual;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    private VeiculoEntity veiculo;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tipo_manutencao", referencedColumnName = "id")
    private TipoManutencao tipoManutencao;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "componente_id", referencedColumnName = "id")
    private ComponenteEntity componente;
}
