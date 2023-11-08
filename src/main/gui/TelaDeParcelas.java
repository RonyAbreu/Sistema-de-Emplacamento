package main.gui;

import javax.swing.*;
import java.awt.*;

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

    public TelaDeParcelas(){
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
            tituloPar1.setForeground(VERDE);
            valorPar1.setForeground(VERDE);
            dataPar1.setForeground(VERDE);
            caixaDeTextoValorPar1.setBackground(VERDE);
            caixaDeTextoDataPar1.setBackground(VERDE);
        });
    }

    public void eventoBotaoDePagarParcela2(){
        botaoDePagarPar2.addActionListener(e -> {
            tituloPar2.setForeground(VERDE);
            valorPar2.setForeground(VERDE);
            dataPar2.setForeground(VERDE);
            caixaDeTextoValorPar2.setBackground(VERDE);
            caixaDeTextoDataPar2.setBackground(VERDE);
        });
    }

    public void eventoBotaoDePagarParcela3(){
        botaoDePagarPar3.addActionListener(e -> {
            tituloPar3.setForeground(VERDE);
            valorPar3.setForeground(VERDE);
            dataPar3.setForeground(VERDE);
            caixaDeTextoValorPar3.setBackground(VERDE);
            caixaDeTextoDataPar3.setBackground(VERDE);
        });
    }

    public void eventoBotaoDePagarParcela4(){
        botaoDePagarPar4.addActionListener(e -> {
            tituloPar4.setForeground(VERDE);
            valorPar4.setForeground(VERDE);
            dataPar4.setForeground(VERDE);
            caixaDeTextoValorPar4.setBackground(VERDE);
            caixaDeTextoDataPar4.setBackground(VERDE);
        });
    }

    public void eventoDoBotaoDeSalvar(){
        botaoDeSalvar.addActionListener(e -> {

        });
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
