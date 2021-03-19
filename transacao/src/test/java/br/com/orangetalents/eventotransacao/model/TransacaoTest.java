package br.com.orangetalents.eventotransacao.model;

import br.com.orangetalents.consultatransacao.view.TransacaoResponse;
import br.com.orangetalents.eventotransacao.view.CartaoEvento;
import br.com.orangetalents.eventotransacao.view.CartaoResponse;
import br.com.orangetalents.eventotransacao.view.EstabelecimentoEvento;
import br.com.orangetalents.eventotransacao.view.EstabelecimentoResponse;
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

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TransacaoTest {

    @Test
    @DisplayName("Deve converter de Model para Response")
    void fromModelToResponse1() {
        EstabelecimentoEvento estabelecimentoEvento = new EstabelecimentoEvento("nome", "cidade", "endereço");
        CartaoEvento cartaoEvento = new CartaoEvento("id", "email@email.com");

        Estabelecimento estabelecimentoConvertido = estabelecimentoEvento.toModel();
        Cartao cartaoConvertido = cartaoEvento.toModel();

        EstabelecimentoResponse estabelecimentoResponseConvertido = estabelecimentoConvertido.fromModelToResponse();
        CartaoResponse cartaoResponseConvertido = cartaoConvertido.fromModelToResponse();

        EstabelecimentoResponse estabelecimentoResponseEsperado = new EstabelecimentoResponse("nome", "cidade", "endereço");
        CartaoResponse cartaoResponseEsperado = new CartaoResponse("id", "email@email.com");

        Transacao transacao = new Transacao("id", BigDecimal.TEN, estabelecimentoEvento, cartaoEvento,
                LocalDateTime.of(2021, 03, 19, 14, 02));

        TransacaoResponse transacaoResponseConvertida = transacao.fromModelToResponse();

        assertThat(transacaoResponseConvertida, instanceOf(TransacaoResponse.class));
        assertThat(estabelecimentoResponseConvertido, samePropertyValuesAs(estabelecimentoResponseEsperado));
        assertThat(cartaoResponseConvertido, samePropertyValuesAs(cartaoResponseEsperado));

    }
}