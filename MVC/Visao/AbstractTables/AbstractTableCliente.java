package Trabalho.MVC.Visao.AbstractTables;

import Trabalho.MVC.Controle.ClienteControle;
import Trabalho.MVC.Modelo.Cliente;
import Trabalho.MVC.Modelo.Entidade;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.List;

public class AbstractTableCliente extends AbstractTableModel {

    private ClienteControle Controlador;
    public AbstractTableCliente(ClienteControle pClienteControle) {
        this.Controlador = pClienteControle;

    }
    public AbstractTableCliente(){}
    private List<Cliente> Clientes = new LinkedList<>();
    private String[] NomesColunas = {"ID", "Nome", "CPF", "Idade"};

    @Override
    public String getColumnName(int column) {
        return NomesColunas[column];
    }

    @Override
    public int getRowCount() {
        return Clientes.size();
    }

    @Override
    public int getColumnCount() {
        return NomesColunas.length;
    }

    @Override
    public Object getValueAt(int NLinha, int NColuna) {
        switch(NColuna) {
            case 0:
                return Clientes.get(NLinha).getId();
            case 1:
                return Clientes.get(NLinha).getNome();
            case 2:
                return Clientes.get(NLinha).getCpf();
            case 3:
                return Clientes.get(NLinha).getIdade();
        }
        return null;
    }

    public void addRow(Cliente pCliente) {

    }
}
