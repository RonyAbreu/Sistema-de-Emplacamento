package entity

import java.time.LocalDate

data class InfoEmplacamento(
    val nomeDaPlaca: String,
    val valorDoEmplacamento: Double,
    val valorDeEntrada: Double,
    val quantidadeDeParcelas: Int,
    var dataDeVencimento: LocalDate,
    var parcelaVenceu: Boolean) {

    var valorTotal: Double = calculaValorTotal()
    var valorDaParcela: Double = calculaValorDaParcela()



    fun calculaDataDeVencimento(): Int {
        val hoje = LocalDate.now()
        if (hoje > dataDeVencimento) {
            parcelaVenceu = true
        }
        return hoje.until(dataDeVencimento).days
    }

    fun calculaParcelaComJuros(valorDaParcela: Double): Double {
        val diasVencidos = calculaDataDeVencimento()
        val jurosDias = valorDaParcela * 0.001
        if (parcelaVenceu) {
            val valorDoJuros = jurosDias * diasVencidos + valorDaParcela
            return valorDoJuros
        }
        return 0.0
    }

    fun calculaValorTotal() : Double {
        var valorMenosAEntrada : Double = valorDoEmplacamento - valorDeEntrada
        return valorMenosAEntrada * SimulaEmplacamento.JUROS_DAS_PARCELAS + valorMenosAEntrada
    }

    fun calculaValorDaParcela() : Double {
        val valorTotal = calculaValorTotal()
        if (quantidadeDeParcelas == 1) return valorTotal
        if (quantidadeDeParcelas == 2) return valorTotal / 2
        if (quantidadeDeParcelas == 3) return valorTotal / 3
        if (quantidadeDeParcelas == 4) return valorTotal / 4
        else return 0.0
    }

    override fun toString(): String {
        return "InfoEmplacamento(nomeDaPlaca='$nomeDaPlaca', valorDoEmplacamento=$valorDoEmplacamento, valorDeEntrada=$valorDeEntrada, quantidadeDeParcelas=$quantidadeDeParcelas, dataDeVencimento=$dataDeVencimento, parcelaVenceu=$parcelaVenceu, valorTotal=$valorTotal, valorDaParcela=$valorDaParcela)"
    }
}