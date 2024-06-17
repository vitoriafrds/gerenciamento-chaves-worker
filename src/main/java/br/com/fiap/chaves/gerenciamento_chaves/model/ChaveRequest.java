package br.com.fiap.chaves.gerenciamento_chaves.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChaveRequest {
    @JsonProperty("id_veiculo")
    private String idVeiculo;
}
