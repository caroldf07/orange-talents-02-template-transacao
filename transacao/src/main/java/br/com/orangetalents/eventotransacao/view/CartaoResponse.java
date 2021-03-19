package br.com.orangetalents.eventotransacao.view;

public class CartaoResponse {

    private String numeroCartao;
    private String email;

    public CartaoResponse(String numeroCartao, String email) {
        this.numeroCartao = numeroCartao;
        this.email = email;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getEmail() {
        return email;
    }
}
