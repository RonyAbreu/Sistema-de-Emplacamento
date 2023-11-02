package entidades

import java.time.LocalDate

data class Cliente(
    var nome: String,
    var telefone: String,
    var dataCadastro: LocalDate = LocalDate.now(),
    var emplacamento: InfoEmplacamento,
    var blocoDeAnotacao : String) {
}
