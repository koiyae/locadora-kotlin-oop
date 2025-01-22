package org.example

class Usuario(
    val nome: String,
    val id: Int,
) {
    private val filmesAlugados = mutableListOf<Filme>()
    private val historicoAluguel = mutableListOf<Pair<Filme, String>>()

    fun pegarFilme(filme: Filme, locadora: Locadora) {
        if (locadora.alugarFilme(filme)) {
            filmesAlugados.add(filme)
            historicoAluguel.add(filme to obterDataAtual())
            println("$nome de id $id alugou o filme: ${filme.titulo}!")
        } else {
            println("Não é possível alugar o filme ${filme.titulo}.")
        }
    }

    fun devolverFilme(filme: Filme, locadora: Locadora) {
        if(filmesAlugados.contains(filme)) {
            filmesAlugados.remove(filme)
            locadora.devolverFilme(filme)
            println("Filme ${filme.titulo} devolvido à locadora por $nome.")
        } else {
            println("$nome não tem esse filme alugado para devolver.")
        }
    }

    fun exibirHistorico() {
        println("Histórico de aluguéis de $nome:")
        historicoAluguel.forEach { (filme, data) ->
            println("${filme.titulo} - Alugado em: $data")
        }
    }

    private fun obterDataAtual(): String {
        return java.time.LocalDate.now().toString()
    }
}