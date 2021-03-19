package br.com.orangetalents.consultatransacao.controller;

import br.com.orangetalents.consultatransacao.repository.TransacaoRepository;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping()
    public ResponseEntity<?> buscaCartao(@RequestBody @Valid CartaoRequest cartaoRequest,
                                         UriComponentsBuilder uriComponentsBuilder) {
        logger.info("Procurando cartão");
        Cartao cartao = em.find(Cartao.class, cartaoRequest.getNumeroCartao());

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
        Cartao cartao = em.find(Cartao.class, numeroCartao);

        if (cartao == null) {
            assertNull(cartao, "Bug ao procurar cartão");
            logger.warn("Cartão não encontrando");
            return ResponseEntity.notFound().build();
        }

        List<Transacao> transacao = transacaoRepository.findByCartao(cartao.getId());

        return ResponseEntity.ok().build();
    }
}
