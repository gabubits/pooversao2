package Trabalho.Persistencia;

import Trabalho.Entidade;

public interface Persistencia {

    void Inserir(Entidade entidade);
    void Excluir(Entidade entidade);
    Entidade BuscarId(int id);
    Entidade BuscarString(String string);

}