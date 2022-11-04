package Trabalho;

public class Cliente extends Entidade {

    private String cpf;
    private String nome;
    private int idade;

    public Cliente(){
        cpf = "";
        nome = "";
        idade = 0;
    }

    public Cliente(String cpf, String nome, int idade){
        setCpf(cpf);
        setNome(nome);
        setIdade(idade);
    }

     public String getCpf() {
        return cpf;
    }
     public void setCpf(String cpf) {
        this.cpf = cpf;
     }
     public String getNome() {
        return nome;
    }
     public void setNome(String nome) {
         this.nome = nome;
    }
     public int getIdade() {
        return idade;
    }
     public void setIdade(int idade) {
        this.idade = idade;
    }

    public String toString(){
        return String.format("Cliente ID(%d):\n\tCPF: %s;\n\tNome: %s;\n\tIdade: %d\n",
                getId(), getCpf(), getNome(), getIdade());
    }

}
