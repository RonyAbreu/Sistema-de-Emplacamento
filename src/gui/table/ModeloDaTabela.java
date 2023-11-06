package gui.table;

import entity.Cliente;

import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.util.List;

public class ModeloDaTabela extends AbstractTableModel {
    private final String[] coluna = {"NOME","TELEFONE","PLACA","PARCELAS","VALOR DA PARCELA","VALOR TOTAL"};
    private List<Cliente> listaDeClientes;

    public ModeloDaTabela(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    @Override
    public int getRowCount() {
        return listaDeClientes.size();
    }

    @Override
    public int getColumnCount() {
        return coluna.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex){
            case 0 -> listaDeClientes.get(rowIndex).getNome();
            case 1 -> listaDeClientes.get(rowIndex).getTelefone();
            case 2 -> listaDeClientes.get(rowIndex).getEmplacamento().getNomeDaPlaca();
            case 3 -> listaDeClientes.get(rowIndex).getEmplacamento().getQuantidadeDeParcelas();
            case 4 -> formatadorDeNumeros(listaDeClientes.get(rowIndex).getEmplacamento().getListaDeparcelas().get(0).getValorDaParcela());
            case 5 -> listaDeClientes.get(rowIndex).getEmplacamento().getValorTotal();
            default -> "-";
        };
    }

    @Override
    public String getColumnName(int column) {
        return coluna[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (getValueAt(0,columnIndex) != null){
            return getValueAt(0, columnIndex).getClass();
        } else {
            return Object.class;
        }
    }

    private Double formatadorDeNumeros(Double numero){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return Double.parseDouble(decimalFormat.format(numero).replace(",","."));
    }
}
