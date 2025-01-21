package org.example

fun main() {
    val locadora = Locadora()
    val usuarioBruno = Usuario("Bruno", 1)

    val rearWindow = Filme("Rear Window", 1954)
    val parisTexas = Filme("Paris, Texas", 1984)
    val babettesFeast = Filme("Babette's Feast", 1987)
    val laStrada = Filme("La Strada", 1954)

    locadora.adicionarFilme(rearWindow, parisTexas, babettesFeast, laStrada)
    locadora.listarFilmesDisponiveis()

    usuarioBruno.pegarFilme(rearWindow, parisTexas)
    locadora.listarFilmesDisponiveis()

    usuarioBruno.devolverFilme(rearWindow, parisTexas)
    locadora.listarFilmesDisponiveis()
}