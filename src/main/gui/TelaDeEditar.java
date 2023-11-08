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

    public void eventoDoBotaoDeSalvar(RegistroClientes registroClientes, Cliente clienteRetornado){
        botaoDeSalvar.addActionListener(e -> {
            try {
                String novoNome = caixaDeTextoNomeClienteEd.getText();
                String novoTelefone = caixaDeTextoTelefoneEd.getText();
                String novaPlaca = caixaDeTextoPlacaEd.getText();
                String novasAnotacoes = campoDeAnotacaoEd.getText();

                clienteRetornado.setNome(novoNome);
                clienteRetornado.setTelefone(novoTelefone);
                clienteRetornado.getEmplacamento().setNomeDaPlaca(novaPlaca);
                clienteRetornado.setBlocoDeAnotacao(novasAnotacoes);

                bancoDeDados.persistirDados(registroClientes.retornarTodosOsClientes());
                JOptionPane.showMessageDialog(this, "Cliente Salvo com sucesso!");
                this.dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar dados!");
            }
        });
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
