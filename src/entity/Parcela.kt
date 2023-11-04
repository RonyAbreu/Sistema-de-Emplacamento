package entity

import java.io.Serializable
import java.time.LocalDate

data class Parcela(
    val dataDeVencimento: LocalDate = LocalDate.now().plusDays(30) ) : Serializable {

    val valorDaParcela: Double = calculaValorDaParcela(InfoEmplacamento().quantidadeDeParcelas)

    fun calculaDiasDeVencimento(): Int {
        val hoje = LocalDate.now()
        if (hoje > dataDeVencimento) {
            return hoje.until(dataDeVencimento).days
        }
       return 0
    }
    fun validaDataVencimento(): Boolean {
        val hoje = LocalDate.now()
        if (hoje > dataDeVencimento) {
            return true
        }
        return false
    }
    fun calculaParcelaComJuros(valorDaParcela: Double): Double {
        val diasVencidos = calculaDiasDeVencimento()
        val jurosDias = valorDaParcela * 0.001
        val valorDaParcelaComJuros = jurosDias * diasVencidos + valorDaParcela
        return valorDaParcelaComJuros
    }

    fun calculaValorDaParcela(quantidadeDeParcelas: Int) : Double {
        val valorTotal = InfoEmplacamento().calculaValorTotal()
        if (quantidadeDeParcelas == 1) return valorTotal
        if (quantidadeDeParcelas == 2) return valorTotal / 2
        if (quantidadeDeParcelas == 3) return valorTotal / 3
        if (quantidadeDeParcelas == 4) return valorTotal / 4
        else return 0.0
    }
}