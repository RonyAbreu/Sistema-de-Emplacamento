package main.gui;

import main.db.BancoDeDados;
import main.entity.Parcela;
import main.entity.RegistroClientes;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class TelaDeParcelas extends JFrame{
    private JPanel painelPrincipal;
    private JTextField campoDeTextoNomeClientePar;
    private JTextField caixaDeTextoValorPar1;
    private JButton botaoDePagarPar1;
    private JButton botaoDeSalvar;
    private JTextField caixaDeTextoValorPar2;
    private JTextField caixaDeTextoValorPar3;
    private JTextField caixaDeTextoValorPar4;
    private JTextField caixaDeTextoDataPar1;
    private JTextField caixaDeTextoDataPar2;
    private JTextField caixaDeTextoDataPar3;
    private JTextField caixaDeTextoDataPar4;
    private JButton botaoDePagarPar2;
    private JButton botaoDePagarPar3;
    private JButton botaoDePagarPar4;
    private JLabel tituloPar1;
    private JLabel tituloPar2;
    private JLabel tituloPar3;
    private JLabel tituloPar4;
    private JLabel valorPar1;
    private JLabel valorPar2;
    private JLabel valorPar3;
    private JLabel valorPar4;
    private JLabel dataPar1;
    private JLabel dataPar3;
    private JLabel dataPar2;
    private JLabel dataPar4;
    private final Color VERDE = new Color(6,96,17);
    private RegistroClientes registroClientes;
    private BancoDeDados bancoDeDados = new BancoDeDados();

    public TelaDeParcelas(RegistroClientes registroClientes){
        this.registroClientes = registroClientes;
        configuraTela();
        eventoBotaoDePagarParcela1();
        eventoBotaoDePagarParcela2();
        eventoBotaoDePagarParcela3();
        eventoBotaoDePagarParcela4();
    }

    public void configuraTela(){
        setContentPane(painelPrincipal);
        setTitle("Parcelas");
        setSize(800,600);
        setResizable(false);
        setVisible(true);
        setLocation(525,200);
    }

    public void eventoBotaoDePagarParcela1(){
        botaoDePagarPar1.addActionListener(e -> {
            int opcao = JOptionPane.showConfirmDialog(this, "A Parcela passou da Data de Vencimento?","Informativo",JOptionPane.YES_NO_OPTION);

            String nomeCliente = campoDeTextoNomeClientePar.getText();
            ArrayList<Parcela> listaDeParcelas = registroClientes.retornarParcelasDoClientePeloNome(nomeCliente);

            if (opcao == JOptionPane.YES_OPTION){
                double valorDaParcelaAtual = Double.parseDouble(caixaDeTextoValorPar1.getText());
                double valorDaParcelaComJuros = listaDeParcelas.get(0).calculaParcelaComJuros(valorDaParcelaAtual);
                String valorDaParcelaComJurosFormatado = formatadorDeNumeros(valorDaParcelaComJuros);
                JOptionPane.showMessageDialog(this, "VALOR A SER PAGO: " + valorDaParcelaComJurosFormatado);

                Parcela parcela1 = listaDeParcelas.get(0);
                parcela1.setPagamentoAtrasado(false);

                salvarDados();

                tituloPar1.setForeground(VERDE);
                valorPar1.setForeground(VERDE);
                dataPar1.setForeground(VERDE);
                caixaDeTextoValorPar1.setBackground(VERDE);
                caixaDeTextoDataPar1.setBackground(VERDE);
            } else {
                Parcela parcela1 = listaDeParcelas.get(0);
                parcela1.setPagamentoAtrasado(false);

                salvarDados();

                tituloPar1.setForeground(VERDE);
                valorPar1.setForeground(VERDE);
                dataPar1.setForeground(VERDE);
                caixaDeTextoValorPar1.setBackground(VERDE);
                caixaDeTextoDataPar1.setBackground(VERDE);
            }
        });
    }

    public void eventoBotaoDePagarParcela2(){
        botaoDePagarPar2.addActionListener(e -> {
            int opcao = JOptionPane.showConfirmDialog(this, "A Parcela passou da Data de Vencimento?","Informativo",JOptionPane.YES_NO_OPTION);

            String nomeCliente = campoDeTextoNomeClientePar.getText();
            ArrayList<Parcela> listaDeParcelas = registroClientes.retornarParcelasDoClientePeloNome(nomeCliente);

            if (opcao == JOptionPane.YES_OPTION){
                double valorDaParcelaAtual = Double.parseDouble(caixaDeTextoValorPar1.getText());
                double valorDaParcelaComJuros = listaDeParcelas.get(1).calculaParcelaComJuros(valorDaParcelaAtual);
                String valorDaParcelaComJurosFormatado = formatadorDeNumeros(valorDaParcelaComJuros);
                JOptionPane.showMessageDialog(this, "VALOR A SER PAGO: " + valorDaParcelaComJurosFormatado);

                Parcela parcela2 = listaDeParcelas.get(1);
                parcela2.setPagamentoAtrasado(false);

                salvarDados();

                tituloPar2.setForeground(VERDE);
                valorPar2.setForeground(VERDE);
                dataPar2.setForeground(VERDE);
                caixaDeTextoValorPar2.setBackground(VERDE);
                caixaDeTextoDataPar2.setBackground(VERDE);
            } else {
                Parcela parcela2 = listaDeParcelas.get(1);
                parcela2.setPagamentoAtrasado(false);

                salvarDados();

                tituloPar2.setForeground(VERDE);
                valorPar2.setForeground(VERDE);
                dataPar2.setForeground(VERDE);
                caixaDeTextoValorPar2.setBackground(VERDE);
                caixaDeTextoDataPar2.setBackground(VERDE);
            }
        });
    }

    public void eventoBotaoDePagarParcela3(){
        botaoDePagarPar3.addActionListener(e -> {
            int opcao = JOptionPane.showConfirmDialog(this, "A Parcela passou da Data de Vencimento?","Informativo",JOptionPane.YES_NO_OPTION);

            String nomeCliente = campoDeTextoNomeClientePar.getText();
            ArrayList<Parcela> listaDeParcelas = registroClientes.retornarParcelasDoClientePeloNome(nomeCliente);

            if (opcao == JOptionPane.YES_OPTION){
                double valorDaParcelaAtual = Double.parseDouble(caixaDeTextoValorPar1.getText());
                double valorDaParcelaComJuros = listaDeParcelas.get(2).calculaParcelaComJuros(valorDaParcelaAtual);
                String valorDaParcelaComJurosFormatado = formatadorDeNumeros(valorDaParcelaComJuros);
                JOptionPane.showMessageDialog(this, "VALOR A SER PAGO: " + valorDaParcelaComJurosFormatado);

                Parcela parcela3 = listaDeParcelas.get(2);
                parcela3.setPagamentoAtrasado(false);

                salvarDados();

                tituloPar3.setForeground(VERDE);
                valorPar3.setForeground(VERDE);
                dataPar3.setForeground(VERDE);
                caixaDeTextoValorPar3.setBackground(VERDE);
                caixaDeTextoDataPar3.setBackground(VERDE);
            } else {
                Parcela parcela3 = listaDeParcelas.get(2);
                parcela3.setPagamentoAtrasado(false);

                salvarDados();

                tituloPar3.setForeground(VERDE);
                valorPar3.setForeground(VERDE);
                dataPar3.setForeground(VERDE);
                caixaDeTextoValorPar3.setBackground(VERDE);
                caixaDeTextoDataPar3.setBackground(VERDE);
            }
        });
    }

    public void eventoBotaoDePagarParcela4(){
        botaoDePagarPar4.addActionListener(e -> {
            int opcao = JOptionPane.showConfirmDialog(this, "A Parcela passou da Data de Vencimento?","Informativo",JOptionPane.YES_NO_OPTION);

            String nomeCliente = campoDeTextoNomeClientePar.getText();
            ArrayList<Parcela> listaDeParcelas = registroClientes.retornarParcelasDoClientePeloNome(nomeCliente);

            if (opcao == JOptionPane.YES_OPTION){
                double valorDaParcelaAtual = Double.parseDouble(caixaDeTextoValorPar1.getText());
                double valorDaParcelaComJuros = listaDeParcelas.get(3).calculaParcelaComJuros(valorDaParcelaAtual);
                String valorDaParcelaComJurosFormatado = formatadorDeNumeros(valorDaParcelaComJuros);
                JOptionPane.showMessageDialog(this, "VALOR A SER PAGO: " + valorDaParcelaComJurosFormatado);

                Parcela parcela4 = listaDeParcelas.get(3);
                parcela4.setPagamentoAtrasado(false);

                salvarDados();

                tituloPar4.setForeground(VERDE);
                valorPar4.setForeground(VERDE);
                dataPar4.setForeground(VERDE);
                caixaDeTextoValorPar4.setBackground(VERDE);
                caixaDeTextoDataPar4.setBackground(VERDE);
            } else {
                Parcela parcela4 = listaDeParcelas.get(3);
                parcela4.setPagamentoAtrasado(false);

                salvarDados();

                tituloPar4.setForeground(VERDE);
                valorPar4.setForeground(VERDE);
                dataPar4.setForeground(VERDE);
                caixaDeTextoValorPar4.setBackground(VERDE);
                caixaDeTextoDataPar4.setBackground(VERDE);
            }
        });
    }

    private void salvarDados(){
        try {
            bancoDeDados.persistirDados(registroClientes.retornarTodosOsClientes());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar os dados das Parcelas!");
        }
    }

    public void verificaSeExisteParcela(){
        if (caixaDeTextoValorPar1.getText().isEmpty() && caixaDeTextoDataPar1.getText().isEmpty()){
            botaoDePagarPar1.setEnabled(false);
        }
        if (caixaDeTextoValorPar2.getText().isEmpty() && caixaDeTextoDataPar2.getText().isEmpty()){
            botaoDePagarPar2.setEnabled(false);
        }
        if (caixaDeTextoValorPar3.getText().isEmpty() && caixaDeTextoDataPar3.getText().isEmpty()){
            botaoDePagarPar3.setEnabled(false);
        }
        if (caixaDeTextoValorPar4.getText().isEmpty() && caixaDeTextoDataPar4.getText().isEmpty()){
            botaoDePagarPar4.setEnabled(false);
        }
    }

    public void alteraCorDaPrimeiraParcelaParaVerde(){
        tituloPar1.setForeground(VERDE);
        valorPar1.setForeground(VERDE);
        dataPar1.setForeground(VERDE);
        caixaDeTextoValorPar1.setBackground(VERDE);
        caixaDeTextoDataPar1.setBackground(VERDE);
    }

    public void alteraCorDaSegundaParcelaParaVerde(){
        tituloPar2.setForeground(VERDE);
        valorPar2.setForeground(VERDE);
        dataPar2.setForeground(VERDE);
        caixaDeTextoValorPar2.setBackground(VERDE);
        caixaDeTextoDataPar2.setBackground(VERDE);
    }

    public void alteraCorDaTerceiraParcelaParaVerde(){
        tituloPar3.setForeground(VERDE);
        valorPar3.setForeground(VERDE);
        dataPar3.setForeground(VERDE);
        caixaDeTextoValorPar3.setBackground(VERDE);
        caixaDeTextoDataPar3.setBackground(VERDE);
    }

    public void alteraCorDaQuartaParcelaParaVerde(){
        tituloPar4.setForeground(VERDE);
        valorPar4.setForeground(VERDE);
        dataPar4.setForeground(VERDE);
        caixaDeTextoValorPar4.setBackground(VERDE);
        caixaDeTextoDataPar4.setBackground(VERDE);
    }

    private String formatadorDeNumeros(Double numero){
        return new DecimalFormat("##.##").format(numero).replace(",",".");
    }

    public JTextField getCampoDeTextoNomeClientePar() {
        return campoDeTextoNomeClientePar;
    }

    public JTextField getCaixaDeTextoValorPar1() {
        return caixaDeTextoValorPar1;
    }

    public JTextField getCaixaDeTextoValorPar2() {
        return caixaDeTextoValorPar2;
    }

    public JTextField getCaixaDeTextoValorPar3() {
        return caixaDeTextoValorPar3;
    }

    public JTextField getCaixaDeTextoValorPar4() {
        return caixaDeTextoValorPar4;
    }

    public JTextField getCaixaDeTextoDataPar1() {
        return caixaDeTextoDataPar1;
    }

    public JTextField getCaixaDeTextoDataPar2() {
        return caixaDeTextoDataPar2;
    }

    public JTextField getCaixaDeTextoDataPar3() {
        return caixaDeTextoDataPar3;
    }

    public JTextField getCaixaDeTextoDataPar4() {
        return caixaDeTextoDataPar4;
    }
}
