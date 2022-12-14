package Trabalho.MVC.Visao.AbstractTables;

import Trabalho.MVC.Controle.Controle;
import Trabalho.MVC.Modelo.Entidade;
import Trabalho.MVC.Modelo.Filme;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class AbstractTableFilme extends AbstractTableModel {


    private Controle Controlador;
    private List<Entidade> Filmes;
    private String[] NomesColunas = {"ID", "Titulo do Filme", "Faixa Etária do Filme", "Contagem de  Ingressos"};

    public AbstractTableFilme(Controle pFilmeControle) {
        this.Controlador = pFilmeControle;
        Filmes = Controlador.CarregarArquivo();
        this.fireTableDataChanged();
    }
    public AbstractTableFilme (){}

    @Override
    public String getColumnName(int column) {
        return NomesColunas[column];
    }

    @Override
    public int getRowCount() {
        return Filmes.size();
    }

    @Override
    public int getColumnCount() {
        return NomesColunas.length;
    }

    @Override
    public Object getValueAt(int NLinha, int NColuna) {
        switch(NColuna) {
            case 0:
                return Filmes.get(NLinha).getId();
            case 1:
                return ((Filme) Filmes.get(NLinha)).getTitulo();
            case 2:
                return ((Filme) Filmes.get(NLinha)).getFaixaEtaria();
            case 3:
                return ((Filme) Filmes.get(NLinha)).getContagemdeIngressos();
        }
        return "";
    }
    public void addRow(Entidade entidade) {
        Controlador.Inserir(entidade);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha){
        Controlador.Excluir(this.Filmes.get(linha));
        for (int i = 0; i < this.Filmes.size(); i++) this.Filmes.get(i).setId(i + 1);
        this.fireTableDataChanged();
    }
}
