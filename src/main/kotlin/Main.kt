package org.example

fun main() {
    val locadora = Locadora()
    val usuarioBruno = Usuario("Bruno", 1)
    val usuarioEduardo = Usuario("Eduardo", 2)

    val rearWindow = Filme("Rear Window", 1954)
    val parisTexas = Filme("Paris, Texas", 1984)
    val babettesFeast = Filme("Babette's Feast", 1987)
    val laStrada = Filme("La Strada", 1954)

    locadora.adicionarFilme(rearWindow, 2)
    locadora.adicionarFilme(babettesFeast, 5)
    locadora.adicionarFilme(laStrada, 7)
    locadora.adicionarFilme(parisTexas, 6)

    usuarioBruno.pegarFilme(babettesFeast, locadora)
    usuarioBruno.pegarFilme(parisTexas, locadora)
    usuarioBruno.devolverFilme(babettesFeast, locadora)
    usuarioEduardo.pegarFilme(laStrada, locadora)
    usuarioEduardo.pegarFilme(parisTexas, locadora)
    locadora.listarFilmesDisponiveis()
}