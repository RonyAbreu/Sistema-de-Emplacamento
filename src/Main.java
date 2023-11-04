import db.BancoDeDados;
import entity.Cliente;
import entity.InfoEmplacamento;
import entity.Parcela;
import entity.RegistroClientes;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
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

        Parcela parcela1 = new Parcela(LocalDate.parse("2023-12-01"));
        Parcela parcela2 = new Parcela(LocalDate.parse("2023-11-01"));

        InfoEmplacamento emplacamento1 = new InfoEmplacamento("nome",400,100,2);
        InfoEmplacamento emplacamento2 = new InfoEmplacamento("nome2",402,102,4);

        emplacamento1.getParcelas().add(parcela1);
        emplacamento2.getParcelas().add(parcela2);

        Cliente c1 = new Cliente("nome1","111", LocalDate.now(),"ok1", emplacamento1);
        Cliente c2 = new Cliente("nome2","222", LocalDate.now(),"ok2", emplacamento1);

        registroClientes.cadastrarClientes(c1);
        registroClientes.cadastrarClientes(c2);

        System.out.println(registroClientes.pesquisarClientesComPagamentoVencido());


//        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela(registroClientes);
    }
}