package apresentacao;

import javax.swing.*;
import dados.Usuario;
import exepitions.InsertException;
import exepitions.SelectionException;
import negocio.App;
import persistencia.Conexao;
import persistencia.UsuarioDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Login extends JFrame {
    private JTextField usuario;
    private JPasswordField senha;
    private JButton botaoLogin;
    private JButton botaoCadastrar;
    private UsuarioDAO usuarioDAO;
    private App app;
    
    public Login() throws ClassNotFoundException, SQLException, SelectionException {
        app = App.getInstance();
        usuarioDAO = UsuarioDAO.getInstance();
        // Inicializa a lista de cadastros
  //  Usuario l = usuarioDAO.select(1); System.out.println(l.getNomeUsuario());
        List<Usuario> cadastros = usuarioDAO.selectAll();

        // Configurações do JFrame
        setTitle("Spotify");
        setSize(600, 400); // Aumenta o tamanho do JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("C:\\Users\\Dyona\\Documents\\download.jpeg");
        setIconImage(icon.getImage());

        // Redimensiona a imagem
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // Redimensiona a imagem para 100x50
        icon = new ImageIcon(newImage);

        // Painel e layout
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null); // Usando layout absoluto
        add(panel);

        // Adiciona a imagem no centro do painel
        JLabel imageLabel = new JLabel(icon);
        int imageWidth = icon.getIconWidth();
        int imageHeight = icon.getIconHeight();
        int imageX = (600 - imageWidth) / 2; // Centraliza a imagem no eixo X
        int imageY = 30; // Define a posição Y conforme necessário
        imageLabel.setBounds(imageX, imageY, imageWidth, imageHeight);
        panel.add(imageLabel);

        // Estilo das labels e campos de texto
        Font font = new Font("Arial", Font.PLAIN, 16);

        // Campo de usuário
        JLabel usuarioLabel = new JLabel("Usuário:");
        usuarioLabel.setForeground(Color.WHITE);
        usuarioLabel.setFont(font);
        usuarioLabel.setBounds(100, imageY + imageHeight + 20, 100, 30); // Ajusta a posição conforme necessário
        panel.add(usuarioLabel);

        usuario = new JTextField(20); // Aumenta o tamanho preferido
        usuario.setPreferredSize(new Dimension(250, 30));
        usuario.setBounds(180, imageY + imageHeight + 20, 250, 30); // Ajusta a posição conforme necessário
        panel.add(usuario);

        // Campo de senha
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setForeground(Color.WHITE);
        senhaLabel.setFont(font);
        senhaLabel.setBounds(100, imageY + imageHeight + 60, 100, 30); // Ajusta a posição conforme necessário
        panel.add(senhaLabel);

        senha = new JPasswordField(20); // Aumenta o tamanho preferido
        senha.setPreferredSize(new Dimension(250, 30));
        senha.setBounds(180, imageY + imageHeight + 60, 250, 30); // Ajusta a posição conforme necessário
        panel.add(senha);

        // Botão de login
        botaoLogin = new JButton("Login");
        botaoLogin.setFont(font);
        botaoLogin.setBounds(185, imageY + imageHeight + 100, 100, 30); // Ajusta a posição conforme necessário
        panel.add(botaoLogin);

        // Botão de cadastro
        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setFont(font);
        botaoCadastrar.setBounds(295, imageY + imageHeight + 100, 130, 30); // Ajusta a posição conforme necessário
        panel.add(botaoCadastrar);

        // ActionListener do botão de login
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String username = usuario.getText();
                String password = new String(senha.getPassword());

                boolean credenciaisValidas = false;

                for (Usuario u : cadastros) {
                    if (password.equals(u.getSenha()) && username.equals(u.getNomeUsuario())) {
                        credenciaisValidas = true;
                        app.pegarUsuario(u);
                        break;
                    }
                }

                if (credenciaisValidas) {
                    // Fechar janela de login
                    dispose();
                    // Abrir janela de menu
                    //Menu menu = new Menu();
                    //menu.setVisible(true);
                    Frame frame;
                    try {
                        try {
                            frame = new Frame();
                            frame.setVisible(true);
                        } catch (InsertException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        
                    } catch (ClassNotFoundException | SQLException | SelectionException e) {
                        e.printStackTrace();
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciais inválidas", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ActionListener do botão de cadastro
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String username = usuario.getText();
                String password = new String(senha.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Usuario u = new Usuario();
                    u.setNomeUsuario(username);
                    u.setSenha(password);
                    try {
                        usuarioDAO.insert(u);
                        app.pegarUsuario(usuarioDAO.select(username));
                        try {
                            app.criarPlaylist("Favorita");
                        } catch (InsertException | SelectionException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        
                    } catch (InsertException | SelectionException e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, SelectionException {
        // Inicializa a interface de login
        Login login = new Login();
        login.setVisible(true);
    }
}
