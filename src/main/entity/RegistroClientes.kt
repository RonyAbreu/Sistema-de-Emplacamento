package main.entity

import main.exceptions.ClienteNaoExisteException

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
            if(cliente.nome.startsWith(nome,true)){
                listaDeClientesRetornados.add(cliente)
            }
        }
        if (listaDeClientesRetornados.isEmpty()){
            throw ClienteNaoExisteException("Não existem Clientes com esse nome.")
        }

        return listaDeClientesRetornados
    }
    fun pesquisarPelaPlaca(nomePlaca: String) : ArrayList<Cliente>{
        val listaDeClientesRetornados = ArrayList<Cliente>()
        for (cliente in listaDeClientes){
            if(cliente.emplacamento.nomeDaPlaca.equals(nomePlaca, true) ){
                listaDeClientesRetornados.add(cliente)
            }
        }

        if (listaDeClientesRetornados.isEmpty()){
            throw ClienteNaoExisteException("Não existem Clientes com essa Placa!")
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
            throw ClienteNaoExisteException("Não existem Cliente com esse Nome.")
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

    fun pegaAnotacaoDoClientePeloNome(nome : String) :String{
        var anotacoes = ""
        for (cliente in listaDeClientes){
            if (cliente.nome == nome ){
                anotacoes = cliente.blocoDeAnotacao
            }
        }
        return anotacoes
    }

    fun retornaClientePeloNome(nome: String) : Cliente{
        for (cliente in listaDeClientes){
            if (cliente.nome.equals(nome,true)){
                return cliente;
            }
        }
        throw ClienteNaoExisteException("Não existem Cliente com esse Nome.")
    }

    fun retornarParcelasDoClientePeloNome(nome : String) : ArrayList<Parcela>{
        val listaDeParcelas = ArrayList<Parcela>()

        val cliente = retornaClientePeloNome(nome);

        listaDeParcelas.addAll(cliente.emplacamento.listaDeparcelas)

        return listaDeParcelas;
    }
}