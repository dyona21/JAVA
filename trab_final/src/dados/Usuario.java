package dados;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Usuario {
    private String nomeUsuario;
    private int id_usuario;
    private String senha;
    private String email;
    private List<Musica> musicFav = new ArrayList<Musica>();
    private List<List<byte[]>> uploadMusicas = new ArrayList<List<byte[]>>();
    private List<Playlist> suasPlaylist = new ArrayList<Playlist>();
    private Scanner ler = new Scanner(System.in);
    
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    public void adicionarMusicaFav(Musica musica) {
        musicFav.add(musica);
    }

    public void readMusicFile(File file, int blockSize) throws IOException {
        List<byte[]> byteBlocks = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[blockSize];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                if (bytesRead < blockSize) {
                    byte[] smallerBuffer = new byte[bytesRead];
                    System.arraycopy(buffer, 0, smallerBuffer, 0, bytesRead);
                    byteBlocks.add(smallerBuffer);
                } else {
                    byteBlocks.add(buffer.clone());
                }
            }
        }

        uploadMusicas.add(byteBlocks);
    }


    public void criarPlaylist() {
        String nomePlaylist;
        System.out.println("Nome da playlist:");
        nomePlaylist = ler.nextLine();
        Playlist p = new Playlist();
        p.setNome(nomePlaylist);
        
        suasPlaylist.add(p);
    }

    public void adicionarMusicaPlaylist(String nomePlaylist, Musica musica) {
        for (Playlist p : suasPlaylist) {
            if (p.getNome().equals(nomePlaylist)) {
                p.adicionarMusica(musica);
                break; 
            }
        }
    }

    public void removerMusicaFav(Musica musica) {
        musicFav.remove(musica);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Musica> getMusicFav() {
        return musicFav;
    }

    public void setMusicFav(Musica musicsFav) {
        musicFav.add(musicsFav);
    }

    public List<Playlist> getSuasPlaylist() {
        return suasPlaylist;
    }

    public void setSuasPlaylist(Playlist suasPlaylists) {
        suasPlaylist.add(suasPlaylists);
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    @Override
    public String toString() {
        return "Usuario [Nome do usuário:" + nomeUsuario + ", senha:" + senha + ", email:" + email + ", musicas favoritas:"
                + musicFav.toString() + ", suas playlist:" + suasPlaylist.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (nomeUsuario == null) {
            if (other.nomeUsuario != null)
                return false;
        } else if (!nomeUsuario.equals(other.nomeUsuario))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        return true;
    }
}
