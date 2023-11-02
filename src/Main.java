import entidades.RegistroClientes;
import gui.SistemaEmplacamentoTela;

public class Main {
    public static void main(String[] args) {
        RegistroClientes registroClientes = new RegistroClientes();
        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela(registroClientes);
    }
}