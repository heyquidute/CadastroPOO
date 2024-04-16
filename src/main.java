import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        PessoaFisicaRepo listaPessoasFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo listaPessoasJuridicaRepo = new PessoaJuridicaRepo();
        String tipoPessoa, prefixo;
        int opcao;

        System.out.println("==============================");
        System.out.println("1 - Incluir Pessoa");
        System.out.println("2 - Alterar Pessoa");
        System.out.println("3 - Excluir Pessoa");
        System.out.println("4 - Buscar pelo ID");
        System.out.println("5 - Exibir Todos");
        System.out.println("6 - Persistir Dados");
        System.out.println("7 - Recuperar Dados");
        System.out.println("0 - Finalizar Programa");
        System.out.println("==============================");

        do {
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao){

                case 1:
                    System.out.println("F - Pessoas Física | J - Pessoas Jurídica");
                    tipoPessoa = sc.nextLine();
                    if (tipoPessoa.equalsIgnoreCase("F")){
                        System.out.println("Digite o id da pessoa:");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.println("Insira os dados...");
                        System.out.println("Nome: ");
                        String nome = sc.nextLine();

                        System.out.println("CPF: ");
                        String cpf = sc.nextLine();

                        System.out.println("Idade: ");
                        int idade = Integer.parseInt(sc.nextLine());

                        PessoaFisica novaPessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        listaPessoasFisicaRepo.inserir(novaPessoaFisica);

                    } else if (tipoPessoa.equalsIgnoreCase("J")){
                        System.out.println("Digite o id da empresa:");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.println("Insira os dados...");
                        System.out.println("Nome da empresa: ");
                        String nome = sc.nextLine();

                        System.out.println("CNPJ: ");
                        String cnpj = sc.nextLine();

                        PessoaJuridica novaPessoaJuridica = new PessoaJuridica(id,nome, cnpj);
                        listaPessoasJuridicaRepo.inserir(novaPessoaJuridica);

                    } else {
                        System.out.println("Opção inválida");
                    }
                    break;

                case 2:
                    System.out.println("F - Pessoas Física | J - Pessoas Jurídica");
                    tipoPessoa = sc.nextLine();
                    if (tipoPessoa.equalsIgnoreCase("F")){
                        System.out.println("Digite o id da pessoa:");
                        int id = Integer.parseInt(sc.nextLine());
                        listaPessoasFisicaRepo.obter(id).exibir();

                        System.out.println("Entre com os novos dados:");
                        System.out.println("Nome: ");
                        String nome = sc.nextLine();

                        System.out.println("CPF: ");
                        String cpf = sc.nextLine();

                        System.out.println("Idade: ");
                        int idade = Integer.parseInt(sc.nextLine());

                        PessoaFisica novaPessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        listaPessoasFisicaRepo.alterar(novaPessoaFisica);
                    } else if (tipoPessoa.equalsIgnoreCase("J")) {
                        System.out.println("Digite o id da empresa:");
                        int id = Integer.parseInt(sc.nextLine());
                        listaPessoasJuridicaRepo.obter(id).exibir();

                        System.out.println("Entre com os novos dados:");
                        System.out.println("Nome da Empresa: ");
                        String nome = sc.nextLine();

                        System.out.println("CNPJ: ");
                        String cnpj = sc.nextLine();

                        PessoaJuridica novaPessoaJuridica = new PessoaJuridica(id, nome, cnpj);
                        listaPessoasJuridicaRepo.alterar(novaPessoaJuridica);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("F - Pessoas Física | J - Pessoas Jurídica");
                    tipoPessoa = sc.nextLine();
                    if (tipoPessoa.equalsIgnoreCase("F")){
                        System.out.println("Digite o id da pessoa:");
                        int id = Integer.parseInt(sc.nextLine());
                        listaPessoasFisicaRepo.excluir(id);
                        System.out.println("Pessoa Física do ID "+id+" excluído.");
                    } else if (tipoPessoa.equalsIgnoreCase("J")) {
                        System.out.println("Digite o id da empresa:");
                        int id = Integer.parseInt(sc.nextLine());
                        listaPessoasJuridicaRepo.excluir(id);
                        System.out.println("Pessoa Jurídica do ID "+id+" excluído.");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    System.out.println("F - Pessoas Física | J - Pessoas Jurídica");
                    tipoPessoa = sc.nextLine();
                    if (tipoPessoa.equalsIgnoreCase("F")){
                        System.out.println("Digite o id da pessoa:");
                        int id = Integer.parseInt(sc.nextLine());
                        listaPessoasFisicaRepo.obter(id).exibir();
                    } else if (tipoPessoa.equalsIgnoreCase("J")) {
                        System.out.println("Digite o id da empresa:");
                        int id = Integer.parseInt(sc.nextLine());
                        listaPessoasJuridicaRepo.obter(id).exibir();
                    } else {
                        System.out.println("Opção inválida");
                    }
                    break;

                case 5:
                    System.out.println("F - Pessoas Física | J - Pessoas Jurídica");
                    tipoPessoa = sc.nextLine();
                    if (tipoPessoa.equalsIgnoreCase("F")) {
                        System.out.println("Lista de Pessoas Fisicas:");
                        for (int i=0; i<listaPessoasFisicaRepo.obterTodos().size(); i++ ) {
                            PessoaFisica pessoaFisica = listaPessoasFisicaRepo.obterTodos().get(i);
                            int id = pessoaFisica.getId();
                            listaPessoasFisicaRepo.obter(id).exibir();
                            System.out.println("---------------------------");
                        }
                    } else if (tipoPessoa.equalsIgnoreCase("J")) {
                        System.out.println("Lista de Pessoas Jurídicas:");
                        for (int i=0; i<listaPessoasJuridicaRepo.obterTodos().size(); i++){
                            PessoaJuridica pessoaJuridica = listaPessoasJuridicaRepo.obterTodos().get(i);
                            int id = pessoaJuridica.getId();
                            listaPessoasJuridicaRepo.obter(id).exibir();
                            System.out.println("---------------------------");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 6:
                    try {
                        System.out.println("Qual prefixo do arquivo?");
                        prefixo = sc.nextLine();
                        listaPessoasFisicaRepo.persistir(prefixo+".fisica.bin");
                        listaPessoasJuridicaRepo.persistir(prefixo+".juridica.bin");
                        System.out.println("Dados salvos.");
                    } catch (IOException e){
                        System.err.println("Erro ao salvar dados.");
                    }
                    break;

                case 7:
                   try {
                       System.out.println("Qual prefixo do arquivo?");
                       prefixo = sc.nextLine();
                       listaPessoasFisicaRepo.recuperar(prefixo+".fisica.bin");
                       listaPessoasJuridicaRepo.recuperar(prefixo+".juridica.bin");
                       System.out.println("Dados recuperados.");
                   } catch (IOException | ClassNotFoundException e){
                       System.err.println("Erro ao recuperar dados.");
                   }
                    break;

                case 0:
                    System.out.println("Finalizando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }

}
