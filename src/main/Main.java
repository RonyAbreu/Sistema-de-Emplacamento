package main;

import main.db.BancoDeDados;
import main.entity.Cliente;
import main.entity.RegistroClientes;
import main.gui.SistemaEmplacamentoTela;

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
        } catch (IOException e) {
            registroClientes = new RegistroClientes(new ArrayList<>());
            JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!");
        }
        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela(registroClientes);
    }
}