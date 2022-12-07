package Trabalho.Persistencia;

import Trabalho.Entidade;
import Trabalho.Venda;
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

public class VendaP implements Persistencia {

    private static VendaP instancia;
    private VendaP(){}
    public static synchronized VendaP getinstancia(){
        if (instancia == null) instancia = new VendaP();
        return instancia;
    }


    private LinkedList<Venda> Vendas = new LinkedList<>();

    String caminho = System.getProperty("user.dir") + "\\PersistenciaVendas.json";
    File BancoDeDadosVenda = new File(caminho);

    public void InicializarArquivo(boolean choice){
        if (choice) CarregarArquivo();
    }

    public void Inserir(Entidade entidade){
        if (Vendas.size() == 0) {
            entidade.setId(1);
        } else {
            entidade.setId(Vendas.get(
                    Vendas.size() - 1).getId() + 1);
        }
        Vendas.add( (Venda) entidade );
    }

    public void Excluir(Entidade entidade){
        Vendas.remove((Venda) entidade);
        for (int i = 0; i < Vendas.size(); i++) Vendas.get(i).setId(i + 1);
    }

    public void AtualizarArquivo(){
        if (Vendas.size() != 0) {
            if (!BancoDeDadosVenda.exists()) {
                try {
                    BancoDeDadosVenda.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            Gson gson = new Gson();
            String json = gson.toJson(Vendas);
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
            if (BancoDeDadosVenda.exists()) BancoDeDadosVenda.delete();
        }
    }

    public void CarregarArquivo(){
        String conteudoObjetos = null;
        try {conteudoObjetos = Files.readString(Paths.get(caminho));}
        catch (IOException exception) {exception.printStackTrace();}
        Gson gson = new Gson();
        Type tipoVendas = new TypeToken<LinkedList<Venda>>() {
        }.getType();
        Vendas = gson.fromJson(conteudoObjetos, tipoVendas);
    }
    public Venda BuscarId(int id) {
        for (Venda venda : Vendas) {
            if (venda.getId() == id) {
                return venda;
            }
        }
        return null;
    }
    public Venda BuscarString(String CPFCliente) {
        for (Venda venda : Vendas) {
            if (venda.getClienteDaVenda().getCpf().equals(CPFCliente)) {
                return venda;
            }
        }
        return null;
    }

    public LinkedList<Venda> getVendas(){
        return Vendas;
    }
}