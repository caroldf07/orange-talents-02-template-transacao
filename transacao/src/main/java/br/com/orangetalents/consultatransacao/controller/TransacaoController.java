package br.com.orangetalents.consultatransacao.controller;

import br.com.orangetalents.consultatransacao.repository.CartaoRepository;
import br.com.orangetalents.consultatransacao.repository.TransacaoRepository;
import br.com.orangetalents.consultatransacao.view.TransacaoResponse;
import br.com.orangetalents.eventotransacao.model.Cartao;
import br.com.orangetalents.eventotransacao.model.Transacao;
import br.com.orangetalents.eventotransacao.view.CartaoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;

//Carga de 9
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

    //1
    @Autowired
    private TransacaoRepository transacaoRepository;

    //1
    @Autowired
    private CartaoRepository cartaoRepository;

    @PostMapping()
    public ResponseEntity<?> buscaCartao(@RequestBody @Valid CartaoRequest cartaoRequest,
                                         UriComponentsBuilder uriComponentsBuilder) {
        logger.info("Procurando cartão");
        //1
        Optional<Cartao> cartao = cartaoRepository.findById(cartaoRequest.getNumeroCartao());

        //1
        if (cartao == null) {
            assertNull(cartao, "Bug ao procurar cartão");
            logger.warn("Cartão não encontrando");
            return ResponseEntity.notFound().build();
        }
        URI location = uriComponentsBuilder.path("/numeroCartao").buildAndExpand(cartaoRequest.getNumeroCartao()).toUri();
        return ResponseEntity.status(302).body(new RedirectView("redirect:" + location));
    }

    @GetMapping("/{numeroCartao}")
    public ResponseEntity<?> buscarTransacoes(@PathVariable("numeroCartao") String numeroCartao) {
        logger.info("Procurando cartão");
        Optional<Cartao> cartao = cartaoRepository.findById(numeroCartao);

        //1
        if (cartao == null) {
            assertNull(cartao, "Bug ao procurar cartão");
            logger.warn("Cartão não encontrando");
            return ResponseEntity.notFound().build();
        }

        logger.info("Procurando transações");
        //1
        List<Transacao> transacoes = transacaoRepository.findFirst10ByCartaoNumeroCartaoOrderByEfetivadaEmDesc(cartao.get().getNumeroCartao());
        //1
        List<TransacaoResponse> transacaoResponses = new ArrayList<>();
        //1
        transacoes.forEach(transacao -> {
            transacaoResponses.add(transacao.fromModelToResponse());
        });
        logger.info("Transações encontradas");
        return ResponseEntity.ok().body(transacaoResponses);
    }
}
