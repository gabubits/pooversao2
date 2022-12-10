package Trabalho.MVC.Persistencia;

import Trabalho.MVC.Modelo.Entidade;

import java.util.LinkedList;
import java.util.List;

public interface Persistencia {

    void InicializarArquivo(boolean choice);
    void Inserir(Entidade entidade);
    void Excluir(Entidade entidade);
    Entidade BuscarId(int id);
    Entidade BuscarString(String string);

    LinkedList<Entidade> CarregarArquivo();
    void AtualizarArquivo();

}