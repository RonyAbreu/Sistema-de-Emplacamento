package entidades

import java.time.LocalDate

data class Cliente(
    var nome: String,
    var telefone: String,
    var dataCadastro: LocalDate,
    var blocoDeAnotacao : String,
    var emplacamento: InfoEmplacamento) {
}
