package br.com.fiap.chaves.gerenciamento_chaves.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TIPO_MANUTENCAO")
public class TipoManutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TIPO")
    private String tipo;

    public TipoManutencao(int id) {
        this.id = id;
    }
}
