package br.com.orangetalents.eventotransacao.model;

import br.com.orangetalents.eventotransacao.view.EstabelecimentoResponse;

import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {

    private String estabelecimento;
    private String cidade;
    private String endereco;

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.estabelecimento = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    /*
     * Criado por conta do Hibernate
     * */
    @Deprecated
    public Estabelecimento() {
    }

    public EstabelecimentoResponse fromModelToResponse() {
        return new EstabelecimentoResponse(this.estabelecimento, this.cidade, this.endereco);
    }
}
