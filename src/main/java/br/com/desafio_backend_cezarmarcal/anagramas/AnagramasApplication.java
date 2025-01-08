package br.com.desafio_backend_cezarmarcal.anagramas;

public class AnagramasApplication {

    public static void main(String[] args) {
        GeradorAnagramas gerador = new GeradorAnagramas();

        var entrada = "abc";
        var anagramas = gerador.gerarAnagramas(entrada);

        System.out.println("Anagramas de '" + entrada + "':");
        anagramas.stream().distinct().forEach(System.out::println);
    }
}