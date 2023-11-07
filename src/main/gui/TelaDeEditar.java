package main.gui;

import javax.swing.*;

public class TelaDeEditar extends JFrame{
    private JPanel painelDeCadastro;
    private JTextField caixaDeTextoNomeClienteEd;
    private JTextField caixaDeTextoTelefoneEd;
    private JTextField caixaDeTextoPlacaEd;
    private JTextPane campoDeAnotacaoEd;
    private JLabel textoDeAvisoEd;
    private JPanel painelPrincipal;
    private JButton botaoDeSalvar;

    public TelaDeEditar(){
        configuraTela();
    }

    private void configuraTela(){
        setTitle("Editar");
        setContentPane(painelPrincipal);
        setSize(900, 600);
        setLocation(525,200);
        setVisible(true);
        setResizable(true);
    }
}
