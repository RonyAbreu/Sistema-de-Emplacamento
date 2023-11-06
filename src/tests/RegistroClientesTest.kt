package tests

import entity.Cliente
import entity.InfoEmplacamento
import entity.Parcela
import entity.RegistroClientes
import exceptions.ClienteNaoExisteException
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class RegistroClientesTest {


    @Test
    fun cadastrarClientes() {
        val cliente1 = Cliente("Joao", "8888", "",
            emplacamento = InfoEmplacamento("placa", 300.0,
                50.0,2)
        )

        val cliente2 = Cliente("Rony", "3333", "",
            emplacamento = InfoEmplacamento("ronyboy", 500.0,
                100.0,2)
        )

        val registroClientes = RegistroClientes(ArrayList())

        registroClientes.cadastrarClientes(cliente1)
        registroClientes.cadastrarClientes(cliente2)

        var primeiroClienteDaLista = registroClientes.retornarTodosOsClientes().get(0)

        assertEquals("Joao",primeiroClienteDaLista.nome)
        assertEquals("8888",primeiroClienteDaLista.telefone)
        assertEquals("",primeiroClienteDaLista.blocoDeAnotacao)

        assertEquals(2, registroClientes.retornarTodosOsClientes().size)
    }

    @Test
    fun pesquisarListaDeClientesPeloNome() {
        val cliente = Cliente(
            "Joao", "8888", "",
            emplacamento = InfoEmplacamento(
                "placa", 300.0,
                50.0, 2
            )
        )

        val registroClientes = RegistroClientes(ArrayList())

        registroClientes.cadastrarClientes(cliente)

        assertTrue(registroClientes.pesquisarListaDeClientesPeloNome(cliente.nome).isNotEmpty())
    }

    @Test
    fun pesquisarPelaPlaca() {
        val cliente = Cliente("Joao", "8888", "",
            emplacamento = InfoEmplacamento("placa", 300.0,
                50.0,2)
        )
        val registroClientes = RegistroClientes(ArrayList())

        registroClientes.cadastrarClientes(cliente)

        assertEquals( "placa", registroClientes.pesquisarPelaPlaca(cliente.emplacamento.nomeDaPlaca).emplacamento.nomeDaPlaca )
    }

    @Test
    fun testaClientesComPagamentoVencido() {
        val emplacamento = InfoEmplacamento()

        val cliente = Cliente("Joao", "8888", "", emplacamento)

        val parcela = Parcela(dataDeVencimento = LocalDate.of(2023,10,9))

        emplacamento.adicionaParcela(parcela)

        val registroClientes = RegistroClientes(ArrayList())
        registroClientes.cadastrarClientes(cliente)

        assertEquals(1,registroClientes.pesquisarClientesComPagamentoVencido().size)
    }

    @Test
    fun testaClientesComPagamentoValido() {
        val emplacamento = InfoEmplacamento()

        val cliente = Cliente("Joao", "8888", "", emplacamento)

        val parcela = Parcela()

        emplacamento.adicionaParcela(parcela)

        val registroClientes = RegistroClientes(ArrayList())
        registroClientes.cadastrarClientes(cliente)

        assertThrows<ClienteNaoExisteException>{
            registroClientes.pesquisarClientesComPagamentoVencido()
        }
    }

    @Test
    fun deletarClientePeloNome() {
        val emplacamento = InfoEmplacamento()

        val cliente = Cliente("Joao", "8888", "", emplacamento)

        val registroClientes = RegistroClientes(ArrayList())

        registroClientes.cadastrarClientes(cliente)

        registroClientes.deletarClientePeloNome(cliente.nome)

        assertTrue(registroClientes.retornarTodosOsClientes().isEmpty())
    }
    @Test
    fun deletarClientePeloNomeLancaThrow() {
        val emplacamento = InfoEmplacamento()

        val cliente = Cliente("Joao", "8888", "", emplacamento)

        val registroClientes = RegistroClientes(ArrayList())

        registroClientes.cadastrarClientes(cliente)

        registroClientes.deletarClientePeloNome(cliente.nome)

        assertThrows<ClienteNaoExisteException>{
            registroClientes.deletarClientePeloNome(cliente.nome)
        }
    }

    @Test
    fun retornarTodosOsClientes() {
        val emplacamento = InfoEmplacamento()

        val cliente = Cliente("Joao", "8888", "", emplacamento)

        val registroClientes = RegistroClientes(ArrayList())

        registroClientes.cadastrarClientes(cliente)

        registroClientes.deletarClientePeloNome(cliente.nome)

        assertTrue(registroClientes.retornarTodosOsClientes().isEmpty())

    }
}