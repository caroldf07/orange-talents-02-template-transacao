package br.com.orangetalents.mensageria.config;

import br.com.orangetalents.consultatransacao.repository.TransacaoRepository;
import br.com.orangetalents.eventotransacao.model.Transacao;
import br.com.orangetalents.eventotransacao.view.EventoDeTransacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerKafka {

    private final Logger logger = LoggerFactory.getLogger(ListenerKafka.class);
    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        logger.info("Recebendo transação");
        System.out.println(eventoDeTransacao.toString());
        Transacao transacao = eventoDeTransacao.toModel();
        transacaoRepository.save(transacao);
        logger.info("Transação cadastrada");
    }

}
