package apresentacao;
import java.sql.SQLException;

import javax.swing.*;
import exepitions.SelectionException;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login login;
                try {
                    login = new Login();
                    login.setVisible(true);
                } catch (ClassNotFoundException | SQLException | SelectionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        });
    }
}
