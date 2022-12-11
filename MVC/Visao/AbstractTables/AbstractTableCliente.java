package Trabalho.MVC.Visao.AbstractTables;

import Trabalho.MVC.Controle.Controle;
import Trabalho.MVC.Modelo.Cliente;
import Trabalho.MVC.Modelo.Entidade;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AbstractTableCliente extends AbstractTableModel {

    private Controle Controlador;
    private List<Entidade> Clientes;
    private String[] NomesColunas = {"ID", "Nome", "CPF", "Idade"};

    public AbstractTableCliente(Controle pClienteControle) {
        this.Controlador = pClienteControle;
        Clientes = Controlador.CarregarArquivo();
        this.fireTableDataChanged();
    }

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
                return ((Cliente) Clientes.get(NLinha)).getNome();
            case 2:
                return ((Cliente) Clientes.get(NLinha)).getCpf();
            case 3:
                return ((Cliente) Clientes.get(NLinha)).getIdade();
        }
        return "";
    }

    public void addRow(Entidade entidade) {
        Controlador.Inserir(entidade);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha){
        Controlador.Excluir(this.Clientes.get(linha));
        for (int i = 0; i < this.Clientes.size(); i++) this.Clientes.get(i).setId(i + 1);
        this.fireTableDataChanged();
    }
}
