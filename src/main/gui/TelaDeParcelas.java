package main.gui;

import javax.swing.*;

public class TelaDeParcelas extends JFrame{
    private JPanel painelPrincipal;

    public TelaDeParcelas(){
        configuraTela();
    }

    public void configuraTela(){
        setContentPane(painelPrincipal);
        setTitle("Parcelas");
        setSize(600,600);
        setResizable(false);
        setVisible(true);
        setLocation(450,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TelaDeParcelas telaDeParcelas = new TelaDeParcelas();
    }
}
