package Trabalho.MVC.Modelo;

public class Ingresso extends Entidade {

    private Filme filme;
    private int horarioEntrada;
    private double valor;
    private int duracao;

    // Construtores
    public Ingresso(){
        super();
        filme = null;
        horarioEntrada = 0;
        valor = 0.0;
        duracao = 1;
    }
    public Ingresso(Ingresso ingresso){
        setId(ingresso.getId());
        filme = ingresso.getFilme();
        horarioEntrada = ingresso.getHorarioEntrada();
        valor = ingresso.getValor();
        duracao = 1;
    }

    public Ingresso(int id, Filme filme, int horarioEntrada){
        setId(id);
        this.filme = filme;
        this.horarioEntrada = horarioEntrada;
    }

    public double getValor() {
        return valor;
    }
     public void setValor(double valor) {
        this.valor = valor;
    }

     public int getHorarioEntrada() {
        return horarioEntrada;
    }
     public void setHorarioEntrada(int horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public int getDuracao() {
        return duracao;
    }

    public Filme getFilme() { return filme; }
    public void setFilme(Filme filme) { this.filme = filme; }
    public String toString(){
        return String.format("Ingresso (%d):\n\tFilme: %s.\n\tHorario de Entrada: %d hora(s).\n\tValor do Ingresso: %f.\n\tDuracao: %d hora(s).\n",
                getId(), getFilme().getTitulo(), getHorarioEntrada(), getValor(), getDuracao());
    }



}