package entity

import exceptions.ClienteNaoExisteException

data class RegistroClientes ( val listaDeClientes : ArrayList<Cliente>) {

    private fun clienteJaExiste(nome: String) : Boolean{
        for (cliente in listaDeClientes){
            if (cliente.nome == nome){
                return true
            }
        }
        return false
    }

    fun cadastrarClientes(cliente: Cliente){
        listaDeClientes.add(cliente)
    }


    fun pesquisarListaDeClientesPeloNome(nome: String) : ArrayList<Cliente> {
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
    fun pesquisarPelaPlaca(nomePlaca: String) : ArrayList<Cliente>{
        val listaDeClientesRetornados = ArrayList<Cliente>()
        for (cliente in listaDeClientes){
            if(cliente.emplacamento.nomeDaPlaca == nomePlaca ){
                listaDeClientesRetornados.add(cliente)
            }
        }

        if (listaDeClientesRetornados.isEmpty()){
            throw ClienteNaoExisteException("Não existe Clientes com essa Placa!")
        }
        return listaDeClientesRetornados

    }

    fun pesquisarClientesComPagamentoVencido() : ArrayList<Cliente>{
        val listaDeClientesComPagamentoAtrasado = ArrayList<Cliente>()
        for (cliente in listaDeClientes){
            if (cliente.emplacamento.retornaListaDeParcelasVencidas().isNotEmpty()){
                listaDeClientesComPagamentoAtrasado.add(cliente)
            }
        }
        if (listaDeClientesComPagamentoAtrasado.isEmpty()){
            throw ClienteNaoExisteException("Não existe Clientes com o Pagamento atrasado!")
        }
        return listaDeClientesComPagamentoAtrasado
    }

    fun deletarClientePeloNome(nome: String) {
        if(!clienteJaExiste(nome)){
            throw ClienteNaoExisteException("Não existe Cliente com esse Nome.")
        }
        for (cliente in listaDeClientes){
            if (cliente.nome == nome ){
                listaDeClientes.remove(cliente)
                break
            }
        }
    }

    fun retornarTodosOsClientes() : ArrayList<Cliente> {
        return listaDeClientes
    }

}