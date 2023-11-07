package main.exceptions;

public class ValorDeEntradaInvalidoException extends RuntimeException{
    public ValorDeEntradaInvalidoException(String mensagem){
        super(mensagem);
    }
}
