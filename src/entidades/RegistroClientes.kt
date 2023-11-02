package entidades

import exceptions.ClienteJaExisteException
import exceptions.ClienteNaoExisteException

data class RegistroClientes ( val listaDeClientes: MutableList<Cliente>) {

    private fun clienteJaExiste(nome: String) : Boolean{
        for (cliente in listaDeClientes){
            if (cliente.nome == nome){
                return true
            }
        }
        return false
    }

    fun cadastrarClientes(cliente: Cliente) : String {
        if (clienteJaExiste(cliente.nome)){
            throw ClienteJaExisteException("Cliente já foi cadastrado no Sistema, com o mesmo Emplacamento!");
        }
        listaDeClientes.add(cliente)
        return "Cliente cadastrado" // Retirar após o teste.

    }

    fun pesquisarClientePeloNome(nome: String) : Cliente {
        for (cliente in listaDeClientes){
            if(cliente.nome == nome){
                return cliente
            }
        }
        throw ClienteNaoExisteException("Cliente não foi encontrado no Sistema!");
    }

    fun pesquisarListaClientes(nome: String) : MutableList<Cliente> {
        for (cliente in listaDeClientes){
            if(cliente.nome.startsWith(nome)){
                listaDeClienteEncontrados.add(cliente)
            }
        }
        return listaDeClienteEncontrados
    }
    fun pesquisarPelaPlaca(nomePlaca: String): Cliente?{
        for (cliente in listaDeClientes){
            if(cliente.emplacamento.nomeDaPlaca == nomePlaca ){
                return cliente
            }
        }
        return null
    }

    
    fun pesquisarPorPagamento(){
        // TODO: ("A implementar" ) 
    }

    fun deletarClientePeloNome(nome: String) : Unit {
        for (cliente in listaDeClientes){
            if (cliente.nome == nome ){
                listaDeClientes.remove(cliente)
            }
        }
    }

    fun retornarTodosOsClientes() : MutableList<Cliente> {
        return listaDeClientes
    }

}