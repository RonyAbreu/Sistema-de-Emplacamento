package exceptions;

public class ClienteJaExisteException extends RuntimeException{
    public ClienteJaExisteException(String mensagem){
        super(mensagem);
    }
}
