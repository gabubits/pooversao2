package Trabalho.MVC.Persistencia;

import Trabalho.MVC.Modelo.Entidade;
import Trabalho.MVC.Modelo.Ingresso;
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

public class IngressoP implements Persistencia {

    private static IngressoP instancia;

    private IngressoP(){}
    public static synchronized IngressoP getinstancia(){
        if (instancia == null) instancia = new IngressoP();
        return instancia;
    }
    private static LinkedList<Entidade> ListadeIngressos = new LinkedList<>();

    String caminho = System.getProperty("user.dir") + "\\PersistenciaIngressos.json";
    File BancoDeDadosIngresso = new File(caminho);

    public void InicializarArquivo(boolean choice){
        if (choice) CarregarArquivo();
    }

    public void Inserir(Entidade entidade){
        if (ListadeIngressos.size() == 0) {
            entidade.setId(1);
        } else {
            entidade.setId(ListadeIngressos.get(
                   ListadeIngressos.size() - 1).getId() + 1);
        }

        ListadeIngressos.add( (Ingresso) entidade );
    }

    public void Excluir(Entidade entidade) {
        int contadorderemovidos = 0;
        if (((Ingresso) entidade).getHorarioEntrada() == -1) {
            for (int i = 0; i < ListadeIngressos.size(); ) {
                if (((Ingresso) ListadeIngressos.get(i)).getFilme().getTitulo().equals(((Ingresso) entidade).getFilme().getTitulo())) {
                    ListadeIngressos.remove(i);
                    contadorderemovidos += 1;
                    if (contadorderemovidos == ((Ingresso) entidade).getId()) break;
                } else i += 1;
            }
        } else {
            for (int i = 0; i < ListadeIngressos.size(); ) {
                if (((Ingresso) ListadeIngressos.get(i)).getFilme().getTitulo().equals(((Ingresso) entidade).getFilme().getTitulo())
                    && ((Ingresso) ListadeIngressos.get(i)).getHorarioEntrada() == ((Ingresso) entidade).getHorarioEntrada()) {
                    ListadeIngressos.remove(i);
                    contadorderemovidos += 1;
                    if (contadorderemovidos == ((Ingresso) entidade).getId()) break;
                } else i += 1;
            }
        }
        for (int i = 0; i < ListadeIngressos.size(); i++){
            ListadeIngressos.get(i).setId(i + 1);
            if (((Ingresso) ListadeIngressos.get(i)).getFilme().getTitulo().equals(((Ingresso) entidade).getFilme().getTitulo())) {
                ((Ingresso) ListadeIngressos.get(i)).getFilme().setContagemdeIngressos(((Ingresso) entidade).getFilme().getContagemdeIngressos());
            }
        }
    }

    public void AtualizarArquivo(){
        if (ListadeIngressos.size() != 0) {
            if (!BancoDeDadosIngresso.exists()) {
                try {
                    BancoDeDadosIngresso.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            Gson gson = new Gson();
            String json = gson.toJson(ListadeIngressos);
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
            if (BancoDeDadosIngresso.exists()) BancoDeDadosIngresso.delete();
        }
    }

    public LinkedList<Entidade> CarregarArquivo(){
        if(!BancoDeDadosIngresso.exists()) return ListadeIngressos;
        String conteudoObjetos = null;
        try {conteudoObjetos = Files.readString(Paths.get(caminho));}
        catch (IOException exception) {exception.printStackTrace();}
        Gson gson = new Gson();
        Type tipoListadeIngressos = new TypeToken<LinkedList<Ingresso>>() {
        }.getType();
        ListadeIngressos = gson.fromJson(conteudoObjetos, tipoListadeIngressos);
        return ListadeIngressos;
    }

    public Ingresso BuscarId(int id) {
        for (Entidade cadaIngresso : ListadeIngressos) {
            if (cadaIngresso.getId() == id) {
                return (Ingresso) cadaIngresso;
            }
        }
        return null;
    }

    public Ingresso BuscarString(String string) {
        for (Entidade cadaIngresso : ListadeIngressos) {
            if (((Ingresso) cadaIngresso).getHorarioEntrada() == Integer.parseInt(string)) {
                return (Ingresso) cadaIngresso;
            }
        }
        return null;
    }
}