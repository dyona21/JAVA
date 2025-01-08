package persistencia;

import java.sql.Connection;
import dados.Contato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;

public class ContatoDAO {
    private static ContatoDAO instance = null;

    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    private PreparedStatement selectNewId;

    public static ContatoDAO getInstance() throws ClassNotFoundException,
    SQLException, SelectException {

        if(instance == null){
            instance = new ContatoDAO();
        }

        return instance;
    }
    
    private ContatoDAO() throws ClassNotFoundException, SQLException, SQLException{
        Connection conexao = Conexao.getConexao();
        selectNewId = conexao.prepareStatement("select nextval('id_endereco')");


    }

    private int selectNewId() throws SelectException{
        try{
            ResultSet rs = selectNewId.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }

        } catch(SQLException e){
            throw new SelectException("Erro ao buscar novo id da tabela contato");
        }

        return 0;
    }

     public void insert (Contato contato) throws InsertException, SelectException{
        try{
            insert.setInt(1, selectNewId());
            insert.setString(2, contato.getNome());
            insert.setInt(3, contato.getTelefone());
            insert.executeUpdate();
        } catch (SQLException e){
            throw new InsertException();
        }
    }

     public void delete (Contato contato) throws DeleteException{

        try{
            delete.setInt(1, contato.getId_contato());
            delete.setString(2, contato.getNome());
            delete.setInt(3, contato.getTelefone());
            delete.executeUpdate();
        } catch (SQLException e){
            throw new DeleteException("Erro ao deletar contato");
        } 
    }

    
    public void update (Contato contato) throws UpdateException{
        try{
            update.setInt(1, contato.getId_contato());
            update.setString(2, contato.getNome());
            update.setInt(3, contato.getTelefone());
            //update.setInt(4, playlist.getId());
            update.executeUpdate();
        } catch (SQLException e){
            throw new UpdateException();
        }
    }

    public Contato select (int contato) throws SelectException {
        try{
            select.setInt(1, contato);
            ResultSet rs = select.executeQuery();
            if(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int telefone = rs.getInt(3);
                return new Contato(id, telefone, nome);
            }
        } catch (SQLException e){
            throw new SelectException("Erro ao buscar contato.");
        }
        return null;
    }

    public List<Contato> selectAll () throws SelectException {
        try{
            List<Contato> contatos = new ArrayList<Contato>();
            ResultSet rs = selectAll.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int telefone = rs.getInt(3);
                Contato c = new Contato(id, telefone, nome);
                contatos.add(c);
            }
            return contatos;
        } catch (SQLException e){
            throw new SelectException("Erro ao buscar contatos.");
        }
       
    }

}