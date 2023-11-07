package main.gui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaDeAnotacao extends JFrame {
    private JPanel painelPrincipal;
    private JTextPane campoDeAnotacoesDoCLiente;
    private JTextField campoDeTextoNomeCliente;

    public TelaDeAnotacao(){
        configuraTela();
        avisoAoFecharJanela();
    }

    private void configuraTela(){
        setTitle("Anotações");
        setContentPane(painelPrincipal);
        setSize(600, 500);
        setLocation(650,200);
        setVisible(true);
        setResizable(true);
    }

    private void avisoAoFecharJanela(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int fechar = JOptionPane.showConfirmDialog(null,"Deseja Fechar a Janela?","Sair",JOptionPane.YES_NO_OPTION);
                if(fechar == JOptionPane.YES_OPTION){
                    fecharJanela();
                }
            }
        });
    }

    private void fecharJanela(){
        this.dispose();
    }

    public static void main(String[] args) {
        TelaDeAnotacao telaDeAnotacao = new TelaDeAnotacao();
    }
}
