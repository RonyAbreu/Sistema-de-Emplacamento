package tests

import entity.Cliente
import entity.InfoEmplacamento
import entity.Parcela
import entity.RegistroClientes
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
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

        val lista = ArrayList<Cliente>()
/*        lista.add(cliente1)
        lista.add(cliente2)*/

        val registroClientes = RegistroClientes(lista)

       // registroClientes.cadastrarClientes(cliente1)
        registroClientes.cadastrarClientes(cliente2)

    }

    @Test
    fun pesquisarListaClientes() {

        val cliente = Cliente("Joao", "8888", "",
            emplacamento = InfoEmplacamento("placa", 300.0,
                50.0,2)
        )

        val listaClientes = ArrayList<Cliente>()
        listaClientes.add(cliente)

        val registroClientes = RegistroClientes(listaClientes)

        Assertions.assertEquals( mutableListOf(cliente) , registroClientes.pesquisarListaClientes(cliente.nome).isNotEmpty() )

        // Certamente ele me retorna uma lista de clientes!

    }

    @Test
    fun pesquisarPelaPlaca() {

        val cliente = Cliente("Joao", "8888", "",
            emplacamento = InfoEmplacamento("placa", 300.0,
                50.0,2)
        )

        val listaClientes = ArrayList<Cliente>()
        listaClientes.add(cliente)

        val registroClientes = RegistroClientes(listaClientes)

        assertEquals( cliente , registroClientes.pesquisarPelaPlaca(cliente.emplacamento.nomeDaPlaca) )

    }

    @Test
    fun pesquisarClientesComPagamentoVencido() {

        val cliente = Cliente("Joao", "8888", "",
            emplacamento = InfoEmplacamento("placa", 300.0,
                50.0,2)
        )

        val listaClientes = ArrayList<Cliente>()
        listaClientes.add(cliente)


        val pagamento = Parcela(dataDeVencimento = LocalDate.of(2023,10,9))
        val registroClientes = RegistroClientes(listaClientes)


        assertEquals( cliente.emplacamento.retornaListaDeParcelasVencidas() , registroClientes.pesquisarClientesComPagamentoVencido())
       // assertEquals( pagamento.validaDataVencimento(), cliente.emplacamento.retornaListaDeParcelasVencidas().isEmpty())

    }

    @Test
    fun deletarClientePeloNome() {
    }

    @Test
    fun retornarTodosOsClientes() {
    }
}