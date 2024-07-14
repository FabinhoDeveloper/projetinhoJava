package Repository;

import Models.Emprestimo;
import Models.Livro;
import Models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaRepository {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public BibliotecaRepository() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    // Métodos do livro

    public void inserirLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> obterLivros() {
        return livros;
    }

    public Livro obterLivroPorId(Integer id) {
        for (Livro l : livros) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    // Métodos do usuário

    public void inserirUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> obterUsuarios() {
        return usuarios;
    }

    public Usuario obterUsuarioPorId(Integer id) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }

        return null;
    }

    // Métodos do empréstimo

    public void inserirEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public List<Emprestimo> obterEmprestimos() {
        return emprestimos;
    }

    public List<Emprestimo> obterEmprestimosPorUsuario (Usuario usuario) {
        List<Emprestimo> emprestimosPorUsuario = new ArrayList<>();

        for (Emprestimo e : emprestimos) {
            if (e.getUsuario() == usuario) {
                emprestimosPorUsuario.add(e);
            }
        }

        if (!emprestimosPorUsuario.isEmpty()) {
            return emprestimosPorUsuario;
        } else {
            return null;
        }
    }

    public List<Emprestimo> obterEmprestimoPorLivro (String nomeDoLivro) {
        List<Emprestimo> emprestimosPorLivro = new ArrayList<>();

        for (Emprestimo e : emprestimos) {
            if (e.getLivro().getTitulo().equals(nomeDoLivro)) {
                emprestimosPorLivro.add(e);
            }
        }

        if (!emprestimosPorLivro.isEmpty()) {
            return emprestimosPorLivro;
        } else {
            return null;
        }
    }
}
