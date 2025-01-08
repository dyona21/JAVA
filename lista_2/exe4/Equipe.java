package exe4;

import java.util.ArrayList;
import java.util.List;

public class Equipe<T> {
    private List<Aluno> membros;

    public Equipe() {
        this.membros = new ArrayList<>();
    }

    public List<Aluno> getMembros() {
        return membros;
    }

    public void adicionarMembro(Aluno aluno) {
        membros.add(aluno);
    }

    @Override
    public String toString() {
        return "Equipe [Membros:" + membros + "]";
    }

}
