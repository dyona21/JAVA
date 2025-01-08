public class Livro {
    private String titulo;
    private Autor autor;
    private int anoPublicacao;
    private boolean disponivel;

    public Livro(String titulo, Autor autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true; // Por padrão, o livro está disponível
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado: " + titulo);
        } else {
            System.out.println("Livro não disponível para empréstimo no momento.");
        }
    }

    public void devolver() {
        disponivel = true;
        System.out.println("Livro devolvido: " + titulo);
    }
}
