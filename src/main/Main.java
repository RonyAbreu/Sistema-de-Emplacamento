package main;

import main.db.BancoDeDados;
import main.entity.Cliente;
import main.entity.InfoEmplacamento;
import main.entity.Parcela;
import main.entity.RegistroClientes;
import main.gui.SistemaEmplacamentoTela;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RegistroClientes registroClientes = new RegistroClientes(new ArrayList<>());
        Parcela parcelaAtrasada = new Parcela(LocalDate.now().minusDays(10));
        parcelaAtrasada.setValorDaParcela(47.12);
        InfoEmplacamento emplacamento = new InfoEmplacamento("placa",200,58,3);
        emplacamento.setValorTotal(141.37);
        emplacamento.getListaDeparcelas().add(parcelaAtrasada);
        Cliente cliente = new Cliente("rony","tel","anot",emplacamento);
        registroClientes.cadastrarClientes(cliente);

//        RegistroClientes registroClientes;
//        BancoDeDados bancoDeDados = new BancoDeDados();
//        try {
//            ArrayList<Cliente> clientes = bancoDeDados.retornarDados();
//            registroClientes = new RegistroClientes(clientes);
//        } catch (IOException e) {
//            registroClientes = new RegistroClientes(new ArrayList<>());
//            JOptionPane.showMessageDialog(null, "Sistema iniciado sem Dados!");
//        }

        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela(registroClientes);
    }
}