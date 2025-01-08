package exepitions;

import java.sql.SQLException;

public class DeleteException extends Exception {
    public DeleteException(String mensagem, SQLException e){
        super(mensagem);
    }
}
