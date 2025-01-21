package org.example

class Locadora {
    private val filmes = mutableListOf<Filme>()

    fun adicionarFilme(vararg filme: Filme) {
        filmes.addAll(filme)
        println("Filme(s) ${filme.forEach { it.titulo }} adicionado(s) à locadora.")
    }

    fun listarFilmesDisponiveis() {
        println("Filmes disponíveis: ")
        filmes.filter { it.availability }.forEach { println("- ${it.titulo} de ${it.ano}") }
    }
}