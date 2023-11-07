package main.gui;

import javax.swing.*;

public class TelaDeAnotacao extends JFrame {
    private JPanel painelPrincipal;
    private JTextPane campoDeAnotacoesDoCliente;
    private JTextField campoDeTextoNomeCliente;

    public TelaDeAnotacao(){
        configuraTela();
    }

    private void configuraTela(){
        setTitle("Anotações");
        setContentPane(painelPrincipal);
        setSize(600, 500);
        setLocation(650,200);
        setVisible(true);
        setResizable(true);
    }
}
