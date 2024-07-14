package Models;

public class Livro {
    private Integer id;
    private String titulo;
    private String autor;
    private Integer isbn;
    private Integer numeroCopias;

    public Livro(Integer id, String titulo, String autor, Integer isbn, Integer numeroCopias) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numeroCopias = numeroCopias;
    }

    public Livro (Livro l) {
        this.id = l.id;
        this.titulo = l.titulo;
        this.autor = l.autor;
        this.isbn = l.isbn;
        this.numeroCopias = l.numeroCopias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(Integer numeroCopias) {
        this.numeroCopias = numeroCopias;
    }
}
