package db

import entity.Cliente
import java.io.*

class BancoDeDados(private val dados : String = "dados.dat") {
    @Throws(IOException::class)
    fun persistirDados(listaDeClientes: ArrayList<Cliente?>?) {
        try {
            ObjectOutputStream(FileOutputStream(dados)).use { objectOutputStream ->
                objectOutputStream.writeObject(listaDeClientes)
            }
        } catch (e: IOException) {
            throw IOException("Erro no Salvamento dos Dados");
        }
    }

    @Throws(IOException::class)
    fun retornarDados(): ArrayList<Cliente> {
        try {
            ObjectInputStream(FileInputStream(dados)).use {
                objectInputStream -> return objectInputStream.readObject() as ArrayList<Cliente>
            }
        } catch (e: IOException) {
            throw IOException("Erro no Salvamento dos Dados")
        } catch (e: ClassNotFoundException) {
            throw RuntimeException("Erro no Salvamento dos Clientes!")
        }
    }
}