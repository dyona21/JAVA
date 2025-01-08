package apresentacao;

import javax.swing.*;

import dados.*;
import exepitions.DeleteException;
import exepitions.InsertException;
import exepitions.SelectionException;
import negocio.*;
import java.awt.event.*;
import java.sql.SQLException;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import java.util.Collections;
import java.util.Comparator;

public class Frame extends javax.swing.JFrame{
    private App app;
    private JTextField texto; // Declare texto como campo da classe
    JButton botaoPesquisarMuisca = new JButton("Buscar");
    JList<String> lista_Cantores = new JList<String>();
    JList<String> lista_Playlist = new JList<String>();
    JList<String> lista_Musicas_Playlist = new JList<String>();
    JList<String> listaMusicaCurtida = new JList<String>();
    JList<String> playlistOrdenada = new JList<String>();
    JList<String> musicas_De_Cantor = new JList<String>();


    public Frame() throws ClassNotFoundException, SQLException, SelectionException, InsertException {

        app = App.getInstance();
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
       
        botaoPesquisarMuisca.setBounds(230, 50, 85, 30);
        tab1.add(label1);
        tab1.add(botaoPesquisarMuisca);
        botaoPesquisarMuisca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

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

        texto = new JTextField(); // Inicialize a variável texto
        texto.setBounds(10, 50, 200, 30);
        tab1.add(texto);

        JList<String> jListMusicasFavoritas = listaMusicaCurtida;
        JScrollPane scrollPaneMusicasFavoritas = new JScrollPane(jListMusicasFavoritas);
        scrollPaneMusicasFavoritas.setBounds(10, 180, 200, 200);
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
        botaoAdicionarPlaylist.setBounds(220, 50, 50, 20);
        tab2.add(botaoAdicionarPlaylist);
        tab2.add(ordenarPlaylists);
        tab2.add(botaoRemoverPlaylist);

        JList<String> jListPlaylists = lista_Playlist;
        JScrollPane scrollPanePlaylists = new JScrollPane(jListPlaylists);
        scrollPanePlaylists.setBounds(10, 50, 200, 150);
        tab2.add(scrollPanePlaylists);

        JLabel label33 = new JLabel("Músicas da Playlist:");
        label33.setBounds(10, 150, 200, 150);
        label33.setForeground(Color.WHITE);
        JButton botaoAdicionarMusicaPlay = new JButton("Adicionar Música");
        JButton botaoRemoverMusicaPlay = new JButton("Remover Música");
        JButton botaoVerMusicasPlaylist = new JButton("Ver Músicas");
        botaoVerMusicasPlaylist.setBounds(220, 310, 135, 25);
        botaoRemoverMusicaPlay.setBounds(220, 280, 135, 25);
        botaoAdicionarMusicaPlay.setBounds(220, 250, 135, 25);
        tab2.add(botaoVerMusicasPlaylist);
        tab2.add(botaoAdicionarMusicaPlay);
        tab2.add(botaoRemoverMusicaPlay);
        tab2.add(label33);

        JList<String> jListPlaylistEscolhida = lista_Musicas_Playlist;
        JScrollPane scrollPanePlaylistEscolhida = new JScrollPane(jListPlaylistEscolhida);
        scrollPanePlaylistEscolhida.setBounds(10, 240, 200, 150);
        tab2.add(scrollPanePlaylistEscolhida);

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

        JList<String> jListMusicasCantor = musicas_De_Cantor;
        JScrollPane scrollPaneMusicasCantor = new JScrollPane(jListMusicasCantor);
        scrollPaneMusicasCantor.setBounds(260, 10, 300, 170);
        tab3.add(scrollPaneMusicasCantor);
        JButton botaoVerMusicaCantor = new JButton("Ver músicas de um cantor");
        botaoVerMusicaCantor.setBounds(260, 185, 200, 25);
        tab3.add(botaoVerMusicaCantor);

        JLabel label18 = new JLabel("Cantores cadastrados:");
        label18.setForeground(Color.WHITE);
        label18.setBounds(260, 220, 150, 30);
        tab3.add(label18);
        JList<String> jListCantoresCadastrados = lista_Cantores;
        JScrollPane scrollPaneCantoresCadastrados = new JScrollPane(jListCantoresCadastrados);
        scrollPaneCantoresCadastrados.setBounds(260, 245, 300, 170);
        tab3.add(scrollPaneCantoresCadastrados);

        tabbedPane.addTab("Menu", tab1);
        tabbedPane.addTab("Biblioteca", tab2);
        tabbedPane.addTab("Configurações", tab3);

        this.getContentPane().add(tabbedPane);
        atualizarListaCantores();
        atualizarListaPlaylists();
        

        botaoPesquisarMuisca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String buscar = texto.getText();
                boolean found = false;
                try {
                    for (int i = 0; i < app.getMusicasCadastradas().size(); i++) {
                        if (buscar.equals(app.getMusicasCadastradas().get(i).getNome())) {

                            JDialog dialog = new JDialog();
                            dialog.setSize(300, 200);
                            dialog.setLocationRelativeTo(null);

                            // Painel de conteúdo do JDialog com layout GridLayout
                            JPanel dialogPanel = new JPanel(new GridLayout(2, 1));

                            // Adicionando um rótulo para exibir o nome da música
                            JLabel musicaLabel = new JLabel("Música: " + buscar);
                            dialogPanel.add(musicaLabel);

                            // Botão para reproduzir a música
                            JButton playButton = new JButton("Reproduzir");
                            Musica m55 = new Musica();
                            m55.setNome(buscar);

                            playButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    m55.tocarPrevia();
                                    JOptionPane.showMessageDialog(dialog, "Reproduzindo: " + buscar);
                                }
                            });

                            dialogPanel.add(playButton);

                            dialog.add(dialogPanel);
                            dialog.setVisible(true);
                            found = true;
                            break;
                        }
                    }
                } catch (SelectionException e) {
                    e.printStackTrace();
                }
                if (!found) {
                    JOptionPane.showMessageDialog(tab1, "Essa música não está cadastrada, não pode ser encontrada.", "Mensagem", JOptionPane.WARNING_MESSAGE);
                }
            
            }
        });
        
        botaoAdicionarCantor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String estilo =  JOptionPane.showInputDialog("Digite o estilo musical do cantor:");
                try {
                    Cantor c10 = new Cantor();
                    String nomeCantor =  JOptionPane.showInputDialog("Digite o nome:");
                    c10.setNome(nomeCantor);
                    c10.setEstilo(estilo); 
                    String redesocialcantor =  JOptionPane.showInputDialog("Digite o instagram:");
                    c10.setRedeSocial(redesocialcantor);
        
                    app.adicionarCantor(c10);
        
                    // Mensagem de sucesso para o usuário
                    JOptionPane.showMessageDialog(null, "Cantor adicionado com sucesso!");
                     // Atualiza a lista de cantores
                    atualizarListaCantores();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar o cantor: " + ex.getMessage());
                    ex.printStackTrace(); // Depuração
                }
            }


        });

        botaoAdicionarMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    Musica m3 = new Musica();
                    Cantor c3 = null; 
                    
                    // Captura e verificação dos valores
                    String nomeCantor = JOptionPane.showInputDialog("Digite o nome do cantor da música:");
                    String nomeEstilo = JOptionPane.showInputDialog("Digite o estilo da música:");
                    String nomeDaMusica = JOptionPane.showInputDialog("Digite o nome da música:");
                    String duracao = JOptionPane.showInputDialog("Digite a duração da música (em segundos):");
                    String anoLancamento = JOptionPane.showInputDialog("Digite o ano de lançamento da música:");
                    
                    List<Cantor> cantors = app.getCantoresCadastrados();
                    
                    // Configuração dos objetos
                    for(Cantor c : cantors){
                        if(nomeCantor.equals(c.getNome())){
                            c3 = c;
                            break;
                        } 
                    }

                    if(c3 == null){
                        c3 = new Cantor();
                        c3.setNome(nomeCantor);
                        c3.setEstilo(nomeEstilo);
                    }
                    

                    m3.setNome(nomeDaMusica); // Corrigido para definir o nome da música corretamente
                    m3.setDuracao(Integer.parseInt(duracao));
                    m3.setAnoLancamento(Integer.parseInt(anoLancamento));
                    m3.setEstilo(nomeEstilo); // Associando o estilo à música
                    app.adicionarMusica(m3);
                    app.cadastrar_cantor_musica(c3, m3);
                    
                    
                    JOptionPane.showMessageDialog(null, "Música adicionada com sucesso.");
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para duração e lançamento.");
                    ex.printStackTrace(); // Depuração
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar a música: " + ex.getMessage());
                    ex.printStackTrace(); // Depuração
                }
            }
        });

        botaoRemoverCantor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String nomeDoCantor = JOptionPane.showInputDialog("Digite o nome do cantor:");
                    boolean found = false;
        
                    for (Cantor c : app.getCantoresCadastrados()) {
                        if (nomeDoCantor.equals(c.getNome())) {
                            System.out.println("Tentando remover cantor: " + c.getNome());
                            app.removerCantor(c);
                            found = true;
                            JOptionPane.showMessageDialog(tab3, "Cantor removido com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
        
                    if (!found) {
                        JOptionPane.showMessageDialog(tab3, "Cantor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
        
                    atualizarListaCantores(); // Atualiza a lista de cantores
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover o cantor: " + ex.getMessage());
                    ex.printStackTrace(); // Depuração
                }
            }
        
            private void atualizarListaCantores() throws SelectionException {
                lista_Cantores.setModel(new AbstractListModel<String>() {
                    List<Cantor> cantorsNamesList = app.getCantoresCadastrados(); // Use the ArrayList
                
                    public int getSize() { return cantorsNamesList.size(); }
                
                    public String getElementAt(int i) { return cantorsNamesList.get(i).getNome(); }
                });
            }
        });
        
        botaoRemoverMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nomeMusica = JOptionPane.showInputDialog("Digite o nome da música:");
                boolean found = false;
                try {
                    List<Musica> musics = app.getMusicasCadastradas();
                    for (int i = musics.size() - 1; i >= 0; i--) {
                        if (nomeMusica.equals(musics.get(i).getNome())) { 
                            try {
                                app.removerMusica(musics.get(i));
                            } catch (DeleteException e) {
                                e.printStackTrace();
                            }
                            found = true;
                            JOptionPane.showMessageDialog(tab3, "Música removida com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
            
                } catch (SelectionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (!found) {
                    JOptionPane.showMessageDialog(tab3, "Música não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }

        });

        botaoVerMusicaCantor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Solicita o nome do cantor ao usuário
                String cantorSelecionado = JOptionPane.showInputDialog("Digite o nome do cantor:");
                
                if (cantorSelecionado != null && !cantorSelecionado.trim().isEmpty()) { // Verifica se o nome do cantor não é null ou vazio
                    // Verifica se o cantor selecionado existe na lista de cantores cadastrados
                    Cantor cantorEncontrado = null;
                    try {
                        List<Cantor> cants = app.getCantoresCadastrados();
                        for (Cantor cantor : cants) {
                            if (cantorSelecionado.equalsIgnoreCase(cantor.getNome())) { // Compara ignorando caso
                                cantorEncontrado = cantor;
                                break;
                            }
                        }
                    } catch (SelectionException e) {
                        e.printStackTrace();
                    }
                    
                    if (cantorEncontrado != null) { // Se o cantor foi encontrado
                        DefaultListModel<String> musicasDeUmCantor = new DefaultListModel<>(); 
                        // Adicionar as músicas da playlist ao modelo de lista
                            try {
                                for (Musica m : app.getMusicasCantor(cantorEncontrado)) {
                                    musicasDeUmCantor.addElement(m.getNome());
                                }
                            } catch (SelectionException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            musicas_De_Cantor.setModel(musicasDeUmCantor);
                    } else { // Se o cantor não foi encontrado
                        JOptionPane.showMessageDialog(null, "Cantor não encontrado!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nome do cantor não pode ser vazio!");
                }
            }
        });
        

        botaoAdicionarMusiFavorita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean found = false;
                    List<Musica> musics = app.getMusicasCadastradas();
                    String m20 = JOptionPane.showInputDialog("Digite o nome da música:");
                    for(Musica m : musics){
                        if(m20.equals(m.getNome())){
                            try {
                                System.out.println("AQQQ3");
                                app.addMusicaFav(m);
                                System.out.println("AQQQ5");
                            } catch (InsertException e) {
                                e.printStackTrace();
                            }
                            found = true;
                            JOptionPane.showMessageDialog(null, "Música adicionada aos favoritos com sucesso!");
                            try {
                                atualizarListaMusicasFavoritas();
                            } catch (InsertException e) {
                                e.printStackTrace();
                            }
                            break;
                        } 
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Música não encontrada nas cadastradas.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SelectionException e) {
                    e.printStackTrace();
                }
                
            }
                private void atualizarListaMusicasFavoritas() throws InsertException, SelectionException {
                    listaMusicaCurtida.setModel(new AbstractListModel<String>() {
                        List<Musica> musicNamesList = app.getMusicasFavoritas();
                
                        public int getSize() { return musicNamesList.size(); }
                
                        public String getElementAt(int i) { return musicNamesList.get(i).getNome(); }
                    });
                }
        });

        botaoRemoverMusiFavorita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                boolean found = false;
                String m22 = JOptionPane.showInputDialog("Digite o nome da música:");
                try {
                    for(Musica m : app.getMusicasFavoritas()){
                        if(m22.equals(m.getNome())){
                            try {
                                app.removerMusicaFav(m);
                            } catch (DeleteException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            found = true;
                            JOptionPane.showMessageDialog(null, "Música removida dos favoritos com sucesso!");
                            atualizarListaMusicasFavoritas();
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover a música.");
                        }
                    }
                } catch (HeadlessException | InsertException | SelectionException e) {
                    e.printStackTrace();
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Música não encontrada nos favoritos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
                
            
        });

        botaoAdicionarMusicaCantor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nomeMusica1 = JOptionPane.showInputDialog("Digite o nome da música:");
                String nomeCantor1 = JOptionPane.showInputDialog("Digite o nome do cantor:");              
                Musica musicaEncontrada1 = null;
                Cantor cantorEncontrado1 = null;
        
                // Verificar se a música existe
                try {
                    for (Musica musica : app.getMusicasCadastradas()) {
                        if (nomeMusica1.equals(musica.getNome())) {
                            musicaEncontrada1 = musica;
                            break;
                        }
                    }
                } catch (SelectionException e) {
                    e.printStackTrace();
                }
        
                if (musicaEncontrada1 == null) {
                    JOptionPane.showMessageDialog(tab3, "Música não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                // Verificar se o cantor existe
                try {
                    for (Cantor cantor : app.getCantoresCadastrados()) {
                        if (cantor.getNome().equals(nomeCantor1)) {
                            cantorEncontrado1 = cantor;
                            break;
                        }
                    }
                } catch (SelectionException e) {
                    e.printStackTrace();
                }
        
                if (cantorEncontrado1 == null) {
                    JOptionPane.showMessageDialog(tab3, "Cantor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                // Verificar se o cantor já está associado à música
                if (musicaEncontrada1.getCantores().contains(cantorEncontrado1)) {
                    JOptionPane.showMessageDialog(tab3, "Cantor já está associado a esta música.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        app.adicionarMusicaCantor(cantorEncontrado1, musicaEncontrada1);
                    } catch (InsertException | SelectionException e) {
                        e.printStackTrace();
                    }
                    //musicaEncontrada1.getCantores().add(cantorEncontrado1);
                    JOptionPane.showMessageDialog(tab3, "Cantor adicionado à música com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        });

        botaoUploadMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nome_musica = JOptionPane.showInputDialog("Nome da música:");
                String duracao_musica = JOptionPane.showInputDialog("Duração da música:");
                String lancamento_musica = JOptionPane.showInputDialog("Lançamento da música:");
                String estilo_musica = JOptionPane.showInputDialog("Estilo da música:");
                String cantor_musica = JOptionPane.showInputDialog("Nome do cantor da música:");
                String content = JOptionPane.showInputDialog("Passe seu arquivo:");
                Musica m = new Musica();
                m.setNome(nome_musica);
                m.setAnoLancamento(Integer.parseInt(lancamento_musica));
                m.setDuracao(Integer.parseInt(duracao_musica));
                m.setEstilo(estilo_musica);

                Cantor c3 = null; 

                try {
                    for(int i = 0; i < app.getCantoresCadastrados().size(); i++){
                        if(cantor_musica.equals(app.getCantoresCadastrados().get(i).getNome())){
                            c3 = app.getCantoresCadastrados().get(i);
                            break;
                        } 
                    }
                } catch (SelectionException e) {
                   
                    e.printStackTrace();
                }

                if(c3 == null){
                    c3 = new Cantor();
                    c3.setNome(cantor_musica);
                    c3.setEstilo(estilo_musica);
                }

                m.setCantores(c3);
                try {
                    app.adicionarMusica(m);
                } catch (InsertException | SelectionException e) {
                    e.printStackTrace();
                }

                    // Caminho e nome do arquivo
                    String filePath = "caminho/do/seu/arquivo.txt";

                    // Escrevendo o conteúdo do JTextField no arquivo
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                        writer.write(content);
                        JOptionPane.showMessageDialog(tab3, "Arquivo adicionado com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        });

        botaoAdicionarPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String novaPlaylist;
                     novaPlaylist =  JOptionPane.showInputDialog("Nome da playlist:");
 
                     app.criarPlaylist(novaPlaylist);
 
                     // Mensagem de sucesso para o usuário
                     JOptionPane.showMessageDialog(null, "Playlist adicionada com sucesso!");
                     atualizarListaPlaylists(); // Atualiza a lista de playlists
 
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, "Ocorreu um erro ao adicionar a playlist: " + ex.getMessage());
                     ex.printStackTrace(); // Depuração
                 }
             }
             
        });

        botaoRemoverPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String nomeDaPlaylist = JOptionPane.showInputDialog("Nome da playlist:");
                    boolean found = false;
            
                    for (int i = 0; i < app.getPlaylistCadastradas().size(); i++) {
                        if (nomeDaPlaylist.equals(app.getPlaylistCadastradas().get(i).getNome())) {
                            app.removerPlaylist(app.getPlaylistCadastradas().get(i));
                            found = true;
                            JOptionPane.showMessageDialog(null, "Playlist removida com sucesso!");
                            break;
                        }
                    }
            
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Playlist não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                    atualizarListaPlaylists(); // Atualiza a lista de playlists
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover a playlist: " + ex.getMessage());
                    ex.printStackTrace(); // Depuração
                }
            }

            

        });

        ordenarPlaylists.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nomePlaylist = JOptionPane.showInputDialog("Nome da playlist:");
                Playlist playlist = null;
                try {
                    for(Playlist pl :  app.getPlaylistCadastradas()){
                        if(nomePlaylist.equals(pl.getNome())){
                            playlist = pl;
                            break;
                        }
                    }
                } catch (SelectionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if (playlist != null) {
                    // Ordenar as músicas dentro da playlist
                    try {
                        // Obtém a lista de músicas da playlist
                        List<Musica> musicasPlaylist = app.pegarMusicasPlaylist(playlist);
                    
                        // Ordena a lista de músicas por nome
                        Collections.sort(musicasPlaylist, new Comparator<Musica>() {
                            @Override
                            public int compare(Musica musica1, Musica musica2) {
                                // Comparar as músicas por nome
                                return musica1.getNome().compareTo(musica2.getNome());
                            }
                        });
                    
                        // Atualiza o modelo de lista da playlist ordenada
                        DefaultListModel<String> playlistModel = new DefaultListModel<>();
                        for (Musica musica : musicasPlaylist) {
                            playlistModel.addElement(musica.getNome());
                        }
                    
                        // Define o modelo de lista ordenada na interface gráfica
                        playlistOrdenada.setModel(playlistModel);
                    
                    } catch (SelectionException e) {
                        e.printStackTrace(); // Trate a exceção adequadamente
                    }
                    
                    // Exibir mensagem de sucesso
                    JOptionPane.showMessageDialog(null, "Músicas da playlist ordenadas em ordem alfabética.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Playlist não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botaoVerMusicasPlaylist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String nomePlaylist = JOptionPane.showInputDialog("Nome da playlist:");
                Playlist playlistEncontrada = null;
        
                // Procurar a playlist pelo nome
                List<Playlist> pl;
                try {
                    pl = app.getPlaylistCadastradas();
                    for (Playlist playlist : pl) {
                        if (nomePlaylist.equals(playlist.getNome())) {
                            playlistEncontrada = playlist;
                            System.out.println("AQQQ3");
                            break;
                        }
                    }
                } catch (SelectionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               
                
                // Verificar se a playlist foi encontrada
                if (playlistEncontrada != null) {
                    // Limpar o modelo de lista das músicas da playlist
                    System.out.println("AQQQ");
    
                    try {
                        atualizarListaMusicasPlaylist(playlistEncontrada);
                        System.out.println("AQQQ33");
                    } catch (SelectionException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    // Configurar a lista de músicas da playlist com o novo modelo
                    //lista_Musicas_Playlist.setModel(playlistModel);
                } else {
                    // Exibir mensagem de erro se a playlist não for encontrada
                    JOptionPane.showMessageDialog(null, "Playlist não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            
            
        });

        botaoAdicionarMusicaPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nomePlaylistq = JOptionPane.showInputDialog("Nome da playlist:");
                String nomeMusicaq = JOptionPane.showInputDialog("Nome da música:");
                Playlist p15 = null; 
                Musica m15 = null;
                // Verificar se a playlist já existe
                try {
                    List<Playlist> pl = app.getPlaylistCadastradas();
                    for(Playlist p : pl){
                        if(nomePlaylistq.equals(p.getNome())){
                            p15 = p;
                            break;
                        }
                    }
                } catch (SelectionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                try {
                    List<Musica> mu = app.getMusicasCadastradas();
                    for(Musica m : mu){
                        if(nomeMusicaq.equals(m.getNome())){
                            m15 = m;
                            break;
                        }
                    }
                } catch (SelectionException e) {
                    e.printStackTrace();
                }

                if (p15 == null) {
                    JOptionPane.showMessageDialog(null, "Playlist não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (m15 == null) {
                    JOptionPane.showMessageDialog(null, "Música não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        app.adicionarMusicaPlay(m15, p15);
                    } catch (InsertException | SelectionException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Música adicionada à playlist com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        botaoRemoverMusicaPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String nomePlaylistqi = JOptionPane.showInputDialog("Nome da playlist:");
                String nomeMusicaqi = JOptionPane.showInputDialog("Nome da música:");
                Playlist p16 = new Playlist();
                Musica m16 = new Musica();
                
                try {
                    for(Playlist pl : app.getPlaylistCadastradas()){
                        if(nomePlaylistqi.equals(pl.getNome())){
                            p16 = pl;
                            break;
                        }
                    }
                } catch (SelectionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                try {
                    for(Musica m : app.getMusicasCadastradas()){
                        if(nomeMusicaqi.equals(m.getNome())){
                            m16 = m;
                            break;
                        }
                    }
                } catch (SelectionException e) {
                    e.printStackTrace();
                }

                if (p16 != null) {
                    // A playlist existe, então remova a música dela
                    if (m16 != null) {
                        try {
                            app.removerMusicaPlay(m16, p16);
                        } catch (DeleteException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "Música removida da playlist com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Música não encontrada na playlist.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Playlist não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }

    private void atualizarListaMusicasPlaylist(Playlist playlist) throws SelectionException {
        lista_Musicas_Playlist.setModel(new AbstractListModel<String>() {
            List<Musica> musicas = app.pegarMusicasPlaylist(playlist); // Supondo que app é sua instância de App onde você implementou pegarMusicasPlaylist
            public int getSize() { return musicas.size(); }
            public String getElementAt(int i) { return musicas.get(i).getNome(); 
            }
        });
        System.out.println("agr aqq");
    }

    private void atualizarListaPlaylists() throws SelectionException {
        lista_Playlist.setModel(new AbstractListModel<String>() {
            List<Playlist> playlistsNames = app.getPlaylistCadastradas(); // Use the ArrayList
            public int getSize() { return playlistsNames.size(); }
            public String getElementAt(int i) { return playlistsNames.get(i).getNome(); }
            });
    }

    private void atualizarListaMusicasFavoritas() throws InsertException, SelectionException {
        listaMusicaCurtida.setModel(new AbstractListModel<String>() {
            List<Musica> musicNamesList = app.getMusicasFavoritas();
    
            public int getSize() { return musicNamesList.size(); }
    
            public String getElementAt(int i) { return musicNamesList.get(i).getNome(); }
        });
    }

    private void atualizarListaCantores() throws SelectionException {
        lista_Cantores.setModel(new AbstractListModel<String>() {
            List<Cantor> cantorsNamesList = app.getCantoresCadastrados(); // Use the ArrayList
        
            public int getSize() { return cantorsNamesList.size(); }
        
            public String getElementAt(int i) { return cantorsNamesList.get(i).getNome(); }
        });
    }
}
