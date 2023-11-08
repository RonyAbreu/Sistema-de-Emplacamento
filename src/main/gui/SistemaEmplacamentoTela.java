package main.gui;

import main.db.BancoDeDados;
import main.entity.*;
import main.exceptions.ClienteNaoExisteException;
import main.exceptions.ValorDeEntradaInvalidoException;
import main.gui.table.ModeloDaTabela;

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
    private JButton botaoDeParcelas;
    private JButton botaoDeEditar;
    private JButton botaoDeAnotacoes;
    private JButton botaoDeRemover;
    private JTextField campoDeVizualizarNome;
    private JButton atualizarButton;
    private RegistroClientes registroClientes;
    private BancoDeDados bancoDeDados = new BancoDeDados();

    public SistemaEmplacamentoTela(RegistroClientes registroClientes){
        this.registroClientes = registroClientes;
        configuraTela();
        eventoBotaoDeSimular();
        eventoBotaoDeCadastrar();
        eventoBotaoDeFazerCadastro();
        eventoDoBotaoDeVoltarDaTelaDeCadastro();
        eventoDoBotaoDeBuscar();
        avisoAoFecharJanela();
        retornaTodosOsClientesParaATabela();
        eventoDoBotaoDeRemover();
        eventoDoBotaoDeParcelas();
        eventoDoBotaoDeAnotacoes();
        eventoDoBotaoDeEditar();
        eventoDoMouseAoClicar();
        eventoDoBotaoDeAtualizar();
    }

    private void configuraTela(){
        setTitle("Emplacamentos");
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
                    caixaDeTextoValorParcela.setText(valorDaParcelaFormatado);

                    textoDeAviso.setText("");
                } catch (ValorDeEntradaInvalidoException exception){
                    textoDeAviso.setText(exception.getMessage());
                } catch (NumberFormatException exception){
                    textoDeAviso.setText("Digite apenas Números nos Campos de Valor!");
                }
            }
        });
    }

    private boolean caixaDeTextoEhVaziaTelaDeSimulacao(){
        return caixaDeTextoPlaca.getText().isBlank() || caixaDeTextoValorEmplacamento.getText().isBlank() || caixaDeTextoValorEntrada.getText().isBlank();
    }

    private String formatadorDeNumeros(Double numero){
        return new DecimalFormat("##.##").format(numero).replace(",",".");
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

    private Cliente criaObjetoCliente(){
        String nome = caixaDeTextoNomeCliente.getText();
        String telefone = caixaDeTextoTelefone.getText();
        String blocoDeAnotacao = campoDeAnotacao.getText();

        InfoEmplacamento emplacamento = criaObjetoInfoEmplacamento();

        return new Cliente(nome,telefone,blocoDeAnotacao,emplacamento);
    }

    private InfoEmplacamento criaObjetoInfoEmplacamento(){
        String nomeDaPlaca = caixaDeTextoPlacaCad.getText();
        double valorDoEmplacamento = Double.parseDouble(caixaDeTextoEmplacamentoCad.getText());
        double valorDeEntrada = Double.parseDouble(caixaDeTextoValorEntradaCad.getText());
        int quantidadeDeParcelas = seletorParcelaCad.getSelectedIndex() + 1;

        InfoEmplacamento emplacamento = new InfoEmplacamento(nomeDaPlaca,valorDoEmplacamento,valorDeEntrada,quantidadeDeParcelas);
        double valorTotal = emplacamento.calculaValorTotal();
        String valorTotalFormatado = formatadorDeNumeros(valorTotal);
        emplacamento.setValorTotal(Double.parseDouble(valorTotalFormatado));

        Parcela parcela = new Parcela();
        double valorDaParcela = emplacamento.calculaValorDaParcela(valorDoEmplacamento,quantidadeDeParcelas,valorDeEntrada);
        parcela.setValorDaParcela(valorDaParcela);

        ArrayList<Parcela> listaDeParcelas = retornaListaDeParcelas(quantidadeDeParcelas,parcela);

        emplacamento.setListaDeparcelas(listaDeParcelas);

        return emplacamento;
    }

    private ArrayList<Parcela> retornaListaDeParcelas(Integer quantidadeDeParcelas, Parcela parcela){
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

    private boolean caixaDeTextoEhVaziaTelaDeCadastro(){
        return caixaDeTextoNomeCliente.getText().isBlank() || caixaDeTextoTelefone.getText().isBlank() ||
                caixaDeTextoPlacaCad.getText().isBlank() || caixaDeTextoEmplacamentoCad.getText().isBlank() ||
                caixaDeTextoValorEntradaCad.getText().isBlank() || caixaDeTextoValorTotalCad.getText().isBlank() ||
                caixaDeTextoValorParcelaCad.getText().isBlank();
    }

    private void salvarCliente(){
        try {
            bancoDeDados.persistirDados(registroClientes.retornarTodosOsClientes());

            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");

            textoDeAvisoCad.setText("");
            limparCamposDeTextoTelaDeCadastro();
            limparCamposDeTextoTelaDeSimulacao();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Não foi possível salvar o Cliente");
        }
    }

    private void limparCamposDeTextoTelaDeCadastro(){
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

    private void limparCamposDeTextoTelaDeSimulacao(){
        caixaDeTextoPlaca.setText("");
        caixaDeTextoValorEmplacamento.setText("");
        caixaDeTextoValorEntrada.setText("");
        caixaDeTextoValorTotal.setText("");
        caixaDeTextoValorParcela.setText("");
        seletorDeParcela.setSelectedIndex(0);
    }

    private void retornaTodosOsClientesParaATabela(){
        ArrayList<Cliente> listaDeClientes = registroClientes.retornarTodosOsClientes();
        ModeloDaTabela modeloDaTabela = new ModeloDaTabela(listaDeClientes);
        tabelaDeClientes.setModel(modeloDaTabela);
        tabelaDeClientes.setAutoCreateRowSorter(true);
    }

    public void eventoBotaoDeFazerCadastro(){
        botaoDeFazerCadastro.addActionListener(e -> {
            if (caixaDeTextoEhVaziaTelaDeSimulacao()){
                textoDeAviso.setText("Preencha todos os campos!");
            } else{
                pegarDadosDaTelaDeSimulacaoParaAtelaCadastro();
            }
        });
    }

    private void pegarDadosDaTelaDeSimulacaoParaAtelaCadastro(){
        telaPrincipal.setSelectedIndex(1);
        caixaDeTextoPlacaCad.setText(caixaDeTextoPlaca.getText());
        caixaDeTextoEmplacamentoCad.setText(caixaDeTextoValorEmplacamento.getText());
        caixaDeTextoValorEntradaCad.setText(caixaDeTextoValorEntrada.getText());
        caixaDeTextoValorTotalCad.setText(caixaDeTextoValorTotal.getText());
        caixaDeTextoValorParcelaCad.setText(caixaDeTextoValorParcela.getText());
        seletorParcelaCad.setSelectedIndex(seletorDeParcela.getSelectedIndex());
    }

    public void eventoDoBotaoDeVoltarDaTelaDeCadastro(){
        botaoDeVoltarCad.addActionListener(e -> {
            telaPrincipal.setSelectedIndex(0);
        });
    }

    private void eventoDoBotaoDeBuscar(){
        botaoDeBuscar.addActionListener(e -> {
            if (todasAsCaixasDeSelecaoMarcadas() || caixaDeNomeClienteENomePlacaMarcadas()
                    || caixaDeNomeClienteEParcelasMarcadas() || caixaDeNomePlacaEParcelasMarcadas()){
                textoDeAvisoConsul.setText("Selecione apenas UM filtro de pesquisa!");
            }
            else if (campoDePesquisaEhVazio()) {
                textoDeAvisoConsul.setText("Insira o Nome do Cliente ou da Placa que deseja buscar");
            }
            else if(campoDeSelecaoEhVazioEContemTexto()){
                textoDeAvisoConsul.setText("Selecione o filtro de pesquisa!");
            }
            else if(caixaDeSelecaoPorNomeDoCliente.isSelected()){
                String nome = campoDeTextoBuscar.getText();
                retornaOsClientesComNomePesquisadoParaATabela(nome);
                textoDeAvisoConsul.setText("");
            }
            else if (caixaDeSelecaoPorNomeDaPlaca.isSelected()) {
                String nomePlaca = campoDeTextoBuscar.getText();
                retornaOsClientesComNomeDaPlacaPesquisadoParaATabela(nomePlaca);
                textoDeAvisoConsul.setText("");
            }
            else if(caixaDeSelecaoPorParcelasVencidas.isSelected()){
                retornaOsClientesOPagamentoVencidoParaATabela();
                textoDeAvisoConsul.setText("");
            }
            else {
                retornaTodosOsClientesParaATabela();
                textoDeAvisoConsul.setText("");
                campoDeVizualizarNome.setText("");
            }
        });
    }

    private boolean todasAsCaixasDeSelecaoMarcadas(){
        return caixaDeSelecaoPorNomeDoCliente.isSelected()
                && caixaDeSelecaoPorNomeDaPlaca.isSelected()
                && caixaDeSelecaoPorParcelasVencidas.isSelected();
    }

    private boolean caixaDeNomeClienteENomePlacaMarcadas(){
        return caixaDeSelecaoPorNomeDoCliente.isSelected()
                && caixaDeSelecaoPorNomeDaPlaca.isSelected();
    }

    private boolean caixaDeNomeClienteEParcelasMarcadas(){
        return caixaDeSelecaoPorNomeDoCliente.isSelected()
                && caixaDeSelecaoPorParcelasVencidas.isSelected();
    }

    private boolean caixaDeNomePlacaEParcelasMarcadas(){
        return caixaDeSelecaoPorNomeDaPlaca.isSelected()
                && caixaDeSelecaoPorParcelasVencidas.isSelected();
    }

    private boolean campoDePesquisaEhVazio(){
        return (caixaDeSelecaoPorNomeDoCliente.isSelected() && campoDeTextoBuscar.getText().isBlank()) ||
                caixaDeSelecaoPorNomeDaPlaca.isSelected() && campoDeTextoBuscar.getText().isBlank();
    }

    private boolean campoDeSelecaoEhVazioEContemTexto(){
        return (!caixaDeSelecaoPorNomeDoCliente.isSelected() && !campoDeTextoBuscar.getText().isEmpty() &&
                !caixaDeSelecaoPorNomeDaPlaca.isSelected() && !campoDeTextoBuscar.getText().isBlank());
    }

    private void retornaOsClientesComNomePesquisadoParaATabela(String nome){
        try {
            ArrayList<Cliente> listaDeClientes = registroClientes.pesquisarListaDeClientesPeloNome(nome);
            ModeloDaTabela modeloDaTabela = new ModeloDaTabela(listaDeClientes);
            tabelaDeClientes.setModel(modeloDaTabela);
            tabelaDeClientes.setAutoCreateRowSorter(true);
        }catch (ClienteNaoExisteException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }

    private void retornaOsClientesComNomeDaPlacaPesquisadoParaATabela(String nomePlaca){
        try {
            ArrayList<Cliente> listaDeClientes = registroClientes.pesquisarPelaPlaca(nomePlaca);
            ModeloDaTabela modeloDaTabela = new ModeloDaTabela(listaDeClientes);
            tabelaDeClientes.setModel(modeloDaTabela);
            tabelaDeClientes.setAutoCreateRowSorter(true);
        }catch (ClienteNaoExisteException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }

    private void retornaOsClientesOPagamentoVencidoParaATabela(){
        try {
            ArrayList<Cliente> listaDeClientes = registroClientes.pesquisarClientesComPagamentoVencido();
            ModeloDaTabela modeloDaTabela = new ModeloDaTabela(listaDeClientes);
            tabelaDeClientes.setModel(modeloDaTabela);
            tabelaDeClientes.setAutoCreateRowSorter(true);
        }catch (ClienteNaoExisteException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }

    private void avisoAoFecharJanela(){
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

    public void eventoDoBotaoDeRemover(){
        botaoDeRemover.addActionListener(e -> {
            if (campoDeVizualizarNomeEhVazio()){
                JOptionPane.showMessageDialog(this, "Selecione o Cliente que deseja Remover!");
            } else {
                String nomeDoCliente = campoDeVizualizarNome.getText();

                int opcao = JOptionPane.showConfirmDialog(this, "Deseja Remover o Cliente: "+ nomeDoCliente + "?","Remover",JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION){
                    registroClientes.deletarClientePeloNome(nomeDoCliente);

                    persistirDados();

                    JOptionPane.showMessageDialog(this, "Cliente Removido com Sucesso!");
                    campoDeVizualizarNome.setText("");

                    retornaTodosOsClientesParaATabela();
                } else {
                    campoDeVizualizarNome.setText("");
                }
            }
        });
    }

    public void persistirDados(){
        try {
            bancoDeDados.persistirDados(registroClientes.retornarTodosOsClientes());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"Erro ao persistir os dados!");
        }
    }
    public void eventoDoBotaoDeEditar(){
        botaoDeEditar.addActionListener(e -> {
            if (campoDeVizualizarNomeEhVazio()){
                JOptionPane.showMessageDialog(this, "Selecione o Cliente que deseja Editar!");
            } else {
                TelaDeEditar telaDeEditar = new TelaDeEditar();
                String nomeDoCliente = campoDeVizualizarNome.getText();
                Cliente clienteRetornado = registroClientes.retornaClientePeloNome(nomeDoCliente);

                String nomeAtual = clienteRetornado.getNome();
                String telefoneAtual = clienteRetornado.getTelefone();
                String placaAtual = clienteRetornado.getEmplacamento().getNomeDaPlaca();
                String anotacaoAtual = clienteRetornado.getBlocoDeAnotacao();

                telaDeEditar.preencheCamposComDadosDoCliente(nomeAtual, telefoneAtual, placaAtual, anotacaoAtual);

                telaDeEditar.eventoDoBotaoDeSalvar(registroClientes, clienteRetornado);

                campoDeVizualizarNome.setText("");
            }

        });
    }
    public void eventoDoBotaoDeParcelas(){
        botaoDeParcelas.addActionListener(e -> {
            if (campoDeVizualizarNomeEhVazio()){
                JOptionPane.showMessageDialog(this, "Selecione o Cliente que deseja ver as Parcelas!");
            } else {
                TelaDeParcelas telaDeParcelas = new TelaDeParcelas();

                String nomeDoCliente = campoDeVizualizarNome.getText();
                ArrayList<Parcela> listaDeParcelas = registroClientes.retornarParcelasDoClientePeloNome(nomeDoCliente);
            }

        });
    }
    public void eventoDoBotaoDeAnotacoes(){
        botaoDeAnotacoes.addActionListener(e -> {
            if (campoDeVizualizarNomeEhVazio()){
                JOptionPane.showMessageDialog(this, "Selecione o Cliente que deseja ver as Anotações!");
            } else {
                TelaDeAnotacao telaDeAnotacao = new TelaDeAnotacao();
                String nomeDoCliente = campoDeVizualizarNome.getText();

                String anotacoesDoCliente = registroClientes.pegaAnotacaoDoClientePeloNome(nomeDoCliente);

                telaDeAnotacao.setTextoCampodeAnotacoes(anotacoesDoCliente);
                telaDeAnotacao.setTextoCampoDeNomeCliente(nomeDoCliente);

                campoDeVizualizarNome.setText("");
            }
        });
    }

    public void eventoDoMouseAoClicar(){
        tabelaDeClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var linhaClicada = tabelaDeClientes.getSelectedRow();
                String nomeDoCliente = (String) tabelaDeClientes.getValueAt(linhaClicada,0);
                campoDeVizualizarNome.setText(nomeDoCliente);
            }
        });
    }

    private boolean campoDeVizualizarNomeEhVazio(){
        return campoDeVizualizarNome.getText().isBlank();
    }

    public void eventoDoBotaoDeAtualizar(){
        atualizarButton.addActionListener(e -> {
            retornaTodosOsClientesParaATabela();
            campoDeVizualizarNome.setText("");
        });
    }
}
