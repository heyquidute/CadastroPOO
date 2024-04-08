import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Instanciar repositórios de pessoas físicas (repo1, repo2).
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

        // Adicionar duas pessoas físicas, utilizando o construtor completo.
        repo1.inserir(new PessoaFisica(1,"Ana", "11111111111", 25));
        repo1.inserir(new PessoaFisica(2,"Carlos", "22222222222", 52));

        // Invocar o método de persistência em repo1, fornecendo um nome de arquivo fixo.
        repo1.persistir("pessoasFisicas.dat");
        System.out.println("Dados de Pessoa Fisica Armazenado.");

        //Invocar o método de recuperação em repo2.
        List<PessoaFisica> listaPessoasRepo2 = repo2.recuperar("pessoasFisicas.dat");
        System.out.println("Dados de Pessoa Fisica Recuperado.");

        //Exibir os dados de todas as pessoas físicas recuperadas.
        for(PessoaFisica pessoaFisica : listaPessoasRepo2) {
            System.out.println(pessoaFisica.exibir());
        }

        //Mesma coisa com 2 repositórios de PessoaJuridica
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

        repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33333333333333"));
        repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44444444444444"));

        repo3.persistir("pessoasJuridicas.dat");
        System.out.println("Dados de Pessoa Juridica Armazenados");

        List<PessoaJuridica> listaPessoasRepo4 = repo4.recuperar("pessoasJuridicas.dat");
        System.out.println("Dados de Pessoas Juridica Recuperado");

        for (PessoaJuridica pessoaJuridica : listaPessoasRepo4){
            System.out.println(pessoaJuridica.exibir());
        }
    }
}
