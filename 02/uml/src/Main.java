public class Main {
    public static void main(String[] args) {
        Autor autor1 = new Autor("Machado de Assis", "Brasileiro");
        Livro livro1 = new Livro("Dom Casmurro", autor1, 1899);

        Usuario usuario1 = new Usuario("João", 25, "Rua A, 123");
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarUsuario(usuario1);

        livro1.emprestar();
        livro1.devolver();
    }
}
