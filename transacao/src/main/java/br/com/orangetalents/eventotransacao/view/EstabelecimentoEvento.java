package br.com.orangetalents.eventotransacao.view;

import br.com.orangetalents.eventotransacao.model.Estabelecimento;

public class EstabelecimentoEvento {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoEvento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    /*
     * Criado por conta do Jackson
     * */
    @Deprecated
    public EstabelecimentoEvento() {
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }
}
