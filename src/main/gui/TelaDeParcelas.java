package main.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void eventoBotaoDePagarParcela1(){
        botaoDePagarPar1.addActionListener(e -> {

        });
    }

    public void eventoBotaoDePagarParcela2(){
        botaoDePagarPar2.addActionListener(e -> {

        });
    }

    public void eventoBotaoDePagarParcela3(){
        botaoDePagarPar3.addActionListener(e -> {

        });
    }

    public void eventoBotaoDePagarParcela4(){
        botaoDePagarPar4.addActionListener(e -> {

        });
    }

    public void eventoDoBotaoDeSalvar(){
        botaoDeSalvar.addActionListener(e -> {

        });
    }
}
