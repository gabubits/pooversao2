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


    public abstract void TelaInserir();
    public abstract void TelaExcluir();
    //public abstract void BuscarID();
    //public abstract void BuscarString();

}
