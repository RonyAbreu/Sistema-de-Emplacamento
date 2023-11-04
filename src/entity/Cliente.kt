package entity

import java.io.Serializable

data class Cliente(
    var nome: String,
    var telefone: String,
    var blocoDeAnotacao : String,
    var emplacamento: InfoEmplacamento) : Serializable{
}
