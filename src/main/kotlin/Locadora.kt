package org.example

class Locadora {
    private val filmes = mutableMapOf<Filme, Int>()

    fun adicionarFilme(filme: Filme, quantidade: Int) {
        filmes[filme] = filmes.getOrDefault(filme, 0) + quantidade
        println("${filme.titulo} adicionado ao estoque. Total: ${filmes[filme]}")
    }

    fun alugarFilme(filme: Filme, quantidade: Int = 1): Boolean {
        val quantidadeDisponivel = filmes[filme] ?: 0

        return if (quantidadeDisponivel > 0) {
            filmes[filme] = quantidadeDisponivel - quantidade
            println("${filme.titulo} foi alugado. Restantes: ${filmes[filme]}")
            true
        } else {
            println("${filme.titulo} está indisponível no momento.")
            false
        }
    }

    fun devolverFilme(filme: Filme) {
        filmes[filme] = filmes.getOrDefault(filme, 0 ) + 1
        println("${filme.titulo} foi devolvido. Total: ${filmes[filme]}")
    }

    fun verificarDisponibilidade(filme: Filme) {
        if((filmes[filme] ?: 0 ) > 0) {
            println("O filme $filme está disponível.")
        } else {
            println("O filme ${filme.titulo} está indisponível.")
        }
    }

    fun listarFilmesDisponiveis() {
        println("Filmes disponíveis: ")
        var totalDisponivel = 0

        filmes.filter { (_, quantidade) -> quantidade > 0 }
            .forEach { (filme, quantidade) ->
                println("${filme.titulo} - Quantidade: $quantidade")
                totalDisponivel += quantidade
            }
        println("- Total de filmes disponíveis: $totalDisponivel")
    }
}