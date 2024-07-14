package Models;

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private boolean estaAtivo;

    public Usuario(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.estaAtivo = true;
    }

    public Usuario(Usuario u) {
        this.id = u.id;
        this.nome = u.nome;
        this.email = u.email;
        this.senha = u.senha;
        this.estaAtivo = u.estaAtivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo() {
        if (this.estaAtivo) {
            this.estaAtivo = false;
        } else {
            this.estaAtivo = true;
        }
    }
}
