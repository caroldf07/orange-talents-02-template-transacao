package br.com.orangetalents.consultatransacao.repository;

import br.com.orangetalents.eventotransacao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
