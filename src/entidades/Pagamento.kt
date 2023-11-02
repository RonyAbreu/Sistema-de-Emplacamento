package entidades

import java.time.LocalDate

data class Pagamento(
    var dataDeVencimento: LocalDate = LocalDate.now().plusDays(30),
    var parcelaVenceu: Boolean = false,
    val valorTotal: Double,
    val valorDaParcela: Double ) {


    fun calculaDataDeVencimento() : Boolean{
        val hoje = LocalDate.now()
        if (hoje > dataDeVencimento){
            parcelaVenceu = true
            return true
        }
       return false
    }

    fun calculaJurosPorDia(valorDaParcela: Double, valorTotal: Double) : Double{
        return 0.0
    }
}