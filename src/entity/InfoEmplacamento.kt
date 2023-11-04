package entity

import java.io.Serializable

data class InfoEmplacamento(
    val nomeDaPlaca: String = "",
    val valorDoEmplacamento: Double = 0.0,
    val valorDeEntrada: Double = 0.0,
    val quantidadeDeParcelas: Int = 0,
    ) : Serializable {

    var valorTotal: Double = calculaValorTotal()
    var parcelas = ArrayList<Parcela>()

    fun retornaListaDeParcelasVencidas() : ArrayList<Parcela>{
        val listaDeParcelasVencidas = ArrayList<Parcela>()
        for (p in parcelas){
            if (p.validaDataVencimento()){
                listaDeParcelasVencidas.add(p)
            }
        }
        return listaDeParcelasVencidas
    }

    fun calculaValorTotal() : Double {
        val valorMenosAEntrada : Double = valorDoEmplacamento - valorDeEntrada
        return valorMenosAEntrada * SimulaEmplacamento.JUROS_DAS_PARCELAS + valorMenosAEntrada
    }


    override fun toString(): String {
        return "InfoEmplacamento(nomeDaPlaca='$nomeDaPlaca', valorDoEmplacamento=$valorDoEmplacamento, valorDeEntrada=$valorDeEntrada, quantidadeDeParcelas=$quantidadeDeParcelas, valorTotal=$valorTotal)"
    }
}