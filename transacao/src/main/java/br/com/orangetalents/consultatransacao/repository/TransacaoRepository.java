package br.com.orangetalents.consultatransacao.repository;

import br.com.orangetalents.eventotransacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    List<Transacao> findByCartao(String numeroCartao);
}
