package br.com.orangetalents.eventotransacao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cartao {

    @Id
    private String id;
    @Email
    private String email;

    @OneToMany(mappedBy = "cartao")
    private Set<Transacao> transacoes = new HashSet<>();

    public Cartao(String id, @Email String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
