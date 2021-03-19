package br.com.orangetalents.consultatransacao.view;

import br.com.orangetalents.eventotransacao.model.Cartao;
import br.com.orangetalents.eventotransacao.model.Estabelecimento;
import br.com.orangetalents.eventotransacao.view.CartaoResponse;
import br.com.orangetalents.eventotransacao.view.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.valor = valor;
        this.estabelecimento = estabelecimento.fromModelToResponse();
        this.cartao = cartao.fromModelToResponse();
        this.efetivadaEm = efetivadaEm;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }


}
