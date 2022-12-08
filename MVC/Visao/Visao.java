package Trabalho.MVC.Visao;

import Trabalho.MVC.Controle.Controle;

import java.util.Scanner;

public abstract class Visao {

    protected Controle controle;
    protected Scanner scanner;

    public Visao(Controle pcontrole, Scanner pscanner) {
        this.controle = pcontrole;
        this.scanner = pscanner;
    }

    public void opcoes() {
        while (true) {
            int op = menu();
            if (op == 0)
                return;
            else if (op == 1)
                Inserir();
            else if (op == 2)
                Excluir();
            else if (op == 3)
                BuscarID();
            else if (op == 4)
                BuscarString();
        }
    }

    public abstract int menu();

    public abstract void Inserir();
    public abstract void Excluir();
    public abstract void BuscarID();
    public abstract void BuscarString();

}
