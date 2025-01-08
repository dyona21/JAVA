package dados;
import java.util.*;
public class Playlist {
    private int id_playlist;
    private String nome;
    private List<Musica> musicas = new ArrayList<Musica>();

   

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public boolean contemMusica(Musica musica) {
        return musicas.contains(musica);
    }

    public void removerMusica(Musica musica) {
        musicas.remove(musica);
    }

    public int getNumeroTotalMusicas() {
        return musicas.size();
    }

    public List<String> getNomeMusicas() {
        List<String> m = new ArrayList<>();
        for(int i = 0; i < musicas.size(); i++){
            m.add(musicas.get(i).getNome());
        }
        return m;
    }

    public void ordenarMusicasPorTitulo() {
        musicas.sort(Comparator.comparing(Musica::getTitulo));
    }

    public boolean estaVazia() {
        return musicas.isEmpty();
    }

    public int getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(int id_playlist) {
        this.id_playlist = id_playlist;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }    
}
