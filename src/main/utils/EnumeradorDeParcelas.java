package main.utils;

import main.entity.Parcela;
import main.gui.TelaDeParcelas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EnumeradorDeParcelas {

    public static void incluiUmaParcela(TelaDeParcelas telaDeParcelas, ArrayList<Parcela> listaDeParcelas, DateTimeFormatter formatador){
        Double valorDaParcela = listaDeParcelas.get(0).getValorDaParcela();
        String valorDaParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaParcela);
        LocalDate dataDaParcela = listaDeParcelas.get(0).getDataDeVencimento();
        String dataFormatada = formatador.format(dataDaParcela);
        telaDeParcelas.getCaixaDeTextoValorPar1().setText(valorDaParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar1().setText(dataFormatada);
    }

    public static void incluiDuasParcela(TelaDeParcelas telaDeParcelas, ArrayList<Parcela> listaDeParcelas, DateTimeFormatter formatador){
        Double valorDaPrimeiraParcela = listaDeParcelas.get(0).getValorDaParcela();
        String valorDaPrimeiraParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaPrimeiraParcela);
        LocalDate dataDaPrimeiraParcela = listaDeParcelas.get(0).getDataDeVencimento();
        String dataDaPrimeiraParcelaFormatada = formatador.format(dataDaPrimeiraParcela);
        telaDeParcelas.getCaixaDeTextoValorPar1().setText(valorDaPrimeiraParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar1().setText(dataDaPrimeiraParcelaFormatada);

        Double valorDaSegundaParcela = listaDeParcelas.get(1).getValorDaParcela();
        String valorDaSegundaParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaSegundaParcela);
        LocalDate dataDaSegundaParcela = listaDeParcelas.get(1).getDataDeVencimento();
        String dataDeSegundaParcelaFormatada = formatador.format(dataDaSegundaParcela);
        telaDeParcelas.getCaixaDeTextoValorPar2().setText(valorDaSegundaParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar2().setText(dataDeSegundaParcelaFormatada);
    }

    public static void incluiTresParcela(TelaDeParcelas telaDeParcelas, ArrayList<Parcela> listaDeParcelas, DateTimeFormatter formatador){
        Double valorDaPrimeiraParcela = listaDeParcelas.get(0).getValorDaParcela();
        String valorDaPrimeiraParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaPrimeiraParcela);
        LocalDate dataDaPrimeiraParcela = listaDeParcelas.get(0).getDataDeVencimento();
        String dataDaPrimeiraParcelaFormatada = formatador.format(dataDaPrimeiraParcela);
        telaDeParcelas.getCaixaDeTextoValorPar1().setText(valorDaPrimeiraParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar1().setText(dataDaPrimeiraParcelaFormatada);

        Double valorDaSegundaParcela = listaDeParcelas.get(1).getValorDaParcela();
        String valorDaSegundaParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaSegundaParcela);
        LocalDate dataDaSegundaParcela = listaDeParcelas.get(1).getDataDeVencimento();
        String dataDeSegundaParcelaFormatada = formatador.format(dataDaSegundaParcela);
        telaDeParcelas.getCaixaDeTextoValorPar2().setText(valorDaSegundaParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar2().setText(dataDeSegundaParcelaFormatada);

        Double valorDaTerceiraParcela = listaDeParcelas.get(2).getValorDaParcela();
        String valorDaTerceiraParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaTerceiraParcela);
        LocalDate dataDaTerceiraParcela = listaDeParcelas.get(2).getDataDeVencimento();
        String dataDaTerceiraParcelaFormatada = formatador.format(dataDaTerceiraParcela);
        telaDeParcelas.getCaixaDeTextoValorPar3().setText(valorDaTerceiraParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar3().setText(dataDaTerceiraParcelaFormatada);
    }

    public static void incluiQuatroParcela(TelaDeParcelas telaDeParcelas, ArrayList<Parcela> listaDeParcelas, DateTimeFormatter formatador){
        Double valorDaPrimeiraParcela = listaDeParcelas.get(0).getValorDaParcela();
        String valorDaPrimeiraParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaPrimeiraParcela);
        LocalDate dataDaPrimeiraParcela = listaDeParcelas.get(0).getDataDeVencimento();
        String dataDaPrimeiraParcelaFormatada = formatador.format(dataDaPrimeiraParcela);
        telaDeParcelas.getCaixaDeTextoValorPar1().setText(valorDaPrimeiraParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar1().setText(dataDaPrimeiraParcelaFormatada);

        Double valorDaSegundaParcela = listaDeParcelas.get(1).getValorDaParcela();
        String valorDaSegundaParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaSegundaParcela);
        LocalDate dataDaSegundaParcela = listaDeParcelas.get(1).getDataDeVencimento();
        String dataDeSegundaParcelaFormatada = formatador.format(dataDaSegundaParcela);
        telaDeParcelas.getCaixaDeTextoValorPar2().setText(valorDaSegundaParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar2().setText(dataDeSegundaParcelaFormatada);

        Double valorDaTerceiraParcela = listaDeParcelas.get(2).getValorDaParcela();
        String valorDaTerceiraParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaTerceiraParcela);
        LocalDate dataDaTerceiraParcela = listaDeParcelas.get(2).getDataDeVencimento();
        String dataDaTerceiraParcelaFormatada = formatador.format(dataDaTerceiraParcela);
        telaDeParcelas.getCaixaDeTextoValorPar3().setText(valorDaTerceiraParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar3().setText(dataDaTerceiraParcelaFormatada);

        Double valorDaQuartaParcela = listaDeParcelas.get(3).getValorDaParcela();
        String valorDaQuartaParcelaFormatado = FormatadorDeNumeros.formatarNumero(valorDaQuartaParcela);
        LocalDate dataDaQuartaParcela = listaDeParcelas.get(3).getDataDeVencimento();
        String dataDaQuartaParcelaFormatada = formatador.format(dataDaQuartaParcela);
        telaDeParcelas.getCaixaDeTextoValorPar4().setText(valorDaQuartaParcelaFormatado);
        telaDeParcelas.getCaixaDeTextoDataPar4().setText(dataDaQuartaParcelaFormatada);
    }
}
