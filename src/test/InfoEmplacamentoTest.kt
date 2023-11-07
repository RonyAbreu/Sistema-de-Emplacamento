package test

import main.entity.InfoEmplacamento
import main.entity.Parcela
import main.exceptions.ValorDeEntradaInvalidoException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class InfoEmplacamentoTest {

    @Test
    fun retornaListaDeParcelasVencidas() {

        val infoEmplacamento = InfoEmplacamento("master", 300.0, 100.0, 2)
        val parcela = Parcela(LocalDate.of(2023, 11 , 6))
        infoEmplacamento.adicionaParcela(parcela)
        val retornaListaDeParcelasVencidas = infoEmplacamento.retornaListaDeParcelasVencidas().size

        Assertions.assertEquals(1, retornaListaDeParcelasVencidas)
    }
    @Test
    fun retornaListaDeParcelasValidas() {

        val infoEmplacamento = InfoEmplacamento("master", 300.0, 100.0, 2)
        val parcela = Parcela(LocalDate.now())
        infoEmplacamento.adicionaParcela(parcela)
        val retornaListaDeParcelasValidas = infoEmplacamento.retornaListaDeParcelasVencidas().isEmpty()

        Assertions.assertTrue(retornaListaDeParcelasValidas)
    }

    @Test
    fun calculaValorTotal() {

        val infoEmplacamento = InfoEmplacamento("master", 1000.0, 200.0, 3)
        val valorTotal = infoEmplacamento.calculaValorTotal()

        Assertions.assertEquals(834.4, valorTotal)
    }

    @Test
    fun calculaValorTotalSimulacao() {

        val infoEmplacamento = InfoEmplacamento("master", 1000.0, 200.0, 3)

        val valorDoEmplacamento= infoEmplacamento.valorDoEmplacamento
        val valorDeEntrada  = infoEmplacamento.valorDeEntrada
        val valorTotalSimulacao = infoEmplacamento.calculaValorTotalSimulacao(valorDoEmplacamento, valorDeEntrada)

        Assertions.assertEquals( 834.4 , valorTotalSimulacao)
    }

    @Test
    fun calculaValorTotalSimulacaoLancaThrow() {

        val infoEmplacamento = InfoEmplacamento("master", 300.0, 350.0, 3)
        val valorDoEmplacamento = infoEmplacamento.valorDoEmplacamento
        val valorDeEntrada = infoEmplacamento.valorDeEntrada

        assertThrows<ValorDeEntradaInvalidoException> {

            infoEmplacamento.calculaValorTotalSimulacao(valorDoEmplacamento, valorDeEntrada)
        }
    }

    @Test
    fun calculaValorDaParcela() {

        val infoEmplacamento = InfoEmplacamento("master", 400.0, 100.0, 3)
        val valorDoEmplacamento= infoEmplacamento.valorDoEmplacamento
        val valorDeEntrada  = infoEmplacamento.valorDeEntrada
        val quantidadeParcelas = infoEmplacamento.quantidadeDeParcelas
        val valorDaParcela = infoEmplacamento.calculaValorDaParcela(valorDoEmplacamento, quantidadeParcelas, valorDeEntrada)

        Assertions.assertEquals(104.3, valorDaParcela)
    }

}