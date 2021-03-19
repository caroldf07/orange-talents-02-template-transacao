package br.com.orangetalents.eventotransacao.view;

import br.com.orangetalents.eventotransacao.model.Cartao;

public class CartaoEvento {
    private String id;
    private String email;

    public CartaoEvento(String id, String email) {
        this.id = id;
        this.email = email;
    }

    /*
     * Criado por conta do Jackson
     * */
    @Deprecated
    public CartaoEvento() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel() {
        return new Cartao(this.id, this.email);
    }
}
