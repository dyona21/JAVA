//package apresentacao;

import javax.swing.*;
import dados.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Login extends JFrame {
    private JTextField usuario;
    private JPasswordField senha;
    private JButton botaoLogin;
    private List<Usuario> cadastros;
    private JButton botaoCadastrar;

    public Login() {
        // Inicializa a lista de cadastros
        cadastros = new ArrayList<>();

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
                        break;
                    }
                }

                if (credenciaisValidas) {
                    // Fechar janela de login
                    dispose();
                    // Abrir janela de menu
                    Menu menu = new Menu();
                    menu.setVisible(true);
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
                    cadastros.add(u);
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Não é necessário chamar pack() já que estamos usando layout absoluto
    }

    public static void main(String[] args) {
        // Inicializa a interface de login
        Login login = new Login();
        login.setVisible(true);
    }
}
