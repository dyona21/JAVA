package negocio;
import dados.Contato;
import exception.*;

import java.util.*;
import persistencia.*;
public class Listatelefonica {
    private ContatoDAO contatos;
    public void adicionarContato(Contato contato) throws InsertException, SelectException{
        contatos.insert(contato);
    }

    public void removerContato(Contato contato) throws DeleteException{
        contatos.delete(contato);
    }

    public void buscarContatos(int id) throws SelectException{ 
        contatos.select(id);

    }

    public List<Contato> buscarContatos() throws SelectException{
        return contatos.selectAll();
    }
}
