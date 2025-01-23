package org.example

import java.time.LocalDate
import java.time.temporal.ChronoUnit

class Usuario(
    val nome: String,
    val id: Int,
    val plano: PlanoAssinatura
) {
    private val filmesAlugados = mutableListOf<Pair<Filme, LocalDate>>()
    private val historicoAluguel = mutableListOf<Pair<Filme, String>>()
    private val avaliacoesUsuario = mutableMapOf<Filme, Int>()

    fun pegarFilme(filme: Filme, locadora: Locadora, diasAluguel: Long = 7) {
        if(filmesAlugados.size >= plano.limiteFilmes || diasAluguel >= plano.diasEmprestimo) {
            println("$nome atingiu o limite do plano ${plano.nome}!")
            return
        }

        if (locadora.alugarFilme(filme)) {
            val dataDevolucao = LocalDate.now().plusDays(diasAluguel)
            filmesAlugados.add(filme to dataDevolucao)
            historicoAluguel.add(filme to obterDataAtual())
            println("$nome de id $id alugou o filme: ${filme.titulo}!")
        } else {
            println("Não é possível alugar o filme ${filme.titulo}.")
        }
    }

    fun devolverFilme(filme: Filme, locadora: Locadora) {
        val aluguel = filmesAlugados.find { it.first == filme }
        if(aluguel != null) {
            val (filmeAlugado, dataDevolucao) = aluguel
            val dataAtual = LocalDate.now()

            if(dataAtual.isAfter(dataDevolucao)) {
                val diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, dataAtual)
                val multa = diasAtraso * 5.0
                println("Devolução atrasada! Multa de R$$multa")
            } else {
                println("Filme devolvido sem atraso. Obrigado")
            }

            filmesAlugados.remove(aluguel)
            locadora.devolverFilme(filme)
        } else {
            println("$nome não possui esse filme para devolver.")
        }
    }

    fun exibirHistorico() {
        println("Histórico de aluguéis de $nome:")
        historicoAluguel.forEach { (filme, data) ->
            println("${filme.titulo} - Alugado em: $data")
        }
    }

    fun avaliarFilme(filme: Filme, nota: Int) {
        if(!historicoAluguel.any {it.first == filme}) {
            println("Você não pode avaliar um filme que não alugou.")
            return
        }

        if(avaliacoesUsuario.containsKey(filme)) {
            println("Você já avaliou este filme.")
            return
        }

        println("Digite uma nota de 1 a 5 para o filme ${filme.titulo}.")

        if(nota in 1..5) {
            avaliacoesUsuario[filme] = nota
            filme.adicionarAvaliacao(nota)
            println("$nome avaliou ${filme.titulo} com nota $nota.")
        } else {
            println("Nota inválida. Avaliação cancelada")
        }
    }

    fun exibirAvaliacoesUsuario() {
        println("Avaliações de $nome:")
        avaliacoesUsuario.forEach { (filme, nota) ->
            println("${filme.titulo} ($nota/5)")
        }
    }

    private fun obterDataAtual(): String {
        return LocalDate.now().toString()
    }
}