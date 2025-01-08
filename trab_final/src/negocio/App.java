package negocio;
import dados.*;
import persistencia.*;
import exepitions.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.io.File;
import java.io.IOException;
import java.util.*;
public class App {
    Scanner ler = new Scanner(System.in);
    private CantorDAO cantor_banco;
    private PlaylistDAO playlist_banco;
    private UsuarioDAO usuario_banco;     
    private MusicaDAO musicas_banco; 
    private static App instance = null;
    private List<Usuario> usu;
    private Usuario usua;
    private Playlist p;
    
    public void pegarUsuario(Usuario u){
        usua = u;
    }

    public static App getInstance() throws ClassNotFoundException, 
    SQLException, SelectionException{
        if(instance == null){
            instance = new App();
        }
        return instance;
    }


    public App() throws ClassNotFoundException, SQLException, SelectionException{
        Connection c = Conexao.getConexao();
        cantor_banco = CantorDAO.getInstance();
        playlist_banco = PlaylistDAO.getInstance();
        usuario_banco = UsuarioDAO.getInstance();
        musicas_banco = MusicaDAO.getInstance();
        usu = usuario_banco.selectAll();
    }
    
    public boolean login(String senha, String nomeUsu) throws SelectionException{
        List<Usuario> lista_usuarios = usuario_banco.selectAll();
        boolean correto = false;
        
        for(Usuario u : lista_usuarios){
            if(u.getSenha().equals(senha)){
                correto = true;
            }
        }

        return correto;
    }

    public void adicionarCantor(Cantor c) throws InsertException, SelectionException{
        cantor_banco.insert(c);
    }

    public void removerCantor(Cantor c) throws DeleteException{
        cantor_banco.deleteCantor_musica(c);
        cantor_banco.delete(c);
    }

    public void removerMusicaCantor(Cantor c, Musica m) throws SelectionException, DeleteException {
        cantor_banco.deleteMusica(c, m);    
    }

    public void adicionarMusicaCantor(Cantor c, Musica m) throws InsertException, SelectionException {
        cantor_banco.inserirMusica(c, m);   
    }         

    public void removerMusica(Musica m) throws DeleteException{
        musicas_banco.delete(m);
    }

    public void adicionarMusica(Musica m) throws InsertException, SelectionException{
        musicas_banco.insert(m);
    }

    public void removerPlaylist(Playlist p) throws DeleteException{
        playlist_banco.delete(p);
    }

    public void criarPlaylist(String nome) throws InsertException, SelectionException{
        Playlist p = new Playlist();
        p.setNome(nome);
        playlist_banco.insert(p, usua);
    }

    public void adicionarMusicaPlay(Musica m, Playlist p) throws InsertException, SelectionException{
        playlist_banco.inserir_musica(p, m);
    }

    public List<Musica> pegarMusicasPlaylist(Playlist p) throws SelectionException{
        return playlist_banco.pegar_musica_playlist(p);
    }

    public void removerMusicaPlay(Musica m, Playlist p) throws DeleteException{
        playlist_banco.deletar_musica(p, m);   
    }

    public void addMusicaFav(Musica m) throws InsertException, SelectionException{
        p = playlist_banco.select("Favorita");
        playlist_banco.inserir_musica(p, m);
    }

    public void removerMusicaFav(Musica m) throws InsertException, DeleteException, SelectionException{
        p = playlist_banco.select("Favorita");
        playlist_banco.deletar_musica(p, m);
    }

    public List<Musica> getMusicasFavoritas() throws InsertException, SelectionException{
        return playlist_banco.pegar_musica_playlist(p);
    }
    
    public List<Musica> getMusicasCadastradas() throws SelectionException {
        return musicas_banco.selectAll();
    }

    public List<Musica> getMusicasCantor(Cantor c) throws SelectionException {
        return cantor_banco.pegar_musica(c);
    }

    public List<Cantor> getCantoresCadastrados() throws SelectionException {
        return cantor_banco.selectAll();
    }
    
    public List<Playlist> getPlaylistCadastradas() throws SelectionException {
        return playlist_banco.pegar_playlist_usuario(usua);
    }

    public void upload(File file) throws IOException{
        int tamanhoArquivo = (int) file.length();
        usua.readMusicFile(file, tamanhoArquivo );
    }

    public void cadastrar_cantor_musica(Cantor c, Musica m) throws UpdateException, SelectionException{
        musicas_banco.cadastrar_cantor(m, c);
    }

    public void tocarPrevia(Musica m){
        m.tocarPrevia();
    }
    
    public void ordenarPlaylist(Playlist p){
        p.ordenarMusicasPorTitulo();
    }
}
