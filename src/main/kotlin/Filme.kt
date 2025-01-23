package org.example

data class Filme(
    val titulo: String,
    val ano: Int,
    var availability: Boolean = true
) {
    private val avaliacoes = mutableListOf<Int>()

    fun adicionarAvaliacao(nota: Int) {
        if (nota in 1..5) {
            avaliacoes.add(nota)
            println("Nota $nota adicionada ao filme $titulo")
        } else {
            println("Nota invalida. A avaliação deve estar entre 1 e 5")
        }
    }

    fun obterMediaAvaliacoes(): Double {
        return if(avaliacoes.isNotEmpty()) avaliacoes.average() else 0.0
    }

    override fun toString(): String {
        return "$titulo ($ano) - Média de avaliações: ${"%.2f".format(obterMediaAvaliacoes())}"
    }
}