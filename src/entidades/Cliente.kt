package entidades

import java.time.LocalDate

data class Cliente(
    var nome: String,
    var telefone: String,
    var dataCadastro: LocalDate,
    var emplacamento: Emplacamento ) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cliente

        return emplacamento == other.emplacamento
    }

    override fun hashCode(): Int {
        return emplacamento.hashCode()
    }
}
