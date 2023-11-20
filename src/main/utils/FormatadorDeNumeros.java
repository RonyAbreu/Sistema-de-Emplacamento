package main.utils;

import java.text.DecimalFormat;

public class FormatadorDeNumeros {
    public static String formatarNumero(Double numero){
        return new DecimalFormat("##.##").format(numero).replace(",",".");
    }
}
