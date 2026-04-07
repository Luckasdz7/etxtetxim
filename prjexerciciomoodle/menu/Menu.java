/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prjexerciciomoodle.menu;
import com.mycompany.prjexerciciomoodle.models.Pessoa;
import com.mycompany.prjexerciciomoodle.bo.PessoaBO;
import com.mycompany.prjexerciciomoodle.models.Veiculo;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author user
 */
public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static PessoaBO pessoaBO = new PessoaBO();

    public static void mostrarMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Salvar nova Pessoa");
            System.out.println("2. Listar todas as Pessoas e seus Veiculos");
            System.out.println("3. Listar Pessoas e seus Veiculos, Por CPF");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> salvarPessoaComVeiculos();
                case 2 -> listarPessoas();
                case 3 -> {
                    System.out.print("Digite o CPF:");
                    String cpf = scanner.nextLine();
                    listarPessoas(cpf);
                }
                case 4 -> System.out.println("Saindo do programa...");
                default -> System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void salvarPessoaComVeiculos() {
        System.out.println("\n--- Cadastro de Pessoa ---");
        Pessoa pessoa = new Pessoa();
        pessoa.setId(UUID.randomUUID());

        System.out.print("Nome: ");
        pessoa.setNome(scanner.nextLine());
        System.out.print("CPF: ");
        pessoa.setCpf(scanner.nextLine());
        System.out.print("Data de Nascimento: ");
        pessoa.setData_nascimento(scanner.nextLine());

        String resposta;
        List<Veiculo> veiculos = new LinkedList<>();

        do {
            System.out.print("Deseja adicionar um veiculo para " + pessoa.getNome() + "? (s/n): ");
            resposta = scanner.nextLine().toLowerCase();
            if (resposta.equals("s")) {
                veiculos.add(lerDadosVeiculo());
            }
        } while (resposta.equals("s"));

        pessoa.setLstVeiculos(veiculos);
        pessoaBO.salvarPessoa(pessoa);
    }

    private static Veiculo lerDadosVeiculo() {
        System.out.println("\n --- Cadastro de Veiculo ---");
        Veiculo veiculo = new Veiculo();
        veiculo.setId(UUID.randomUUID());

        System.out.print("Nome: ");
        veiculo.setNome(scanner.nextLine());
        System.out.print("Marca: ");
        veiculo.setMarca(scanner.nextLine());
        System.out.print("Modelo: ");
        veiculo.setModelo(scanner.nextLine());
        System.out.print("Placa: ");
        veiculo.setPlaca(scanner.nextLine());
        System.out.print("Ano: ");
        veiculo.setAno(scanner.nextInt());
        scanner.nextLine();

        return veiculo;
    }

    private static void listarPessoas() {
        List<Pessoa> pessoas = pessoaBO.buscarPessoa();
        if (pessoas != null) {
            pessoaBO.mostrarDados(pessoas);
        }
    }

    private static void listarPessoas(String cpf) {
        Pessoa p = pessoaBO.buscarPessoa(cpf);
        if (p != null) {
            pessoaBO.mostrarDados(p);
        }
    }
}