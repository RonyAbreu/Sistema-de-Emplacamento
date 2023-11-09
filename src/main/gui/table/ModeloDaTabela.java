package main.gui.table;

import main.entity.Cliente;

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
        try {
            if (columnIndex == 0) {
                return listaDeClientes.get(rowIndex).getNome();
            } else if (columnIndex == 1) {
                return listaDeClientes.get(rowIndex).getTelefone();
            } else if (columnIndex == 2) {
                return listaDeClientes.get(rowIndex).getEmplacamento().getNomeDaPlaca();
            } else if (columnIndex == 3) {
                return listaDeClientes.get(rowIndex).getEmplacamento().getQuantidadeDeParcelas();
            } else if (columnIndex == 4) {
                return formatadorDeNumeros(listaDeClientes.get(rowIndex).getEmplacamento().getListaDeparcelas().get(0).getValorDaParcela());
            } else if (columnIndex == 5) {
                return listaDeClientes.get(rowIndex).getEmplacamento().getValorTotal();
            } else {
                return 0;
            }
        }catch (Exception ignored){

        }
        return 0;
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
