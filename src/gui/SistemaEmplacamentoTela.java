package gui;

import entidades.SimulaEmplacamento;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

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
    private JLabel textoDeAviso;
    private JTextPane campoDeAnotacao;
    private JTextField caixaDeTextoNomeCliente;
    private JTextField caixaDeTextoTelefone;
    private JTextField caixaDeTextoPlacaCad;
    private JTextField caixaDeTextoEmplacamentoCad;
    private JComboBox seletorParcelaCad;
    private JTextField caixaDeTextoValorTotalCad;
    private JTextField caixaDeTextoValorParcelaCad;
    private JButton botaoCadastrar;

    public SistemaEmplacamentoTela(){
        configuraTela();
        eventoBotaoDeSimular();
        avisoAoFecharJanela();
    }

    public void configuraTela(){
        setTitle("Emplacamentos do John");
        setContentPane(painelPrincipal);
        setSize(1024, 768);
        setLocation(450,100);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public void eventoBotaoDeSimular(){
        botaoDeSimular.addActionListener(e -> {
            if (caixaDeTextoEhVazia()){
                textoDeAviso.setText("Preencha todos os campos!");
            } else {
                Double valorDoEmplacamento = Double.parseDouble(caixaDeTextoValorEmplacamento.getText());
                Integer quantidadeDeParcelas = seletorDeParcela.getSelectedIndex() + 1;

                Double valorTotal = SimulaEmplacamento.calculaValorTotal(valorDoEmplacamento);
                Double valorDaParcela = SimulaEmplacamento.calculaValorDaParcela(valorDoEmplacamento,quantidadeDeParcelas);

                String valorTotalFormatado = formatadorDeNumeros(valorTotal);
                String valorDaParcelaFormatado = formatadorDeNumeros(valorDaParcela);

                caixaDeTextoValorTotal.setText(valorTotalFormatado);
                caixaDeTextoValorParcela.setText(String.valueOf(valorDaParcelaFormatado));

                textoDeAviso.setText("");
            }
        });
    }

    public String formatadorDeNumeros(Double numero){
        return new DecimalFormat("##.##").format(numero);
    }

    public boolean caixaDeTextoEhVazia(){
        return caixaDeTextoPlaca.getText().isBlank() || caixaDeTextoValorEmplacamento.getText().isBlank();
    }

    public void avisoAoFecharJanela(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(null,"Deseja Fechar a Janela?","Sair",JOptionPane.YES_NO_OPTION);
                if(fechar == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }
    public static void main(String[] args) {
        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela();

    }
}
