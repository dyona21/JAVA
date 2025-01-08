package negocio;
import dados.Contato;
import java.util.*;

public class ListaTelefonica {
    Map<Character, List<Contato>> lista = new HashMap<Character, List<Contato>>();
    public ListaTelefonica(){
        
        for(char i = 65; i < 91; i++){
            List<Contato> nomes = new ArrayList<Contato>();
            lista.put(i, nomes);
        }
    }

    public void adicionarContato(Contato contato){
        String nome = contato.getNome().toUpperCase();
        lista.get(nome.charAt(0)).add(contato); 
    }

    public void removerContato(Contato contato){
        String nome = contato.getNome().toUpperCase();
        lista.get(nome.charAt(0)).add(contato);
    }

    public List<Contato> buscarContatos(Character letra){ 
        return lista.get(letra);

    }

    public Map<Character, List<Contato>> buscarContatos(){
        return lista;
    }
}
