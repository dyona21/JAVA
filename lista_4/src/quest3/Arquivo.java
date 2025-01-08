package quest3;

public abstract class Arquivo {
    protected String nome;
    protected String extensao;

    public Arquivo(String nome, String extensao) throws NomeInvalidoException {
        if (!validarNome(nome)) {
            throw new NomeInvalidoException("Nome do arquivo inválido: " + nome);
        }
        this.nome = nome;
        this.extensao = extensao;
    }

    // Método para validar o nome do arquivo
    private boolean validarNome(String nome) {
        // Verificar se o nome está dentro dos limites e não contém caracteres inválidos
        return nome.length() >= 10 && nome.length() <= 256 &&
               nome.matches("[^\\n\\[\\]()'\"]+");
    }

    // Método abstrato para sobrescrita do toString()
    public abstract String toString();
}
