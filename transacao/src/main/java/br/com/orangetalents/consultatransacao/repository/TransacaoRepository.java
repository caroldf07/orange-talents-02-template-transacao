package br.com.orangetalents.consultatransacao.repository;

import br.com.orangetalents.eventotransacao.model.Cartao;
import br.com.orangetalents.eventotransacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {

    List<Transacao> findFirst10ByCartaoNumeroCartaoOrderByEfetivadaEmDesc(String numeroCartao);
}
