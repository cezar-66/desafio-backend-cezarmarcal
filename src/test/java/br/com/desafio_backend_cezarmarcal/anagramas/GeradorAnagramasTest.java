package br.com.desafio_backend_cezarmarcal.anagramas;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeradorAnagramasTest {

    @Test
    void deve_gerar_anagramas_correto_para_entrada_simples() {
        GeradorAnagramas gerador = new GeradorAnagramas();

        List<String> anagramas = gerador.gerarAnagramas("abc");

        assertEquals(6, anagramas.size());
        assertTrue(anagramas.contains("[a, b, c]"));
        assertTrue(anagramas.contains("[a, c, b]"));
        assertTrue(anagramas.contains("[b, a, c]"));
        assertTrue(anagramas.contains("[b, c, a]"));
        assertTrue(anagramas.contains("[c, a, b]"));
        assertTrue(anagramas.contains("[c, b, a]"));
    }

    @Test
    void deve_lancar_excecao_quando_entrada_vazia() {
        GeradorAnagramas gerador = new GeradorAnagramas();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gerador.gerarAnagramas("");
        });

        assertEquals("A entrada não pode ser vazia e deve conter apenas letras.", exception.getMessage());
    }

    @Test
    void deve_lancar_excecao_quando_entrada_com_caracteres_nao_alfabeticos() {
        GeradorAnagramas gerador = new GeradorAnagramas();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gerador.gerarAnagramas("abc1");
        });

        assertEquals("A entrada não pode ser vazia e deve conter apenas letras.", exception.getMessage());
    }

    @Test
    void deve_lancar_excecao_quando_entrada_for_espaco_em_branco() {
        GeradorAnagramas gerador = new GeradorAnagramas();
        assertThrows(IllegalArgumentException.class, () -> gerador.gerarAnagramas(" "));
    }
}