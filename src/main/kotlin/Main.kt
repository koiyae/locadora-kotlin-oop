package org.example

fun main() {
    val locadora = Locadora()
    val usuarioBruno = Usuario("Bruno", 1,PlanoAssinatura.BASICO)
    val usuarioEduardo = Usuario("Eduardo", 2, PlanoAssinatura.PREMIUM)

    val rearWindow = Filme("Rear Window", 1954)
    val parisTexas = Filme("Paris, Texas", 1984)
    val babettesFeast = Filme("Babette's Feast", 1987)
    val laStrada = Filme("La Strada", 1954)

    locadora.adicionarFilme(rearWindow, 20)
    locadora.adicionarFilme(laStrada, 20)

    usuarioBruno.pegarFilme(rearWindow, locadora, 1)
    usuarioBruno.devolverFilme(rearWindow, locadora)
    usuarioBruno.avaliarFilme(rearWindow, 5)
    usuarioBruno.exibirAvaliacoesUsuario()
}