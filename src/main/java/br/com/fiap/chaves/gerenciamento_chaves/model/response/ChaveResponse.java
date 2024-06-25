package br.com.fiap.chaves.gerenciamento_chaves.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChaveResponse {
    @JsonProperty("id_chave")
    private String chave;
}
