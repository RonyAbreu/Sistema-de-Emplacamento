package entity

import java.io.Serializable
import java.time.LocalDate

data class InfoEmplacamento(
    val nomeDaPlaca: String = "",
    val valorDoEmplacamento: Double = 0.0,
    val valorDeEntrada: Double = 0.0,
    val quantidadeDeParcelas: Int = 0,
    ) : Serializable {

    var valorTotal: Double = calculaValorTotal()
    var parcelas = ArrayList<Parcela>()

    fun calculaValorTotal() : Double {
        var valorMenosAEntrada : Double = valorDoEmplacamento - valorDeEntrada
        return valorMenosAEntrada * SimulaEmplacamento.JUROS_DAS_PARCELAS + valorMenosAEntrada
    }


    override fun toString(): String {
        return "InfoEmplacamento(nomeDaPlaca='$nomeDaPlaca', valorDoEmplacamento=$valorDoEmplacamento, valorDeEntrada=$valorDeEntrada, quantidadeDeParcelas=$quantidadeDeParcelas, valorTotal=$valorTotal)"
    }
}