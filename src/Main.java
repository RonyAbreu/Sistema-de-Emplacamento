import db.BancoDeDados;
import entity.RegistroClientes;
import gui.SistemaEmplacamentoTela;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        RegistroClientes registroClientes = new RegistroClientes();
        SistemaEmplacamentoTela sistemaEmplacamentoTela = new SistemaEmplacamentoTela(registroClientes);
    }
}