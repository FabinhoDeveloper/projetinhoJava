package Services;

import Models.Emprestimo;
import Models.Livro;
import Models.Usuario;
import Repository.BibliotecaRepository;

import java.util.List;

public class BibliotecaServices {
    BibliotecaRepository repositorio = new BibliotecaRepository();

    // Métodos do usuário

    public void inserirUsuario (int id, String nome, String email, String senha) {
        repositorio.inserirUsuario(new Usuario(id, nome, email, senha));
        System.out.println("Usuário inserido com sucesso!");
    }

    public void vizualizarUsuarios () {
        List<Usuario> listaDeUsuarios = repositorio.obterUsuarios();

        if (listaDeUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado ou cadastrado!");
            return;
        }

        for (Usuario u : listaDeUsuarios) {
            System.out.println("===================================");
            System.out.println("Nome do usuário: " + u.getNome() + "\nE-mail: " + u.getEmail()  + "\nEstá ativo: " + u.isEstaAtivo());
        }
    }

    public void vizualizarUsuarioPorId (Integer id) {
        Usuario usuario = repositorio.obterUsuarioPorId(id);

        if (usuario != null) {
            System.out.println("Usuário: " + usuario.getNome() + "\nEmail: " + usuario.getEmail() + "\nEstá ativo: " + usuario.isEstaAtivo());
        } else {
            System.out.println("Usuário não encontrado!");
        }

    }

    public void mudarStatusUsuario (Integer id) {
        Usuario usuario = repositorio.obterUsuarioPorId(id);
        usuario.setEstaAtivo();

        System.out.println("Novo status do usuário " + usuario.getNome() + ": " + usuario.isEstaAtivo());
    }

    // Métodos do livro

    public void inserirLivro(Integer id, String titulo, String autor, Integer isbn, Integer numeroCopias) {
        Livro livro = new Livro(id, titulo, autor, isbn, numeroCopias);
        repositorio.inserirLivro(livro);
        System.out.println("Livro inserido com sucesso!");
    }

    public void vizualizarTodosOsLivros () {
        List<Livro> listaDeLivros = repositorio.obterLivros();

        if (listaDeLivros.isEmpty()) {
            System.out.println("Nenhum livro encontrado!");
            return;
        }

        for (Livro l : listaDeLivros) {
            System.out.println("===================================");
            System.out.println("Livro: " + l.getTitulo() + "\nAutor: " + l.getAutor() + "\nCópias disponíveis: " + l.getNumeroCopias());
        }

    }

    public void vizualizarLivroPorId (Integer id) {
        Livro livro = repositorio.obterLivroPorId(id);

        if (livro != null) {
            System.out.println("Livro: " + livro.getTitulo() + "\nAutor: " + livro.getAutor());
        } else {
            System.out.println("Nenhum livro encontrado!");
        }
    }

    // Métodos do empréstimo

    public void realizarEmprestimo (Integer idUsuario, Integer idLivro) {
        Livro livro = null;
        Usuario usuario = null;
        Emprestimo emprestimo;


        for (Livro l : repositorio.obterLivros()) {
            if (l.getId().equals(idLivro)) {
                livro = l;
                break;
            }
        }

        for (Usuario u : repositorio.obterUsuarios()) {
            if (u.getId().equals(idUsuario)) {
                usuario = u;
                break;
            }
        }

        if (livro != null && usuario != null) {

            if (livro.getNumeroCopias() > 0) {

                if (usuario.isEstaAtivo()) {
                    livro.setNumeroCopias(livro.getNumeroCopias() - 1);
                    emprestimo = new Emprestimo(livro, usuario);
                    repositorio.inserirEmprestimo(emprestimo);
                    System.out.println("Empréstimo realizado com sucesso!");
                } else {
                    System.out.println("O usuário não pôde realizar o empréstimo, pois está inativo!");
                }

            } else {
                System.out.println("Não há cópias disponíveis!");
            }

        } else {
            if (livro == null) {
                System.out.println("Livro não encontrado!");
            }
            if (usuario == null) {
                System.out.println("Usuário não encontrado!");
            }

        }
    }

    public void vizualizarEmprestimos () {
        List<Emprestimo> listaDeEmprestimos = repositorio.obterEmprestimos();

        if (listaDeEmprestimos.isEmpty()) {
            System.out.println("Não há empréstimos realizados!");
            return;
        }

        for (Emprestimo e : listaDeEmprestimos) {
            System.out.println("===================================");
            System.out.println("Livro emprestado: " + e.getLivro().getTitulo() + "\nUsuário: " + e.getUsuario().getNome());
        }
    }

}