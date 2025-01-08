package dados;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Musica {
    private int id_musica;
    private String nome;
    private int duracao; // em segundos
    private int anoLancamento;
    private String estilo;
    private List<Integer> avaliacoes = new ArrayList<Integer>();
    private List<Cantor> cantores = new ArrayList<Cantor>();
    
    private byte[] musica;

    public byte[] getMusica() {
        return musica;
    }

    public void setMusica(byte[] musica) {
        this.musica = musica;
    }

    public double getAvaliacaoMedia() {
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (int avaliacao : avaliacoes) {
            total += avaliacao;
        }
        return (double) total / avaliacoes.size();
    }

    public void adicionarAvaliacao(int avaliacao) {
        if (avaliacao >= 1 && avaliacao <= 5) {
            avaliacoes.add(avaliacao);
        } else {
            System.out.println("Avaliação inválida. A avaliação deve ser um número entre 1 e 5.");
        }
    }

    public void tocarPrevia() {
        try {
            FileInputStream fileInputStream = new FileInputStream("song.mp3");
            Player player = new Player(fileInputStream);
            System.out.println("Tocando prévia da música: " + nome); // Corrigido para acessar o nome da música
            player.play(300); // Toca apenas uma prévia da música
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
    
    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public List<Cantor> getCantores() {
        return cantores;
    }

    public void setCantores(Cantor cantores) {
        this.cantores.add(cantores);
    }

    public String getTitulo() {
        return nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

   

    @Override
    public String toString() {
        return "Musica [Nome:" + nome + ", duração:" + duracao + ", ano de lançamento:" + anoLancamento + 
             ", estilo:" + estilo.toString() + ", média avaliação:" + getAvaliacaoMedia() + ", cantores:" + cantores.toString() + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getId_musica() {
        return id_musica;
    }

    public void setId_musica(int id_musica) {
        this.id_musica = id_musica;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Musica other = (Musica) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (duracao != other.duracao)
            return false;
        if (anoLancamento != other.anoLancamento)
            return false;
        if (estilo == null) {
            if (other.estilo != null)
                return false;
        } else if (!estilo.equals(other.estilo))
            return false;
        return true;
    }

   


}
