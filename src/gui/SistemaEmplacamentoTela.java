package gui;

import entidades.Cliente;
import entidades.InfoEmplacamento;
import entidades.RegistroClientes;
import entidades.SimulaEmplacamento;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;

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
    private JTextField caixaDeTextoValorEntrada;
    private JTextField caixaDeTextoValorEntradaCad;
    private RegistroClientes registroClientes;

    public SistemaEmplacamentoTela(RegistroClientes registroClientes){
        this.registroClientes = registroClientes;
        configuraTela();
        eventoBotaoDeSimular();
        eventoBotaoDeCadastrar();
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
            if (caixaDeTextoEhVaziaTelaDeSimulacao()){
                textoDeAviso.setText("Preencha todos os campos!");
            } else {
                Double valorDoEmplacamento = Double.parseDouble(caixaDeTextoValorEmplacamento.getText());
                Integer quantidadeDeParcelas = seletorDeParcela.getSelectedIndex() + 1;
                Double valorDeEntrada = Double.parseDouble(caixaDeTextoValorEntrada.getText());

                Double valorTotal = SimulaEmplacamento.calculaValorTotal(valorDoEmplacamento,valorDeEntrada);
                Double valorDaParcela = SimulaEmplacamento.calculaValorDaParcela(valorDoEmplacamento,quantidadeDeParcelas,valorDeEntrada);

                String valorTotalFormatado = formatadorDeNumeros(valorTotal);
                String valorDaParcelaFormatado = formatadorDeNumeros(valorDaParcela);

                caixaDeTextoValorTotal.setText(valorTotalFormatado);
                caixaDeTextoValorParcela.setText(String.valueOf(valorDaParcelaFormatado));

                textoDeAviso.setText("");
            }
        });
    }

    public void eventoBotaoDeCadastrar(){
        botaoCadastrar.addActionListener(e -> {
            String nome = caixaDeTextoNomeCliente.getText();
            String telefone = caixaDeTextoTelefone.getText();
            LocalDate dataDeCadastro = LocalDate.now();
            String blocoDeAnotacao = campoDeAnotacao.getText();

            String nomeDaPlaca = caixaDeTextoPlacaCad.getText();
            String valorDoEmplacamento = caixaDeTextoEmplacamentoCad.getText();
            String valorDeEntrada = caixaDeTextoValorEntradaCad.getText();
            int quantidadeDeParcelas = seletorParcelaCad.getSelectedIndex() + 1;
            LocalDate dataDeVencimento = LocalDate.now().plusDays(30);
            boolean parcelaVenceu = false;

            InfoEmplacamento emplacamento = new InfoEmplacamento(nomeDaPlaca,Double.parseDouble(valorDoEmplacamento),Double.parseDouble(valorDeEntrada),quantidadeDeParcelas,dataDeVencimento,parcelaVenceu);
            emplacamento.setValorTotal(emplacamento.calculaValorTotal());
            emplacamento.setValorDaParcela(emplacamento.calculaValorDaParcela());

            Cliente clienteParaCadastrar = new Cliente(nome,telefone,dataDeCadastro,blocoDeAnotacao,emplacamento);
            JOptionPane.showMessageDialog(null, clienteParaCadastrar);

            registroClientes.cadastrarClientes(clienteParaCadastrar);
        });
    }

    public String formatadorDeNumeros(Double numero){
        return new DecimalFormat("##.##").format(numero);
    }

    public boolean caixaDeTextoEhVaziaTelaDeSimulacao(){
        return caixaDeTextoPlaca.getText().isBlank() || caixaDeTextoValorEmplacamento.getText().isBlank() || caixaDeTextoValorEntrada.getText().isBlank();
    }

    public boolean caixaDeTextoEhVaziaTelaDeCadastro(){
        return caixaDeTextoNomeCliente.getText().isBlank() || caixaDeTextoTelefone.getText().isBlank() ||
                caixaDeTextoPlacaCad.getText().isBlank() || caixaDeTextoEmplacamentoCad.getText().isBlank() ||
                caixaDeTextoValorEntradaCad.getText().isBlank() || caixaDeTextoValorTotalCad.getText().isBlank() ||
                caixaDeTextoValorParcelaCad.getText().isBlank();
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
        RegistroClientes registroClientes1 = new RegistroClientes();
        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela(registroClientes1);

    }
}
