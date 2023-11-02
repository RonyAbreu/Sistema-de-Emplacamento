package entidades

import util.Juros
import java.time.LocalDate

data class Pagamento(
    var dataDeVencimento: LocalDate = LocalDate.now().plusDays(31),
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


    fun calculaValorTotal(valorDoEmplacamento: Double, quantidadeDeParcelas: Int): Double {
        if (quantidadeDeParcelas == 1) return valorDoEmplacamento
        if (quantidadeDeParcelas == 2) return valorDoEmplacamento * Juros.JUROS_DE_2_PARCELAS + valorDoEmplacamento
        if (quantidadeDeParcelas == 3) return valorDoEmplacamento * Juros.JUROS_DE_3_PARCELAS + valorDoEmplacamento
        return if (quantidadeDeParcelas == 4) valorDoEmplacamento * Juros.JUROS_DE_4_PARCELAS + valorDoEmplacamento else 0.0
    }

    fun calculaValorDaParcela(valorDoEmplacamento: Double, quantidadeDeParcelas: Int): Double {
        val valorTotal = calculaValorTotal(valorDoEmplacamento, quantidadeDeParcelas)
        if (quantidadeDeParcelas == 1) return valorTotal
        if (quantidadeDeParcelas == 2) return valorTotal / 2
        if (quantidadeDeParcelas == 3) return valorTotal / 3
        return if (quantidadeDeParcelas == 4) valorTotal / 4 else 0.0
    }
}