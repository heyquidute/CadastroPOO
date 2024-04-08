package model.gerenciadores;

import model.entidades.PessoaJuridica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
    public void inserir(PessoaJuridica pessoaJuridica){
        pessoasJuridicas.add(pessoaJuridica);
    }
    public void alterar(PessoaJuridica pessoaJuridica){
        for(int i=0; i<pessoasJuridicas.size(); i++){
            if (pessoasJuridicas.get(i).getId()==pessoaJuridica.getId()){
                pessoasJuridicas.set(i, pessoaJuridica);
                break;
            }
        }
    }
    public void excluir(int id){
        pessoasJuridicas.removeIf(pessoaJuridica -> pessoaJuridica.getId() == id);
    }
    public PessoaJuridica obter (int id){
        for(PessoaJuridica pessoaJuridica : pessoasJuridicas){
            if (pessoaJuridica.getId()==id){
                return pessoaJuridica;
            }
        }
        return null;
    }
    public List<PessoaJuridica> obterTodos(){
        return pessoasJuridicas;
    }
    public void persistir(String nomeArquivo) throws IOException {
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(nomeArquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ){
            objectOutputStream.writeObject(pessoasJuridicas);
        }
    }
    public List<PessoaJuridica> recuperar (String nomeArquivo) throws IOException, ClassNotFoundException{
        try(
                FileInputStream fileInputStream = new FileInputStream(nomeArquivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ){
            return (List<PessoaJuridica>) objectInputStream.readObject();
        }
    }
}
