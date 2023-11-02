package entidades

data class RegistroClientes ( val clientes: MutableList<Cliente>) {

    fun cadastrarClientes(cliente: Cliente) : String {
        clientes.add(cliente)
        return "Cliente cadastrado" // Retirar após o teste.

    }

    fun pesquisarClientePeloNome(nome: String) : Cliente? {
        for (c in clientes){
            if(c.nome == nome ){
                return c
            }
        }
        return null
    }

    fun pesquisarListaClientes(nome: String) : Cliente? {
        for (c in clientes){
            if(c.nome.startsWith(nome)){
                return c
            }
        }
        return null
    }
    fun pesquisarPelaPlaca(nomePlaca: String): Cliente?{
        for (c in clientes){
            if(c.emplacamento.nomeDaPlaca == nomePlaca ){
                return c
            }
        }
        return null
    }

    
    fun pesquisarPorPagamento(){
        // TODO: ("A implementar" ) 
    }

    fun deletarClientePeloNome(nome: String) : Unit {
        for (c in clientes){
            if (c.nome == nome ){
                clientes.remove(c)
            }
        }
    }

    fun retornarTodosOsClientes() : MutableList<Cliente> {
        return clientes
    }

}