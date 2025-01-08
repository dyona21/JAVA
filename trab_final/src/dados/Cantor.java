package dados;
import java.util.*;
public class Cantor {
    private String nome;
    private List<Musica> musicas= new ArrayList<Musica>();
    private String redeSocial; //@ do instagram
    private String estilo;
    private int id_cantor;

    
    public int getId_cantor() {
        return id_cantor;
    }

    public void setId_cantor(int id_cantor) {
        this.id_cantor = id_cantor;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void cadastrarMusica(Musica musica) {
        musicas.add(musica);
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public int getTotalMusicas(){
        int x = musicas.size();
        return x;
    }

    public List<String> getMusicasString(){
        List<String> m = new ArrayList<String>();
        for(int i = 0; i < musicas.size(); i++){
            m.add(musicas.get(i).getNome());
        }
        return m;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cantor other = (Cantor) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (redeSocial == null) {
            if (other.redeSocial != null)
                return false;
        } else if (!redeSocial.equals(other.redeSocial))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cantor [Nome:" + nome + ", musicas:" + musicas.toString() + ", rede social:" + redeSocial + ", estilo:" + estilo.toString()
                + "]";
    }

}
