package Trabalho;
public abstract class Entidade{
    private int id;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public abstract String toString();

} 