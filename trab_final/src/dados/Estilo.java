package dados;
public class Estilo {
    private String nome;
    private int idEstilo; 
    

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estilo other = (Estilo) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (idEstilo != other.idEstilo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estilo [Nome do estilo:" + nome + "]";
    }
}
