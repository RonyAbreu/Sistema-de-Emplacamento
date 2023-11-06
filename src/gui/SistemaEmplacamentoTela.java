package gui;

import db.BancoDeDados;
import entity.*;
import exceptions.ValorDeEntradaInvalidoException;
import gui.table.ModeloDaTabela;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private JLabel textoDeAvisoCad;
    private JButton botaoDeFazerCadastro;
    private JButton botaoDeVoltarCad;
    private JButton botaoDeBuscar;
    private JTextField campoDeTextoBuscar;
    private JCheckBox caixaDeSelecaoPorNomeDoCliente;
    private JCheckBox caixaDeSelecaoPorNomeDaPlaca;
    private JCheckBox caixaDeSelecaoPorParcelasVencidas;
    private JTable tabelaDeClientes;
    private JLabel textoDeAvisoConsul;
    private RegistroClientes registroClientes;
    private BancoDeDados bancoDeDados = new BancoDeDados();

    public SistemaEmplacamentoTela(RegistroClientes registroClientes){
        this.registroClientes = registroClientes;
        configuraTela();
        eventoBotaoDeSimular();
        eventoBotaoDeCadastrar();
        eventoBotaoDeFazerCadastro();
        eventoDoBotaoDeVoltarDaTelaDeCadastro();
        avisoAoFecharJanela();
        retornaTodosOsClientesParaATabela();
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

    public void eventoDoBotaoDeBuscar(){
        botaoDeBuscar.addActionListener(e -> {
            if (todasAsCaixasDeSelecaoMarcadas() || caixaDeNomeClienteENomePlacaMarcadas()
                    || caixaDeNomeClienteEParcelasMarcadas() || caixaDeNomePlacaEParcelasMarcadas()){
                textoDeAvisoConsul.setText("Selecione apenas UM filtro de pesquisa!");
            }
            else if (campoDePesquisaEhVazio()) {
                textoDeAvisoConsul.setText("Insira o Nome do Cliente ou da Placa que deseja buscar");
            }
            else if(caixaDeSelecaoPorNomeDoCliente.isSelected()){

            }
            else if (caixaDeSelecaoPorNomeDaPlaca.isSelected()) {

            }
            else if(caixaDeSelecaoPorParcelasVencidas.isSelected()){

            }
        });
    }

    public boolean campoDePesquisaEhVazio(){
        if ((caixaDeSelecaoPorNomeDoCliente.isSelected() && campoDeTextoBuscar.getText().isBlank()) ||
                caixaDeSelecaoPorNomeDaPlaca.isSelected() && campoDeTextoBuscar.getText().isBlank()){
            return true;
        }
        return false;
    }

    public boolean todasAsCaixasDeSelecaoMarcadas(){
        return caixaDeSelecaoPorNomeDoCliente.isSelected()
                && caixaDeSelecaoPorNomeDaPlaca.isSelected()
                && caixaDeSelecaoPorParcelasVencidas.isSelected();
    }

    public boolean caixaDeNomeClienteENomePlacaMarcadas(){
        return caixaDeSelecaoPorNomeDoCliente.isSelected()
                && caixaDeSelecaoPorNomeDaPlaca.isSelected();
    }

    public boolean caixaDeNomeClienteEParcelasMarcadas(){
        return caixaDeSelecaoPorNomeDoCliente.isSelected()
                && caixaDeSelecaoPorParcelasVencidas.isSelected();
    }

    public boolean caixaDeNomePlacaEParcelasMarcadas(){
        return caixaDeSelecaoPorNomeDaPlaca.isSelected()
                && caixaDeSelecaoPorParcelasVencidas.isSelected();
    }

    public void retornaTodosOsClientesParaATabela(){
        ArrayList<Cliente> listaDeClientes = registroClientes.retornarTodosOsClientes();
        ModeloDaTabela modeloDaTabela = new ModeloDaTabela(listaDeClientes);
        tabelaDeClientes.setModel(modeloDaTabela);
        tabelaDeClientes.setAutoCreateRowSorter(true);
    }

    public void eventoDoBotaoDeVoltarDaTelaDeCadastro(){
        botaoDeVoltarCad.addActionListener(e -> {
            telaPrincipal.setSelectedIndex(0);
        });
    }
    public void eventoBotaoDeFazerCadastro(){
        botaoDeFazerCadastro.addActionListener(e -> {
            if (caixaDeTextoEhVaziaTelaDeSimulacao()){
                textoDeAviso.setText("Preencha todos os campos!");
            } else{
                telaPrincipal.setSelectedIndex(1);
                pegarDadosDaTelaDeSimulacao();
            }
        });
    }

    public void pegarDadosDaTelaDeSimulacao(){
        caixaDeTextoPlacaCad.setText(caixaDeTextoPlaca.getText());
        caixaDeTextoEmplacamentoCad.setText(caixaDeTextoValorEmplacamento.getText());
        caixaDeTextoValorEntradaCad.setText(caixaDeTextoValorEntrada.getText());
        caixaDeTextoValorTotalCad.setText(caixaDeTextoValorTotal.getText());
        caixaDeTextoValorParcelaCad.setText(caixaDeTextoValorParcela.getText());
        seletorParcelaCad.setSelectedIndex(seletorDeParcela.getSelectedIndex());
    }

    public void eventoBotaoDeSimular(){
        botaoDeSimular.addActionListener(e -> {
            if (caixaDeTextoEhVaziaTelaDeSimulacao()){
                textoDeAviso.setText("Preencha todos os campos!");
            } else {
                try{
                    double valorDoEmplacamento = Double.parseDouble(caixaDeTextoValorEmplacamento.getText().replace(",","."));
                    int quantidadeDeParcelas = seletorDeParcela.getSelectedIndex() + 1;
                    double valorDeEntrada = Double.parseDouble(caixaDeTextoValorEntrada.getText().replace(",","."));

                    InfoEmplacamento infoEmplacamento = new InfoEmplacamento();

                    Double valorTotal = infoEmplacamento.calculaValorTotalSimulacao(valorDoEmplacamento,valorDeEntrada);
                    Double valorDaParcela = infoEmplacamento.calculaValorDaParcela(valorDoEmplacamento,quantidadeDeParcelas,valorDeEntrada);

                    String valorTotalFormatado = formatadorDeNumeros(valorTotal);
                    String valorDaParcelaFormatado = formatadorDeNumeros(valorDaParcela);

                    caixaDeTextoValorTotal.setText(valorTotalFormatado);
                    caixaDeTextoValorParcela.setText(String.valueOf(valorDaParcelaFormatado));

                    textoDeAviso.setText("");
                } catch (ValorDeEntradaInvalidoException exception){
                    textoDeAviso.setText(exception.getMessage());
                } catch (NumberFormatException exception){
                    textoDeAviso.setText("Digite apenas Números nos Campos de Valor!");
                }
            }
        });
    }

    public void eventoBotaoDeCadastrar(){
        botaoCadastrar.addActionListener(e -> {
            if (caixaDeTextoEhVaziaTelaDeCadastro()){
                textoDeAvisoCad.setText("Preencha todos os campos!");
            } else {
                Cliente clienteParaCadastrar = criaObjetoCliente();
                registroClientes.cadastrarClientes(clienteParaCadastrar);

                salvarCliente();

                retornaTodosOsClientesParaATabela();
            }
        });
    }

    public void salvarCliente(){
        try {
            bancoDeDados = new BancoDeDados();
            bancoDeDados.persistirDados(registroClientes.retornarTodosOsClientes());

            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");

            textoDeAvisoCad.setText("");
            limparCamposDeTextoTelaDeCadastro();
            limparCamposDeTextoTelaDeSimulacao();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Não foi possível salvar o Cliente");
        }
    }

    public void limparCamposDeTextoTelaDeCadastro(){
        caixaDeTextoNomeCliente.setText("");
        caixaDeTextoTelefone.setText("");
        caixaDeTextoPlacaCad.setText("");
        caixaDeTextoEmplacamentoCad.setText("");
        caixaDeTextoValorEntradaCad.setText("");
        caixaDeTextoValorTotalCad.setText("");
        caixaDeTextoValorParcelaCad.setText("");
        seletorParcelaCad.setSelectedIndex(0);
        campoDeAnotacao.setText("");
    }

    public void limparCamposDeTextoTelaDeSimulacao(){
        caixaDeTextoPlaca.setText("");
        caixaDeTextoValorEmplacamento.setText("");
        caixaDeTextoValorEntrada.setText("");
        caixaDeTextoValorTotal.setText("");
        caixaDeTextoValorParcela.setText("");
        seletorDeParcela.setSelectedIndex(0);
    }

    public Cliente criaObjetoCliente(){
        String nome = caixaDeTextoNomeCliente.getText();
        System.out.println(nome);
        String telefone = caixaDeTextoTelefone.getText();
        System.out.println(telefone);
        String blocoDeAnotacao = campoDeAnotacao.getText();
        System.out.println(blocoDeAnotacao);

        InfoEmplacamento emplacamento = criaObjetoInfoEmplacamento();

        return new Cliente(nome,telefone,blocoDeAnotacao,emplacamento);
    }

    public InfoEmplacamento criaObjetoInfoEmplacamento(){
        String nomeDaPlaca = caixaDeTextoPlacaCad.getText();
        double valorDoEmplacamento = Double.parseDouble(caixaDeTextoEmplacamentoCad.getText());
        double valorDeEntrada = Double.parseDouble(caixaDeTextoValorEntradaCad.getText());
        int quantidadeDeParcelas = seletorParcelaCad.getSelectedIndex() + 1;

        InfoEmplacamento emplacamento = new InfoEmplacamento(nomeDaPlaca,valorDoEmplacamento,valorDeEntrada,quantidadeDeParcelas);

        double valorTotal = Double.parseDouble(formatadorDeNumeros(emplacamento.calculaValorTotal()));

        emplacamento.setValorTotal(valorTotal);

        Parcela parcela = new Parcela();
        parcela.setValorDaParcela(emplacamento.calculaValorDaParcela(valorDoEmplacamento,quantidadeDeParcelas,valorDeEntrada));

        ArrayList<Parcela> listaDeParcelas = retornaListaDeParcelas(quantidadeDeParcelas,parcela);

        emplacamento.setListaDeparcelas(listaDeParcelas);

        return emplacamento;
    }

    public ArrayList<Parcela> retornaListaDeParcelas(Integer quantidadeDeParcelas, Parcela parcela){
        ArrayList<Parcela> listaDeParcelas = new ArrayList<>();
        for (int i = 0; i < quantidadeDeParcelas; i++){
            if(i == 0){
                Parcela parcela1 = new Parcela();
                parcela1.setValorDaParcela(parcela.getValorDaParcela());
               listaDeParcelas.add(parcela1);
            }
            if (i == 1){
                Parcela parcela2 = new Parcela();
                parcela2.setValorDaParcela(parcela.getValorDaParcela());
                LocalDate dataDaSegundaParcela = parcela2.getDataDeVencimento().plusDays(30);
                parcela2.setDataDeVencimento(dataDaSegundaParcela);
                listaDeParcelas.add(parcela2);
            } else if (i == 2) {
                Parcela parcela3 = new Parcela();
                parcela3.setValorDaParcela(parcela.getValorDaParcela());
                LocalDate dataDaTerceiraParcela = parcela3.getDataDeVencimento().plusDays(60);
                parcela3.setDataDeVencimento(dataDaTerceiraParcela);
                listaDeParcelas.add(parcela3);
            } else if (i == 3) {
                Parcela parcela4 = new Parcela();
                parcela4.setValorDaParcela(parcela.getValorDaParcela());
                LocalDate dataDaQuartaParcela = parcela4.getDataDeVencimento().plusDays(90);
                parcela4.setDataDeVencimento(dataDaQuartaParcela);
                listaDeParcelas.add(parcela4);
            }
        }
        return listaDeParcelas;
    }

    public String formatadorDeNumeros(Double numero){
        return new DecimalFormat("##.##").format(numero).replace(",",".");
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
}
