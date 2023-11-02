package entidades

import java.time.LocalDate

class InfoEmplacamento(
    val nomeDaPlaca: String,
    val valorDoEmplacamento: Double,
    val quantidadeDeParcelas: Int,
    var dataDeVencimento: LocalDate = LocalDate.now().plusDays(30),
    var parcelaVenceu: Boolean = false,
    val valorTotal: Double,
    val valorDaParcela: Double ) {

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

    fun calculaValorTotal( valorDoEmplacamento: Double ) : Double {
        return valorDoEmplacamento * SimulaEmplacamento.JUROS_DAS_PARCELAS + valorDoEmplacamento
    }

    fun calculaValorDaParcela( valorDoEmplacamento: Double ) : Double {
        val valorTotal = calculaValorTotal(valorDoEmplacamento)
        if (quantidadeDeParcelas == 1) return valorTotal
        if (quantidadeDeParcelas == 2) return valorTotal / 2
        if (quantidadeDeParcelas == 3) return valorTotal / 3
        if (quantidadeDeParcelas == 4) return valorTotal / 4
        else return 0.0
    }


}