package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Cantor;
import dados.Musica;
import exepitions.DeleteException;
import exepitions.InsertException;
import exepitions.SelectionException;
import exepitions.UpdateException;

public class MusicaDAO {
    private static MusicaDAO instance = null;
    private PreparedStatement selectNewID;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement insert_cantor_musica;
    private PreparedStatement selectNewID_cantor_musica;
    

    public static MusicaDAO getInstance() throws ClassNotFoundException, SQLException, SelectionException {
        if (instance == null) {
            instance = new MusicaDAO();
        }
        return instance;
    }

    private MusicaDAO() throws ClassNotFoundException, SQLException, SelectionException {
        Connection conexao = Conexao.getConexao();
        selectNewID = conexao.prepareStatement("select nextval('id_musica')");
        selectNewID_cantor_musica = conexao.prepareStatement("SELECT nextval('id_cantor_musica')");
        insert = conexao.prepareStatement("insert into musica (id, nome, estilo, ano_lancamento, duracao) values (?, ?, ?, ?, ?)");
        select = conexao.prepareStatement("select * from musica where id = ?");
        selectAll = conexao.prepareStatement("select * from musica");
        update = conexao.prepareStatement("update musica set nome = ?, estilo = ?, ano_lancamento = ?, duracao = ? where id = ?");
        delete = conexao.prepareStatement("delete from musica where id = ?");
        insert_cantor_musica = conexao.prepareStatement("insert into cantor_musica (id, id_cantor, id_musica) values (?, ?, ?)");
    }

    private int selectNewId() throws SelectionException {
        try {
            ResultSet rs = selectNewID.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar novo id na tabela música");
        }
        return 0;
    }
    
    private int selectNewIdCantorMusica() throws SelectionException {
        try {
            ResultSet rs = selectNewID_cantor_musica.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar novo id na tabela cantor_musica");
        }
        return 0;
    }

    public void insert(Musica mu) throws InsertException, SelectionException {
        try {
            int id = selectNewId();
            mu.setId_musica(id);
            insert.setInt(1, mu.getId_musica());
            insert.setString(2, mu.getNome());
            insert.setString(3, mu.getEstilo());
            insert.setInt(4, mu.getAnoLancamento());
            insert.setInt(5, mu.getDuracao());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir música.");
        }
    }

    public Musica select(int musica) throws SelectionException {
        try {
            select.setInt(1, musica);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                Musica mu = new Musica();
                mu.setId_musica(rs.getInt(1));
                mu.setNome(rs.getString(2));
                mu.setEstilo(rs.getString(3));
                mu.setAnoLancamento(rs.getInt(4));
                mu.setDuracao(rs.getInt(5));
                return mu;
            }
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar música.");
        }
        return null;
    }

    public void update(Musica mu) throws UpdateException {
        try {
            update.setString(1, mu.getNome());
            update.setString(2, mu.getEstilo());
            update.setInt(3, mu.getAnoLancamento());
            update.setInt(4, mu.getDuracao());
            update.setInt(5, mu.getId_musica());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("Erro ao atualizar música.");
        }
    }

    public void delete(Musica mu) throws DeleteException {
        try {
            delete.setInt(1, mu.getId_musica());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar música", e);
        }
    }

    public List<Musica> selectAll() throws SelectionException {
        try {
            List<Musica> musicas = new ArrayList<Musica>();
            ResultSet rs = selectAll.executeQuery();
            while (rs.next()) {
                Musica mu = new Musica();
                mu.setId_musica(rs.getInt(1));
                mu.setNome(rs.getString(2));
                mu.setEstilo(rs.getString(3));
                mu.setAnoLancamento(rs.getInt(4));
                mu.setDuracao(rs.getInt(5));
                musicas.add(mu);
            }
            return musicas;
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar músicas.");
        }
    }

    public void cadastrar_cantor(Musica mu, Cantor c) throws UpdateException, SelectionException {
        try {
            int idMusica = mu.getId_musica();
            if (idMusica == 0) {
                throw new UpdateException("ID da música não foi definido corretamente.");
            }
            
            int id = selectNewIdCantorMusica();
            insert_cantor_musica.setInt(1, id);
            insert_cantor_musica.setInt(2, c.getId_cantor());
            insert_cantor_musica.setInt(3, idMusica);
            insert_cantor_musica.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("Erro ao cadastrar cantor para a música: " + e.getMessage());
        }
    }
    
    
    
}
