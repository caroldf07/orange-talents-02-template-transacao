package br.com.orangetalents.consultatransacao.controller;

import br.com.orangetalents.consultatransacao.repository.CartaoRepository;
import br.com.orangetalents.consultatransacao.repository.TransacaoRepository;
import br.com.orangetalents.eventotransacao.model.Cartao;
import br.com.orangetalents.eventotransacao.model.Transacao;
import br.com.orangetalents.eventotransacao.view.CartaoRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("Test")
class TransacaoControllerTest {

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    Transacao transacao;

    @Mock
    CartaoRepository cartaoRepository = Mockito.mock(CartaoRepository.class);



    @Test
    @DisplayName("Deve dar um erro 404")
    void buscaCartao() {

        CartaoRequest cartaoRequest = new CartaoRequest("8765435678");

        Cartao cartao = new Cartao(anyString(),eq("email@email.com"));


        when(cartaoRepository.getOne(anyString())).thenReturn(cartao);

        assertNull(cartao);

    }

    @Test
    void buscarTransacoes() {
    }
}