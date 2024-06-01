package br.com.fiap.chaves.gerenciamento_chaves.consumer;

import br.com.fiap.chaves.gerenciamento_chaves.model.Evento;
import br.com.fiap.chaves.gerenciamento_chaves.service.ChaveVeiculoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChaveVeiculoListener {
    private final ObjectMapper mapper = new ObjectMapper();
    private ChaveVeiculoService service;

    @Autowired
    public ChaveVeiculoListener(ChaveVeiculoService service) {
        this.service = service;
    }

    @RabbitListener(queues = {"gerenciamento-chave-queue"})
    public void consumir(String message) {
        try {
            Evento evento = mapper.readValue(message, Evento.class);
            service.criarChave(evento);
        } catch (JsonProcessingException erro) {
            log.error("Um erro ocorreu durante o consumo da mensagem");
        }
    }
}
