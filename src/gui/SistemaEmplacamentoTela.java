package gui;

import javax.swing.*;

public class SistemaEmplacamentoTela extends JFrame {
    private JPanel painelPrincipal;
    private JTabbedPane telaPrincipal;
    private JPanel painelDeSimulacao;
    private JPanel painelDeCadastro;
    private JPanel painelDeConsulta;
    private JTextField caixaDeTextoDaPlaca;
    private JComboBox seletorDeParcelas;
    private JTextField caixaDeTextoDoValorDoEmplacamento;
    private JButton simularButton;

    public SistemaEmplacamentoTela(){
        configuraTela();
    }

    public void configuraTela(){
        setTitle("Emplacamentos do John");
        setContentPane(painelPrincipal);
        setSize(1024, 768);
        setLocation(450,100);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela();
    }
}
