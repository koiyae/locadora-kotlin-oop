package org.example

class Filme(
    val titulo: String,
    val ano: Int,
    var availability: Boolean = true
) {

    fun pegarFilme() {
        if(availability) {
            availability = false
            println("O filme $titulo foi alugado com sucesso!")
        } else {
            println("O filme $titulo não está disponível para ser alugado.")
        }
    }

    fun devolverFilme() {
        availability = true
        println("O filme $titulo foi devolvido com sucesso!")
    }

}