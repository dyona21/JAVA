package quest3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaArquivos {
    private Map<String, List<Arquivo>> diretorios;

    public SistemaArquivos() {
        diretorios = new HashMap<>();
    }

    public void criarDocumento(String nomeDiretorio, String nomeArquivo, String texto) throws NomeInvalidoException {
        Documento documento = new Documento(nomeArquivo, texto);
        adicionarArquivo(nomeDiretorio, documento);
    }

    public void criarMusica(String nomeDiretorio, String nomeArquivo, int duracao) throws NomeInvalidoException {
        Musica musica = new Musica(nomeArquivo, duracao);
        adicionarArquivo(nomeDiretorio, musica);
    }

    public void criarVideo(String nomeDiretorio, String nomeArquivo, Video.Qualidade qualidade) throws NomeInvalidoException {
        Video video = new Video(nomeArquivo, qualidade);
        adicionarArquivo(nomeDiretorio, video);
    }

    private void adicionarArquivo(String nomeDiretorio, Arquivo arquivo) {
        diretorios.computeIfAbsent(nomeDiretorio, k -> new ArrayList<>()).add(arquivo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Arquivo>> entry : diretorios.entrySet()) {
            sb.append(entry.getKey()).append(" :\n");
            for (Arquivo arquivo : entry.getValue()) {
                sb.append(arquivo).append("\n");
            }
        }
        return sb.toString();
    }
}
