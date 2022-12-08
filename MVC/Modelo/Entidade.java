package Trabalho.MVC.Modelo;
public abstract class Entidade{
    private int id;

    public Entidade() {
        this.id = 0;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public abstract String toString();

} 