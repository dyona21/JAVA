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

public class CantorDAO {
    private static CantorDAO instance = null;
    private PreparedStatement selectNewID;
    private PreparedStatement selectNewIDCantorMusica;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement delete_cantor_musica;
    private PreparedStatement delete_musica;
    private PreparedStatement inserir_musica;
    private PreparedStatement update;
    private PreparedStatement pegar_musicas;
    private PreparedStatement pegar_musicas_tabela;

    public static CantorDAO getInstance() throws ClassNotFoundException, SQLException, SelectionException {
        if (instance == null) {
            instance = new CantorDAO();
        }
        return instance;
    }

    private CantorDAO() throws ClassNotFoundException, SQLException, SelectionException {
        Connection conexao = Conexao.getConexao();
        selectNewID = conexao.prepareStatement("select nextval('id_cantor')");
        selectNewIDCantorMusica = conexao.prepareStatement("select nextval('id_cantor_musica')");
        insert = conexao.prepareStatement("insert into cantor (id, nome, rede_social, estilo) values (?, ?, ?, ?)");
        select = conexao.prepareStatement("select * from cantor where id = ?");
        selectAll = conexao.prepareStatement("select * from cantor");
        pegar_musicas = conexao.prepareStatement("SELECT id_musica FROM cantor_musica WHERE id_cantor = ?");
        pegar_musicas_tabela = conexao.prepareStatement("SELECT * FROM musica WHERE id = ?");
        update = conexao.prepareStatement("update cantor set nome = ?, rede_social = ?, estilo = ? where id = ?");
        delete = conexao.prepareStatement("delete from cantor where id = ?");
        delete_cantor_musica = conexao.prepareStatement("delete from cantor_musica where id_cantor = ?");
        delete_musica = conexao.prepareStatement("delete from cantor_musica where id_cantor = ? and id_musica = ?");
        inserir_musica = conexao.prepareStatement("insert into cantor_musica (id, id_cantor, id_musica) values (?, ?, ?)");
    }

    private int selectNewId() throws SelectionException {
        try {
            ResultSet rs = selectNewID.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar novo id na tabela Cantor");
        }
        return 0;
    }

    private int selectNewIDCantorMusica() throws SelectionException {
        try {
            ResultSet rs = selectNewIDCantorMusica.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar novo id na tabela Cantor");
        }
        return 0;
    }

    public void insert(Cantor cantor) throws InsertException, SelectionException {
        try {
            insert.setInt(1, selectNewId());
            insert.setString(2, cantor.getNome());
            insert.setString(3, cantor.getRedeSocial());
            insert.setString(4, cantor.getEstilo());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir cantor.");
        }
    }

    public void inserirMusica(Cantor cantor, Musica musica) throws InsertException, SelectionException {
        try {
            inserir_musica.setInt(1, selectNewIDCantorMusica());
            inserir_musica.setInt(2, cantor.getId_cantor());
            inserir_musica.setInt(3, musica.getId_musica());
            inserir_musica.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir música para o cantor.");
        }
    }

    public Cantor select(int cantorId) throws SelectionException {
        try {
            select.setInt(1, cantorId);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                Cantor ca = new Cantor();
                ca.setId_cantor(rs.getInt(1));
                ca.setNome(rs.getString(2));
                ca.setRedeSocial(rs.getString(3));
                ca.setEstilo(rs.getString(4));
                return ca;
            }
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar cantor.");
        }
        return null;
    }

    public void update(Cantor cantor) throws UpdateException {
        try {
            update.setString(1, cantor.getNome());
            update.setString(2, cantor.getRedeSocial());
            update.setString(3, cantor.getEstilo());
            update.setInt(4, cantor.getId_cantor());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("Erro ao atualizar cantor.");
        }
    }

    public List<Cantor> selectAll() throws SelectionException {
        try {
            List<Cantor> cantores = new ArrayList<Cantor>();
            ResultSet rs = selectAll.executeQuery();
            while (rs.next()) {
                Cantor c = new Cantor();
                c.setId_cantor(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setRedeSocial(rs.getString(3));
                c.setEstilo(rs.getString(4));
                cantores.add(c);
            }
            return cantores;
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar cantores.");
        }
    }

    public void delete(Cantor cantor) throws DeleteException {
        try {
            System.out.println("Deletando cantor com ID: " + cantor.getId_cantor());
            delete.setInt(1, cantor.getId_cantor());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar cantor", e);
        }
    }
    

    public void deleteMusica(Cantor cantor, Musica musica) throws DeleteException {
        try {
            delete_musica.setInt(1, cantor.getId_cantor());
            delete_musica.setInt(2, musica.getId_musica());
            int rowsAffected = delete_musica.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Música removida com sucesso!");
            } else {
                System.out.println("Nenhuma música encontrada para remoção.");
            }
        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar música do cantor",e);
        }
    }

    public void deleteCantor_musica(Cantor cantor) throws DeleteException {
        try {
            delete_cantor_musica.setInt(1, cantor.getId_cantor());
            int rowsAffected = delete_cantor_musica.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Música removida com sucesso!");
            } else {
                System.out.println("Nenhuma música encontrada para remoção.");
            }
        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar música do cantor",e);
        }
    }

    public List<Musica> pegar_musica(Cantor c) throws SelectionException {
        try {
            List<Musica> musi = new ArrayList<>();
            pegar_musicas.setInt(1, c.getId_cantor());
            
            // Adicionando log antes da execução da query
            System.out.println("Executando pegar_musicas para o cantor com ID: " + c.getId_cantor());
    
            try (ResultSet rs = pegar_musicas.executeQuery()) {
                // Log após a execução da query
                System.out.println("Query pegar_musicas executada");
    
                while (rs.next()) {
                    Musica m = new Musica();
                    m.setId_musica(rs.getInt("id_musica"));  // Assumindo que a coluna na tabela cantor_musica é id_musica
                    musi.add(m);
                }
            }
    
            // Log para mostrar o número de músicas encontradas
            System.out.println("Número de músicas encontradas: " + musi.size());
    
            List<Musica> musicas = new ArrayList<>();
            for (Musica m : musi) {
                pegar_musicas_tabela.setInt(1, m.getId_musica());
    
                // Adicionando log antes da execução da query
                System.out.println("Executando pegar_musicas_tabela para a música com ID: " + m.getId_musica());
    
                try (ResultSet rs2 = pegar_musicas_tabela.executeQuery()) {
                    // Log após a execução da query
                    System.out.println("Query pegar_musicas_tabela executada");
    
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
    
            // Log para mostrar o número de músicas detalhadas encontradas
            System.out.println("Número de músicas detalhadas encontradas: " + musicas.size());
    
            return musicas;
        } catch (SQLException e) {
            // Log detalhado da exceção
            e.printStackTrace();
            throw new SelectionException("Erro ao buscar músicas do cantor: " + e.getMessage());
        }
    }
    
    
    
    
}
