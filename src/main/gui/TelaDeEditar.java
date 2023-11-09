package main.gui;

import main.db.BancoDeDados;
import main.entity.Cliente;
import main.entity.RegistroClientes;

import javax.swing.*;
import java.io.IOException;

public class TelaDeEditar extends JFrame{
    private JPanel painelDeCadastro;
    private JTextField caixaDeTextoNomeClienteEd;
    private JTextField caixaDeTextoTelefoneEd;
    private JTextField caixaDeTextoPlacaEd;
    private JTextPane campoDeAnotacaoEd;
    private JLabel textoDeAvisoEd;
    private JPanel painelPrincipal;
    private JButton botaoDeSalvar;
    private BancoDeDados bancoDeDados = new BancoDeDados();
    private RegistroClientes registroClientes;
    private SistemaEmplacamentoTela sistemaEmplacamentoTela;

    public TelaDeEditar(RegistroClientes registroClientes, SistemaEmplacamentoTela sistemaEmplacamentoTela){
        this.registroClientes = registroClientes;
        this.sistemaEmplacamentoTela = sistemaEmplacamentoTela;
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

    public void eventoDoBotaoDeSalvar(Cliente clienteRetornado){
        botaoDeSalvar.addActionListener(e -> {
            String novoNome = caixaDeTextoNomeClienteEd.getText();
            String novoTelefone = caixaDeTextoTelefoneEd.getText();
            String novaPlaca = caixaDeTextoPlacaEd.getText();
            String novasAnotacoes = campoDeAnotacaoEd.getText();

            clienteRetornado.setNome(novoNome);
            clienteRetornado.setTelefone(novoTelefone);
            clienteRetornado.getEmplacamento().setNomeDaPlaca(novaPlaca);
            clienteRetornado.setBlocoDeAnotacao(novasAnotacoes);

            JOptionPane.showMessageDialog(this, "Cliente Salvo com sucesso!");

            salvarDados();

            this.dispose();

            sistemaEmplacamentoTela.retornaTodosOsClientesParaATabela();
        });
    }

    private void salvarDados() {
        try {
            bancoDeDados.persistirDados(registroClientes.retornarTodosOsClientes());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar dados do Cliente Editado!");
        }
    }

    public void preencheCamposComDadosDoCliente(String nomeCliente, String telefone, String placa, String anotacao){
        setTextoNomeClienteEd(nomeCliente);
        setTextoTelefoneEd(telefone);
        setTextoPlacaEd(placa);
        setTextoCampoDeAnotacaoEd(anotacao);
    }

    public void setTextoNomeClienteEd(String nomeClienteEd) {
        this.caixaDeTextoNomeClienteEd.setText(nomeClienteEd);
    }

    public void setTextoTelefoneEd(String telefoneEd) {
        this.caixaDeTextoTelefoneEd.setText(telefoneEd);
    }

    public void setTextoPlacaEd(String placaEd) {
        this.caixaDeTextoPlacaEd.setText(placaEd);
    }

    public void setTextoCampoDeAnotacaoEd(String anotacaoEd) {
        this.campoDeAnotacaoEd.setText(anotacaoEd);
    }
}
