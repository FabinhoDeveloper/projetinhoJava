package Services;

import Models.Livro;
import Models.Usuario;
import Repository.BibliotecaRepository;

public class BibliotecaServices {
    BibliotecaRepository repositorio = new BibliotecaRepository();

    public void inserirUsuario (int id, String nome, String email, String senha) {
        repositorio.inserirUsuario(new Usuario(id, nome, email, senha));
    }

    public void realizarEmprestimo () {

    }


}