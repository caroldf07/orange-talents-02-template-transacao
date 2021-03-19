package br.com.orangetalents.eventotransacao.model;

import br.com.orangetalents.eventotransacao.view.CartaoResponse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

    @Id
    private String numeroCartao;
    @Email
    private String email;

    public Cartao(String id, @Email String email) {
        this.numeroCartao = id;
        this.email = email;
    }

    /*
     * Criado por conta do Hibernate
     * */
    @Deprecated
    public Cartao() {
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getEmail() {
        return email;
    }

    public CartaoResponse fromModelToResponse() {

        return new CartaoResponse(this.numeroCartao, this.email);
    }
}
