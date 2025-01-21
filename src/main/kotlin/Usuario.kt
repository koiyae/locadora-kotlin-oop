package org.example

class Usuario (
    nome: String,
    id: Int,
){
    fun pegarFilme(vararg filmes: Filme) {
        for(filme in filmes) {
            if(filme.availability) {
                filme.pegarFilme()
            }
            else {
                println("Não é possível pegar o filme ${filme.titulo}.")
            }
        }
    }

    fun devolverFilme(vararg filmes: Filme) {
        for(filme in filmes) {
            filme.devolverFilme()
        }
    }
}