package br.com.orangetalents.mensageria.config;

import br.com.orangetalents.transacao.service.EventoDeTransacao;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerKafka {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println(eventoDeTransacao);
    }

}
