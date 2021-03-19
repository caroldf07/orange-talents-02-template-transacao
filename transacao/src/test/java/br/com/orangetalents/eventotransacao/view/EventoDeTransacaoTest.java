package br.com.orangetalents.eventotransacao.view;

import br.com.orangetalents.eventotransacao.model.Cartao;
import br.com.orangetalents.eventotransacao.model.Estabelecimento;
import br.com.orangetalents.eventotransacao.model.Transacao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.samePropertyValuesAs;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class EventoDeTransacaoTest {

    @Test
    @DisplayName("Deve converter de Request para Model")
    void toModel() {

        EstabelecimentoEvento estabelecimentoEvento = new EstabelecimentoEvento("nome", "cidade", "endereço");
        CartaoEvento cartaoEvento = new CartaoEvento("id", "email@email.com");

        Estabelecimento estabelecimentoConvertido = estabelecimentoEvento.toModel();
        Estabelecimento estabelecimentoEsperado = new Estabelecimento("nome", "cidade", "endereço");

        Cartao cartaoConvertido = cartaoEvento.toModel();
        Cartao cartaoEsperado = new Cartao("id", "email@email.com");

        EventoDeTransacao eventoDeTransacao = new EventoDeTransacao("id", BigDecimal.TEN, estabelecimentoEvento, cartaoEvento, LocalDateTime.of(2021, 03, 19, 14, 02));

        Transacao transacaoConvertida = eventoDeTransacao.toModel();

        assertThat(transacaoConvertida, instanceOf(Transacao.class));
        assertThat(cartaoConvertido, samePropertyValuesAs(cartaoEsperado));
        assertThat(estabelecimentoConvertido, samePropertyValuesAs(estabelecimentoEsperado));
    }

}