package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Usuario;
import exepitions.DeleteException;
import exepitions.InsertException;
import exepitions.SelectionException;
import exepitions.UpdateException;

public class UsuarioDAO {
    private static UsuarioDAO instance = null;
    private PreparedStatement selectNewID;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;

    public static UsuarioDAO getInstance() throws ClassNotFoundException, SQLException, SelectionException {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    private UsuarioDAO() throws ClassNotFoundException, SQLException, SelectionException {
        Connection conexao = Conexao.getConexao();
        selectNewID = conexao.prepareStatement("select nextval('id_usuario')");
        insert = conexao.prepareStatement("insert into usuario (id, nome, senha) values (?, ?, ?)");
        select = conexao.prepareStatement("select * from usuario where nome = ?");
        selectAll = conexao.prepareStatement("select * from usuario");
        update = conexao.prepareStatement("update usuario set nome = ?, senha = ? where id = ?");
        delete = conexao.prepareStatement("delete from usuario where id = ?");
    }

    private int selectNewId() throws SelectionException {
        try {
            ResultSet rs = selectNewID.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar novo id na tabela usuario");
        }
        return 0;
    }

    public void insert(Usuario u) throws InsertException, SelectionException {
        try {
            int newId = selectNewId();
            u.setId_usuario(newId); // Atualiza o ID do usuário com o novo ID gerado
            insert.setInt(1, u.getId_usuario());
            insert.setString(2, u.getNomeUsuario());
            insert.setString(3, u.getSenha());
            insert.executeUpdate();
        } catch (SQLException e) {
            throw new InsertException("Erro ao inserir usuário.");
        }
    }

    public Usuario select(String mensagem) throws SelectionException {
        try {
            Usuario us = new Usuario();
            select.setString(1, mensagem);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                
                us.setId_usuario(rs.getInt(1));
                us.setNomeUsuario(rs.getString(2));
                us.setSenha(rs.getString(3));
                
            }
            return us;
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar usuário.");
        }
    }

    public void update(Usuario u) throws UpdateException {
        try {
            update.setString(1, u.getNomeUsuario());
            update.setString(2, u.getSenha());
            update.setInt(3, u.getId_usuario());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new UpdateException("Erro ao atualizar usuário.");
        }
    }

    public void delete(Usuario u) throws DeleteException {
        try {
            delete.setInt(1, u.getId_usuario());
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteException("Erro ao deletar usuário.",e);
        }
    }

    public List<Usuario> selectAll() throws SelectionException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            ResultSet rs = selectAll.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId_usuario(rs.getInt(1));
                us.setNomeUsuario(rs.getString(2));
                us.setSenha(rs.getString(3));
                usuarios.add(us);
            }
            
        } catch (SQLException e) {
            throw new SelectionException("Erro ao buscar usuários.");
        }
        return usuarios;
    }

}
