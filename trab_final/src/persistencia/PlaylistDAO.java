package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Musica;
import dados.Playlist;
import dados.Usuario;
import exepitions.DeleteException;
import exepitions.InsertException;
import exepitions.SelectionException;
import exepitions.UpdateException;

public class PlaylistDAO {
    private static PlaylistDAO instance = null;
    private PreparedStatement selectNewID;
    private PreparedStatement selectNewID_playlist_musica;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement inserir_musica;
    private PreparedStatement remover_musica;
    private PreparedStatement pegar_musica_playlist;
    private PreparedStatement pegar_musicas_tabela;
    private PreparedStatement pegar_playlist_usuario;

    public static PlaylistDAO getInstance() throws ClassNotFoundException, SQLException, SelectionException {
        if (instance == null) {
            instance = new PlaylistDAO();
        }
        return instance;
    }

    private PlaylistDAO() throws ClassNotFoundException, SQLException, SelectionException {
        Connection conexao = Conexao.getConexao();
        selectNewID = conexao.prepareStatement("select nextval('id_playlist')");
        selectNewID_playlist_musica = conexao.prepareStatement("select nextval('id_playlist_musica')");
        insert = conexao.prepareStatement("insert into playlist (id, nome, id_usuario) values (?, ?, ?)");
        select = conexao.prepareStatement("select * from playlist where nome = ?");
        pegar_playlist_usuario = conexao.prepareStatement("select * from playlist where id_usuario = ?");
        selectAll = conexao.prepareStatement("select * from playlist");
        update = conexao.prepareStatement("update playlist set nome = ? where id = ?");
        delete = conexao.prepareStatement("delete from playlist where id = ?");
        pegar_musicas_tabela = conexao.prepareStatement("select * from musica where id = ?");
        inserir_musica = conexao.prepareStatement("insert into playlist_musica (id, id_playlist, id_musica) values (?, ?, ?)");
        pegar_musica_playlist = conexao.prepareStatement("select * from playlist_musica where id_playlist = ?");
        remover_musica = conexao.prepareStatement("delete from playlist_musica where id_playlist = ? and id_musica = ?");
        
    }

    private int selectNewId() throws SelectionException {
        try {
            ResultSet rs = selectNewID.executeQuery();
            if (rs.next()) {
                int newId = rs.getInt(1);
                System.out.println("Novo ID gerado para playlist: " + newId); // Log para depuração
                return newId;
            } else {
                throw new SelectionException("Erro ao buscar novo id na tabela playlist: Nenhum resultado retornado.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Depuração
            throw new SelectionException("Erro ao buscar novo id na tabela playlist");
        }
    }

    private int selectNewIdPlaylistMusica() throws SelectionException {
        try {
            ResultSet rs = selectNewID_playlist_musica.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar novo id na tabela cantor_musica");
        }
        return 0;
    }

    public void insert(Playlist p, Usuario u) throws InsertException, SelectionException {
        try {
            int newId = selectNewId();
            p.setId_playlist(newId); // Atualiza o ID da playlist com o novo ID gerado
            insert.setInt(1, p.getId_playlist());
            insert.setString(2, p.getNome());
            insert.setInt(3, u.getId_usuario());
            insert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Depuração
            throw new InsertException("Erro ao inserir playlist.");
        }
    }

    public Playlist select(String mensagem) throws SelectionException {
        try {
            Playlist pl = new Playlist();
            select.setString(1, mensagem);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                pl.setId_playlist(rs.getInt(1));
                pl.setNome(rs.getString(2));
            }
            return pl;
        } catch (SQLException e) {
            e.printStackTrace(); // Depuração
            throw new SelectionException("Erro ao buscar playlist.");
        }
        
    }

    public void update(Playlist p) throws UpdateException {
        try {
            update.setString(1, p.getNome());
            update.setInt(2, p.getId_playlist());
            update.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Depuração
            throw new UpdateException("Erro ao atualizar playlist.");
        }
    }

    public void delete(Playlist p) throws DeleteException {
        try {
            delete.setInt(1, p.getId_playlist());
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Depuração
            throw new DeleteException("Erro ao deletar playlist.", e);
        }
    }

    public List<Playlist> selectAll() throws SelectionException {
        try {
            List<Playlist> play = new ArrayList<Playlist>();
            ResultSet rs = selectAll.executeQuery();
            while (rs.next()) {
                Playlist pl = new Playlist();
                pl.setId_playlist(rs.getInt(1));
                pl.setNome(rs.getString(2));
                play.add(pl);
            }
            return play;
        } catch (SQLException e) {
            e.printStackTrace(); // Depuração
            throw new SelectionException("Erro ao buscar playlists.");
        }
    }

    public void deletar_musica(Playlist p, Musica mu) throws DeleteException {
        try {
            remover_musica.setInt(1, p.getId_playlist());
            remover_musica.setInt(2, mu.getId_musica());
            remover_musica.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Depuração
            throw new DeleteException("Erro ao deletar música da playlist.", e);
        }
    }

    public void inserir_musica(Playlist p, Musica mu) throws InsertException, SelectionException {
        try {
            inserir_musica.setInt(1, selectNewIdPlaylistMusica());
            inserir_musica.setInt(2, p.getId_playlist());
            inserir_musica.setInt(3, mu.getId_musica());
            inserir_musica.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Depuração
            throw new InsertException("Erro ao inserir música na playlist.");
        }
    }

    public List<Musica> pegar_musica_playlist(Playlist p) throws SelectionException {
        try {
            List<Musica> musi = new ArrayList<>();
            pegar_musica_playlist.setInt(1, p.getId_playlist());
            try (ResultSet rs = pegar_musica_playlist.executeQuery()) {
                while (rs.next()) {
                    Musica m = new Musica();
                    m.setId_musica(rs.getInt("id_musica"));
                    musi.add(m);
                }
            }
            System.out.println("Chegou");
    
            List<Musica> musicas = new ArrayList<>();
            for (Musica m : musi) {
                pegar_musicas_tabela.setInt(1, m.getId_musica());
                try (ResultSet rs2 = pegar_musicas_tabela.executeQuery()) {
                    while (rs2.next()) {
                        Musica mu = new Musica();
                        mu.setId_musica(rs2.getInt(1));
                        mu.setNome(rs2.getString(2));
                        mu.setEstilo(rs2.getString(3));
                        mu.setAnoLancamento(rs2.getInt(4));
                        mu.setDuracao(rs2.getInt(5));
                        musicas.add(mu);
                    }
                }
            }
            System.out.println("ChegouAQQQQQQQQQQ");
            return musicas;
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar músicas da playlist.");
        }
    }
    

    public List<Playlist> pegar_playlist_usuario(Usuario us) throws SelectionException {
        try {
            List<Playlist> playlists = new ArrayList<>();
            // Configurando o parâmetro da consulta
            pegar_playlist_usuario.setInt(1, us.getId_usuario());
            
            // Executando a consulta e processando o resultado
            ResultSet rs = pegar_playlist_usuario.executeQuery();
            while (rs.next()) {
                Playlist playlist = new Playlist();
                playlist.setId_playlist(rs.getInt("id"));
                playlist.setNome(rs.getString("nome"));
                playlists.add(playlist);
            }
            
            return playlists;
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar playlists do usuário.");
        }
    }

    public void remover_musica(Playlist p, Musica m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover_musica'");
    }
    
}
