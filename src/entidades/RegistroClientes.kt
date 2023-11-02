package entidades

class RegistroClientes ( private val clientes: MutableList<Cliente>) {

    fun cadastrarClientes(cliente: Cliente) : String {
        clientes.add(cliente)
        return "Cliente cadastrado" // Retirar após o teste.

    }

    fun pesquisarClientePeloNome(nome: String){

    }

    fun deletarClientePeloNome(nome: String){

    }

    fun retornarTodosOsClientes(clientes: MutableList<Cliente>){

    }


}