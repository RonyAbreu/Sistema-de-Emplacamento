import db.BancoDeDados;
import entity.Cliente;
import entity.RegistroClientes;
import gui.SistemaEmplacamentoTela;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RegistroClientes registroClientes;
        BancoDeDados bancoDeDados = new BancoDeDados();
        try {
            ArrayList<Cliente> clientes = bancoDeDados.retornarDados();
            registroClientes = new RegistroClientes(clientes);
            JOptionPane.showMessageDialog(null, "Seja Bem-Vindo!");
        } catch (IOException e) {
            registroClientes = new RegistroClientes(new ArrayList<>());
            JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!");
        }
        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela(registroClientes);
    }
}