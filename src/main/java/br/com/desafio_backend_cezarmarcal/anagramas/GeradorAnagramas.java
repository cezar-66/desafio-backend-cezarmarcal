package br.com.desafio_backend_cezarmarcal.anagramas;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Criei apenas como exemplo essa Classe singleton.
 * Poderia criar um construtor privado, mas como estamos usando spring é melhor
 * deixar que o spring gerencie quando uma nova instancia deve ser criada.
 *
 * @author cezar.marcal
 * @since 09/01/2025
 * */
@Component
public class GeradorAnagramas {

    private final String MSG_WARNING = "A entrada não pode ser vazia e deve conter apenas letras.";

    public List<String> gerarAnagramas(String entrada) {
        validarEntrada(entrada);

        var letras = converterStringParaLista(entrada);
        var anagramas = new ArrayList<String>();

        gerarAnagramasRecursivo(letras, 0, anagramas);
        return anagramas;
    }

    private void validarEntrada(String entrada) {
        if (StringUtils.isBlank(entrada) || !StringUtils.isAlpha(entrada)) {
            throw new IllegalArgumentException(MSG_WARNING);
        }
    }

    private List<Character> converterStringParaLista(String entrada) {
        List<Character> lista = new ArrayList<>();

        for (char c : entrada.toCharArray()) {
            lista.add(c);
        }
        return lista;
    }

    private void gerarAnagramasRecursivo(List<Character> letras, int indiceAtual, List<String> anagramas) {

        if (indiceAtual == letras.size()) {
            anagramas.add(StringUtils.join(letras));
            return;
        }

        gerarPermutacao(letras, indiceAtual, anagramas);
    }

    private void gerarPermutacao(List<Character> letras, int indiceDePermutacao, List<String> anagramas) {
        if (indiceDePermutacao == letras.size()) {
            anagramas.add(StringUtils.join(letras));
            return;
        }

        for (int i = indiceDePermutacao; i < letras.size(); i++) {
            Collections.swap(letras, i, indiceDePermutacao);
            gerarPermutacao(letras, indiceDePermutacao + 1, anagramas);
            Collections.swap(letras, i, indiceDePermutacao);  // Desfaz a troca
        }
    }
}