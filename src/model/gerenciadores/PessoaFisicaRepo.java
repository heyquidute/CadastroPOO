package model.gerenciadores;

import model.entidades.PessoaFisica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();
    public void inserir(PessoaFisica pessoaFisica){
        pessoasFisicas.add(pessoaFisica);
    }
    public void alterar(PessoaFisica pessoaFisica){
        for(int i=0; i<pessoasFisicas.size(); i++){
            if(pessoasFisicas.get(i).getId()==pessoaFisica.getId()){
                pessoasFisicas.set(i, pessoaFisica);
                break;
            }
        }
    }
    public void excluir(int id){
        pessoasFisicas.removeIf(pessoaFisica -> pessoaFisica.getId() == id);
    }
    public PessoaFisica obter(int id){
        for (PessoaFisica pessoaFisica : pessoasFisicas){
            if (pessoaFisica.getId() == id){
                return pessoaFisica;
            }
        }
        return null;
    }
    public List<PessoaFisica> obterTodos(){
        return pessoasFisicas;
    }
    public void persistir(String nomeArquivo) throws IOException {
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(nomeArquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                ){
            objectOutputStream.writeObject(pessoasFisicas);
        }
    }
    public List<PessoaFisica> recuperar (String nomeArquivo) throws IOException, ClassNotFoundException{
        try(
                FileInputStream fileInputStream = new FileInputStream(nomeArquivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
                ){
            return (List<PessoaFisica>) objectInputStream.readObject();
        }
    }
}
