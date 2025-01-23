package org.example

enum class PlanoAssinatura(
    val nome: String,
    val mensalidade: Double,
    val descontoMulta: Double,
    val diasEmprestimo: Int,
    val limiteFilmes: Int
) {
    BASICO("Básico", 29.90, 0.0, 7, 2),
    PREMIUM("Premium", 59.90, 0.20, 14, 5);

    override fun toString(): String {
        return "$nome - Mensalidade: R$$mensalidade | Desconto Multa: ${(descontoMulta * 100).toInt()} | Dias de Empréstimo: $diasEmprestimo dias | Limite de Filmes: $limiteFilmes"
    }
}