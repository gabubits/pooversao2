package Trabalho.MVC.Persistencia;

import Trabalho.MVC.Modelo.Entidade;

public interface Persistencia {

    void Inserir(Entidade entidade);
    void Excluir(Entidade entidade);
    Entidade BuscarId(int id);
    Entidade BuscarString(String string);

    void CarregarArquivo();
    void AtualizarArquivo();

}