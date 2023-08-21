package br.com.biblioteca.itens;

public class Livro extends Itens{
    private String autor;
    private String editora;
    private int numeroPaginas;
    
    
    

    public Livro() {
    }

    public Livro(String autor, String editora, int numeroPaginas) {
        this.autor = autor;
        this.editora = editora;
        this.numeroPaginas = numeroPaginas;
    }

    public Livro(String autor, String editora, int numeroPaginas, int codigo, String titulo) {
        super(codigo, titulo);
        this.autor = autor;
        this.editora = editora;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String toString(){
        return super.toString() +"\n Titulo:" +getTitulo() + "\n Autor: "+ getAutor() + "\n a sua editora é:" + getEditora()+"\n numero de paginas: " + getNumeroPaginas()+"";
    }

  
}




