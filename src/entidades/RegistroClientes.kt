package entidades

import exceptions.ClienteJaExisteException
import exceptions.ClienteNaoExisteException

data class RegistroClientes ( val listaDeClientes : ArrayList<Cliente> = ArrayList()) {

    private fun clienteJaExiste(nome: String) : Boolean{
        for (cliente in listaDeClientes){
            if (cliente.nome == nome){
                return true
            }
        }
        return false
    }

    fun cadastrarClientes(cliente: Cliente){
        if (clienteJaExiste(cliente.nome)){
            throw ClienteJaExisteException("Cliente já foi cadastrado no Sistema, com o mesmo Emplacamento.");
        }
        listaDeClientes.add(cliente)
    }

    fun pesquisarClientePeloNome(nome: String) : Cliente {
        for (cliente in listaDeClientes){
            if(cliente.nome == nome){
                return cliente
            }
        }
        throw ClienteNaoExisteException("Cliente não foi encontrado no Sistema.");
    }

    fun pesquisarListaClientes(nome: String) : ArrayList<Cliente> {
        val listaDeClientesRetornados = ArrayList<Cliente>()
        for (cliente in listaDeClientes){
            if(cliente.nome.startsWith(nome)){
                listaDeClientesRetornados.add(cliente)
            }
        }
        if (listaDeClientesRetornados.isEmpty()){
            throw ClienteNaoExisteException("Não existe clientes com esse nome.")
        }

        return listaDeClientesRetornados
    }
    fun pesquisarPelaPlaca(nomePlaca: String): Cliente {
        for (cliente in listaDeClientes){
            if(cliente.emplacamento.nomeDaPlaca == nomePlaca ){
                return cliente
            }
        }
        throw ClienteNaoExisteException("Não existe cliente com essa placa.")
    }

    fun pesquisarClientesComPagamentoVencido() : ArrayList<Cliente>{
        val listaDeClientesComPagamentoAtrasado = ArrayList<Cliente>()
        for (cliente in listaDeClientes){
            if (cliente.emplacamento.parcelaVenceu){
                listaDeClientesComPagamentoAtrasado.add(cliente)
            }
        }

        if (listaDeClientesComPagamentoAtrasado.isEmpty()){
            throw ClienteNaoExisteException("Não existe clientes com o pagamento atrasado!")
        }

        return listaDeClientesComPagamentoAtrasado
    }

    fun deletarClientePeloNome(nome: String) {

        if(!clienteJaExiste(nome)){
            throw ClienteNaoExisteException("Não existe cliente com esse nome.")
        }
        for (cliente in listaDeClientes){
            if (cliente.nome == nome ){
                listaDeClientes.remove(cliente)
            }
        }
    }

    fun retornarTodosOsClientes() : ArrayList<Cliente> {
        return listaDeClientes
    }

}