package entity

import exceptions.ValorDeEntradaInvalidoException
import java.io.Serializable

data class InfoEmplacamento(
    val nomeDaPlaca: String = "",
    val valorDoEmplacamento: Double = 0.0,
    val valorDeEntrada: Double = 0.0,
    val quantidadeDeParcelas: Int = 0,
    ) : Serializable {

    var valorTotal: Double = calculaValorTotal()
    var listaDeparcelas = ArrayList<Parcela>()
    private val jurosDasParcelas = 0.043

    fun retornaListaDeParcelasVencidas() : ArrayList<Parcela>{
        val listaDeParcelasVencidas = ArrayList<Parcela>()
        for (p in listaDeparcelas){
            if (p.validaDataVencimento()){
                listaDeParcelasVencidas.add(p)
            }
        }
        return listaDeParcelasVencidas
    }
    fun adicionaParcela(parcela : Parcela){
        listaDeparcelas.add(parcela)
    }
    fun parcelasEstaoQuitadas() : Boolean{
         var numeroDeParcelasPagas = 0
         for (parcela in listaDeparcelas){
             if (parcela.pagamentoAtrasado){
                 numeroDeParcelasPagas += 1
             }
         }
        return numeroDeParcelasPagas == listaDeparcelas.size
    }

    fun calculaValorTotal() : Double {
        val valorMenosAEntrada : Double = valorDoEmplacamento - valorDeEntrada
        return valorMenosAEntrada * jurosDasParcelas + valorMenosAEntrada
    }

    fun calculaValorTotalSimulacao(valorDoEmplacamento: Double, valorDeEntrada: Double): Double {
        if (valorDeEntrada > valorDoEmplacamento) {
            throw ValorDeEntradaInvalidoException("O Valor de Entrada não pode ser maior que o Valor do Emplacamento")
        }
        val valorMenosAEntrada = valorDoEmplacamento - valorDeEntrada
        return valorMenosAEntrada * jurosDasParcelas + valorMenosAEntrada
    }

    fun calculaValorDaParcela(valorDoEmplacamento: Double, quantidadeDeParcelas: Int, valorDeEntrada: Double): Double {
        val valorTotal = calculaValorTotalSimulacao(valorDoEmplacamento, valorDeEntrada)
        if (quantidadeDeParcelas == 1) return valorTotal
        if (quantidadeDeParcelas == 2) return valorTotal / 2
        if (quantidadeDeParcelas == 3) return valorTotal / 3
        return if (quantidadeDeParcelas == 4) valorTotal / 4 else 0.0
    }


    override fun toString(): String {
        return "InfoEmplacamento(nomeDaPlaca='$nomeDaPlaca', valorDoEmplacamento=$valorDoEmplacamento, valorDeEntrada=$valorDeEntrada, quantidadeDeParcelas=$quantidadeDeParcelas, valorTotal=$valorTotal)"
    }
}