package Trabalho.MVC.Persistencia;

// Importação dos pacotes necessários:
//  Manipulação de arquivos, conversão de objeto para JSON, ArrayList

import Trabalho.MVC.Modelo.Cliente;
import Trabalho.MVC.Modelo.Entidade;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;


public class ClienteP implements Persistencia {

    private static ClienteP instancia;

    private ClienteP(){}

    public static synchronized ClienteP getinstancia(){
        if (instancia == null) instancia = new ClienteP();
        return instancia;
    }

    private LinkedList<Entidade> ListadeCliente = new LinkedList<>();

    String caminho = System.getProperty("user.dir") + "\\PersistenciaClientes.json";

    File BancoDeDadosCliente = new File(caminho);

    public void InicializarArquivo(boolean choice) {
        if (choice) CarregarArquivo();
    }

    public void Inserir(Entidade entidade){
        if (ListadeCliente.size() == 0) {
            entidade.setId(1);
        } else {
            entidade.setId(ListadeCliente.get(
                   ListadeCliente.size() - 1).getId() + 1);
        }
        ListadeCliente.add( (Cliente) entidade );
    }

    // Método para excluir um objeto do ArrayList e, consequentemente, do arquivo.
    public void Excluir(Entidade entidade){
        ListadeCliente.remove((Cliente) entidade);
        for (int i = 0; i < ListadeCliente.size(); i++) ListadeCliente.get(i).setId(i + 1);
    }

    public void AtualizarArquivo(){
        if (ListadeCliente.size() != 0) {
            if (!BancoDeDadosCliente.exists()) {
                try {
                    BancoDeDadosCliente.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            Gson gson = new Gson();
            String json = gson.toJson(ListadeCliente);
            FileWriter arq = null;
            try {
                arq = new FileWriter(caminho);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            PrintWriter gravador = new PrintWriter(arq);

            gravador.println(json);

            try {
                arq.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else {
            if (BancoDeDadosCliente.exists()) BancoDeDadosCliente.delete();
        }
    }

    public LinkedList<Entidade> CarregarArquivo(){
        if (!BancoDeDadosCliente.exists()) return ListadeCliente;
        String conteudoObjetos = null;
        try {conteudoObjetos = Files.readString(Paths.get(caminho));}
        catch (IOException exception) {exception.printStackTrace();}
        Gson gson = new Gson();
        Type tipoListadeCliente = new TypeToken<LinkedList<Cliente>>() {
        }.getType();
        ListadeCliente = gson.fromJson(conteudoObjetos, tipoListadeCliente);
        return ListadeCliente;
    }

    // Método simples iterativo para buscar por id.
    public Cliente BuscarId(int id) {
        if (ListadeCliente.size() == 0) return null;
        for (Entidade cliente : ListadeCliente) {
            if (cliente.getId() == id) {
                return (Cliente) cliente;
            }
        }
        return null;
    }

    // Método simples iterativo para buscar pelo nome.
    public Cliente BuscarString(String CPF) {
        if (ListadeCliente.size() == 0) return null;
        for (Entidade cliente : ListadeCliente) {
            if (((Cliente) cliente).getCpf().equals(CPF)) {
                return (Cliente) cliente;
            }
        }
        return null;
    }
}
