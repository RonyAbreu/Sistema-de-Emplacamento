package gui;

import entidades.SimulaEmplacamento;

import javax.swing.*;

public class SistemaEmplacamentoTela extends JFrame {
    private JPanel painelPrincipal;
    private JTabbedPane telaPrincipal;
    private JPanel painelDeSimulacao;
    private JPanel painelDeCadastro;
    private JPanel painelDeConsulta;
    private JTextField caixaDeTextoPlaca;
    private JButton botaoDeSimular;
    private JTextField caixaDeTextoValorEmplacamento;
    private JTextField caixaDeTextoValorTotal;
    private JTextField caixaDeTextoValorParcela;
    private JComboBox seletorDeParcela;

    public SistemaEmplacamentoTela(){
        configuraTela();
        eventoBotaoDeSimular();
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

    public void eventoBotaoDeSimular(){
        botaoDeSimular.addActionListener(e -> {
            Double valorDoEmplacamento = Double.valueOf(caixaDeTextoValorEmplacamento.getText());
            Integer quantidadeDeParcelas = (Integer) seletorDeParcela.getItemAt(0);

            SimulaEmplacamento simulaEmplacamento = new SimulaEmplacamento();

            Double valorDaParcela = simulaEmplacamento.calculaValorDaParcela(valorDoEmplacamento,quantidadeDeParcelas);

            Double valorTotal = simulaEmplacamento.calculaValorTotal(valorDoEmplacamento,quantidadeDeParcelas);
        });
    }

    public static void main(String[] args) {
        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela();
    }
}
