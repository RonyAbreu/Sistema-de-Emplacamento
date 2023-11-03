package db;

import entity.Cliente;

import java.io.*;
import java.util.List;

public class BancoDeDados {
    private final String ARQUIVO_DE_DADOS = "dados.dat";

    public void persistirDados(List<Cliente> listaDeClientes) throws IOException{
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DE_DADOS))){
            objectOutputStream.writeObject(listaDeClientes);
        } catch (IOException e) {
            throw new IOException("Erro no Salvamento dos Dados");
        }
    }

    public List<Cliente> retornarDados() throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(ARQUIVO_DE_DADOS))){
            return (List<Cliente>) objectInputStream.readObject();
        } catch (IOException e) {
            throw new IOException("Erro no Salvamento dos Dados");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro no Salvamento dos Clientes!");
        }
    }
}
