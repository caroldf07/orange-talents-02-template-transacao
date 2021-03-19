package br.com.orangetalents.eventotransacao.model;

import br.com.orangetalents.consultatransacao.view.TransacaoResponse;
import br.com.orangetalents.eventotransacao.view.CartaoEvento;
import br.com.orangetalents.eventotransacao.view.EstabelecimentoEvento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transacao {

    @Id
    private String id;
    private BigDecimal valor;
    @Embedded
    private Estabelecimento estabelecimento;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    public Transacao(String id, BigDecimal valor,
                     EstabelecimentoEvento estabelecimento,
                     CartaoEvento cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento.toModel();
        this.cartao = cartao.toModel();
        this.efetivadaEm = efetivadaEm;
    }

    /*
     * Criado por conta do hibernate
     * */
    public Transacao() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(id, transacao.id) && Objects.equals(valor, transacao.valor) && Objects.equals(estabelecimento, transacao.estabelecimento) && Objects.equals(cartao, transacao.cartao) && Objects.equals(efetivadaEm, transacao.efetivadaEm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, estabelecimento, cartao, efetivadaEm);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public TransacaoResponse fromModelToResponse() {
        return new TransacaoResponse(this.valor, this.estabelecimento, this.cartao, this.efetivadaEm);
    }
}
