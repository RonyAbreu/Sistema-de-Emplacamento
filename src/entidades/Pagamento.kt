package entidades

import util.Juros
import java.time.LocalDate

class Pagamento(
    val dataDeVencimento: LocalDate,
    var parcelaVenceu: Boolean = false,
    val valorTotal: Double,
    val valorDaParcela: Double ) {


    fun calculaDataDeVencimento( dataDeVencimento: LocalDate ) {


    }

    fun calculaJurosPorDia(dataDeVencimento: LocalDate, valorDaParcela: Double, valorTotal: Double){



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