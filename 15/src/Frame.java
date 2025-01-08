import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Frame extends JFrame {
    public static void main(String[] args) {
        Frame frame = new Frame();
    }

    public Frame() {
        final int DEFAULT_WIDTH = 600;
        final int DEFAULT_HEIGHT = 500;
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.setTitle("Spotify");
        this.setResizable(false);

        ImageIcon icon = new ImageIcon("C:\\Users\\Dyona\\Documents\\download.jpeg");
        Image image = icon.getImage();
        this.setIconImage(image);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel tab1 = new JPanel();
        tab1.setLayout(null);
        tab1.setBackground(Color.BLACK);

        JLabel label1 = new JLabel("Pesquisar Música:");
        label1.setForeground(Color.WHITE);
        label1.setBounds(10, 20, 150, 30);
        JButton botaoPesquisarMuisca = new JButton("Buscar");
        botaoPesquisarMuisca.setBounds(230, 50, 85, 30);
        tab1.add(label1);
        tab1.add(botaoPesquisarMuisca);

        JLabel label2 = new JLabel("Músicas Favoritas:");
        JButton botaoAdicionarMusiFavorita = new JButton("+");
        botaoAdicionarMusiFavorita.setBounds(220, 180, 55, 30);
        JButton botaoRemoverMusiFavorita = new JButton("-");
        botaoRemoverMusiFavorita.setBounds(290, 180, 55, 30);
        tab1.add(botaoAdicionarMusiFavorita);
        tab1.add(botaoRemoverMusiFavorita);
        label2.setForeground(Color.WHITE);
        label2.setBounds(10, 150, 150, 30);
        tab1.add(label2);

        JTextField texto = new JTextField();
        texto.setBounds(10, 50, 200, 30);
        tab1.add(texto);

        List<String> musicasFavoritas = new ArrayList<>();
        musicasFavoritas.add("Música 1");
        musicasFavoritas.add("Música 2");
        musicasFavoritas.add("Música 3");

        // Convertendo a lista de strings para um array de objetos
        String[] arrayMusicas = musicasFavoritas.toArray(new String[0]);

        JList<String> jListMusicasFavoritas = new JList<>(arrayMusicas);
        JScrollPane scrollPaneMusicasFavoritas = new JScrollPane(jListMusicasFavoritas);
        scrollPaneMusicasFavoritas.setBounds(10, 180, 200, 100);
        tab1.add(scrollPaneMusicasFavoritas);

        JPanel tab2 = new JPanel();
        tab2.setLayout(null);
        tab2.setBackground(Color.BLACK);
        JLabel label3 = new JLabel("Playlists:");
        label3.setForeground(Color.WHITE);
        label3.setBounds(10, 20, 100, 30);
        tab2.add(label3);

        JButton botaoAdicionarPlaylist = new JButton("+");
        JButton botaoRemoverPlaylist = new JButton("-");
        JButton ordenarPlaylists = new JButton("Ordenar");
        ordenarPlaylists.setBounds(230, 80, 90, 25);
        botaoRemoverPlaylist.setBounds(280, 50, 50, 20);
        botaoAdicionarPlaylist.setBounds(220,50 ,50 ,20 );
        tab2.add(botaoAdicionarPlaylist);
        tab2.add(ordenarPlaylists);
        tab2.add(botaoRemoverPlaylist);
        List<String> playlists = new ArrayList<>();
        playlists.add("Playlist 1");
        playlists.add("Playlist 2");
        playlists.add("Playlist 3");

        String[] arrayPlaylists = playlists.toArray(new String[0]);

        JList<String> jListPlaylists = new JList<>(arrayPlaylists);
        JScrollPane scrollPanePlaylists = new JScrollPane(jListPlaylists);
        scrollPanePlaylists.setBounds(10, 50, 200, 150);
        tab2.add(scrollPanePlaylists);

        JLabel label33 = new JLabel("Músicas da Playlist:");
        label33.setBounds(10, 150, 200, 150);
        label33.setForeground(Color.WHITE);
        JButton botaoAdicionarMusicaPlay = new JButton("Adicionar Música");
        JButton botaoRemoverMusicaPlay = new JButton("Remover Música");
        JButton botaoVerPlaylist = new JButton("Ver Músicas");
        botaoVerPlaylist.setBounds(220, 310, 135, 25);
        botaoRemoverMusicaPlay.setBounds(220, 280, 135, 25);
        botaoAdicionarMusicaPlay.setBounds(220, 250, 135, 25);
        tab2.add(botaoVerPlaylist);
        tab2.add(botaoAdicionarMusicaPlay);
        tab2.add(botaoRemoverMusicaPlay);
        tab2.add(label33);

        String[] playlistEscolhida = playlists.toArray(new String[0]);

        JList<String> jListPlaylistEscolhida = new JList<>(playlistEscolhida); // Alterado para playlistEscolhida
        JScrollPane scrollPanePlaylistEscolhida = new JScrollPane(jListPlaylistEscolhida);
        scrollPanePlaylistEscolhida.setBounds(10, 240, 200, 150); // Corrigido para scrollPanePlaylistEscolhida
        tab2.add(scrollPanePlaylistEscolhida); // Alterado para scrollPanePlaylistEscolhida

        JPanel tab3 = new JPanel();
        tab3.setLayout(null);
        tab3.setBackground(Color.BLACK);

        JButton botaoAdicionarCantor = new JButton("Adicionar Cantor");
        botaoAdicionarCantor.setBounds(10, 20, 200, 30);
        tab3.add(botaoAdicionarCantor);

        JButton botaoAdicionarMusica = new JButton("Adicionar Música");
        botaoAdicionarMusica.setBounds(10, 80, 200, 30);
        tab3.add(botaoAdicionarMusica);

        JButton botaoRemoverCantor = new JButton("Remover Cantor");
        botaoRemoverCantor.setBounds(10, 140, 200, 30);
        tab3.add(botaoRemoverCantor);

        JButton botaoRemoverMusica = new JButton("Remover Música");
        botaoRemoverMusica.setBounds(10, 200, 200, 30);
        tab3.add(botaoRemoverMusica);

        JButton botaoAdicionarMusicaCantor = new JButton("Adicionar Música Cantor");
        botaoAdicionarMusicaCantor.setBounds(10, 260, 200, 30);
        tab3.add(botaoAdicionarMusicaCantor);

        JButton botaoUploadMusica = new JButton("Fazer upload");
        botaoUploadMusica.setBounds(10, 320, 200, 30);
        tab3.add(botaoUploadMusica);

        tabbedPane.addTab("Menu", tab1);
        tabbedPane.addTab("Biblioteca", tab2);
        tabbedPane.addTab("Configurações", tab3);

        this.getContentPane().add(tabbedPane);

        botaoAdicionarCantor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoAdicionarMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoRemoverCantor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoRemoverMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoPesquisarMuisca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoAdicionarMusiFavorita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoRemoverMusiFavorita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoAdicionarMusicaCantor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoUploadMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoAdicionarPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoRemoverPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        ordenarPlaylists.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoVerPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoAdicionarMusicaPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        botaoRemoverMusicaPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String input = JOptionPane.showInputDialog("Digite algo:");
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
