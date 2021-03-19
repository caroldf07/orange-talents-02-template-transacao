package br.com.orangetalents.eventotransacao.view;

import br.com.orangetalents.eventotransacao.model.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EventoDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(EventoDeTransacao.class);

    private String id;
    private BigDecimal valor;
    private EstabelecimentoEvento estabelecimento;
    private CartaoEvento cartao;
    private LocalDateTime efetivadaEm;

    public EventoDeTransacao(String id, BigDecimal valor,
                             EstabelecimentoEvento estabelecimento, CartaoEvento cartao,
                             LocalDateTime efetivadaEm) {
        logger.info("Recebendo transação");
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
        assertNotNull(id, "Bug ao receber a transação");
        assertNotNull(cartao, "Bug ao receber a transação");
        assertNotNull(estabelecimento, "Bug ao receber a transação");
    }

    /*
     * Criado por conta do Jackson
     * */
    @Deprecated
    public EventoDeTransacao() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoEvento getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoEvento getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel() {

        return new Transacao(this.id, this.valor, this.estabelecimento, this.cartao, this.efetivadaEm);
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
