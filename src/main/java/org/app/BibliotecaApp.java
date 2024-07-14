package org.app;

import Services.BibliotecaServices;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BibliotecaApp {
    public static void main(String[] args) {
        BibliotecaServices services = new BibliotecaServices();

        System.out.println("===================================");
        System.out.println("Bem-vindo ao Biblioteca 2025!");
        System.out.println("===================================");


        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSelecione a operação desejada:");
            System.out.println("===================================");
            System.out.println("1 - Inserir usuário");
            System.out.println("2 - Visualizar usuários");
            System.out.println("3 - Visualizar usuário por ID");
            System.out.println("4 - Mudar status de um usuário");
            System.out.println("===================================");
            System.out.println("5 - Inserir livro");
            System.out.println("6 - Visualizar livros");
            System.out.println("7 - Visualizar livro por ID");
            System.out.println("===================================");
            System.out.println("8 - Realizar empréstimo");
            System.out.println("9 - Visualizar empréstimos");

            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Insira o Id: "); // Integer id, String nome, String email, String senha
                    Integer idUsuario = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha remanescente

                    System.out.println("Insira o nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Insira o email: ");
                    String email = scanner.nextLine();

                    System.out.println("Insira a senha: ");
                    String senha = scanner.nextLine();

                    services.inserirUsuario(idUsuario, nome, email, senha);
                    break;
                case 2:
                    services.vizualizarUsuarios();
                    break;
                case 3:
                    System.out.println("Digite o Id do usuário buscado: ");
                    Integer idUsuarioBuscado = scanner.nextInt();

                    services.vizualizarUsuarioPorId(idUsuarioBuscado);
                    break;
                case 4:
                    System.out.println("Digite o Id do usuário a ser alterado: ");
                    Integer idUsuarioASerAlterado = scanner.nextInt();

                    services.mudarStatusUsuario(idUsuarioASerAlterado);
                    break;
                case 5:
                    System.out.println("Insira o Id: "); // Integer id, String nome, String email, String senha
                    Integer idLivro = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha remanescente

                    System.out.println("Insira o título do livro: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Insira o nome do autor: ");
                    String autor = scanner.nextLine();

                    System.out.println("Insira o ISBN: ");
                    Integer isbn = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Insira a quantidade de cópias disponíveis: ");
                    Integer numeroCopias = scanner.nextInt();

                    services.inserirLivro(idLivro, titulo, autor, isbn, numeroCopias);
                    break;
                case 6:
                    services.vizualizarTodosOsLivros();
                    break;
                case 7:
                    System.out.println("Digite o Id do livro: ");
                    Integer idLivroBuscado = scanner.nextInt();

                    services.vizualizarLivroPorId(idLivroBuscado);
                    break;
                case 8:
                    System.out.println("Insira o Id do livro a ser emprestado: ");
                    Integer idLivroAEmprestar = scanner.nextInt();

                    System.out.println("Insira o Id do usuário a receber o livro: ");
                    Integer idUsuarioAReceber = scanner.nextInt();

                    services.realizarEmprestimo(idUsuarioAReceber, idLivroAEmprestar);
                    break;
                case 9:
                    services.vizualizarEmprestimos();
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso sistema. Até mais!");
                    continuar = false;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        }
}