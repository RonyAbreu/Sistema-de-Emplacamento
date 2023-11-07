package main.gui;

import javax.swing.*;

public class TelaDeParcelas extends JFrame{
    private JPanel painelPrincipal;
    private JTextField campoDeTextoNomeClientePar;
    private JTextField textField1;
    private JButton pagarButton;
    private JButton salvarButton;

    public TelaDeParcelas(){
        configuraTela();
    }

    public void configuraTela(){
        setContentPane(painelPrincipal);
        setTitle("Parcelas");
        setSize(800,600);
        setResizable(false);
        setVisible(true);
        setLocation(525,200);
    }

    public static void main(String[] args) {
        TelaDeParcelas telaDeParcelas = new TelaDeParcelas();
    }
}
