package org.example

class Usuario(
    val nome: String,
    val id: Int,
) {
    private val filmesAlugados = mutableListOf<Filme>()

    fun pegarFilme(filme: Filme, locadora: Locadora) {
        if (locadora.alugarFilme(filme)) {
            filmesAlugados.add(filme)
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
}