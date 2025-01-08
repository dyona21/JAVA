package exe4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Turma {
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Turma turma = new Turma();

        System.out.println("Digite as informações dos alunos:");
        while (true) {
            Aluno aluno = new Aluno();

            System.out.println("Digite o nome do aluno:");
            String nome = scanner.nextLine();
            if (nome.equals("-1")) {
                break;
            }
            aluno.setNome(nome);

            System.out.println("Digite a idade do aluno:");
            int idade = Integer.parseInt(scanner.nextLine());
            aluno.setIdade(idade);

            System.out.println("Digite as cinco notas do aluno:");
            List<Double> notas = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                double nota = Double.parseDouble(scanner.nextLine());
                notas.add(nota);
            }
            aluno.setNota(notas);

            turma.adicionarAluno(aluno);
        }

        scanner.close();

        turma.ordenarAlunosPorMedia();
        Map<Integer, Equipe> equipes = turma.separarEmEquipes();

        exibirEquipes(equipes);
    }

    public static void exibirEquipes(Map<Integer, Equipe> equipes) {
        for (Map.Entry<Integer, Equipe> entry : equipes.entrySet()) {
            int equipeId = entry.getKey();
            Equipe equipe = entry.getValue();
            System.out.println("Equipe " + equipeId + ":");
            for (Object obj : equipe.getMembros()) {
                Aluno aluno = (Aluno) obj;
                System.out.println("- Nome: " + aluno.getNome() + ", Média: " + aluno.calcularMedia());
            }
            System.out.println();
        }
    }
    

    public Turma() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    private void ordenarAlunosPorMedia() {
        Collections.sort(alunos, new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return Double.compare(a1.calcularMedia(), a2.calcularMedia());
            }
        });
    }
    //A separação está sendo feita de acordo com a média, pessoas com a média mais alta ficam juntas, pessoas com a média mais baixa também ficam juntas. 
    public Map<Integer, Equipe> separarEmEquipes() {
        Map<Integer, Equipe> equipes = new HashMap<>();
      
        Collections.sort(alunos, (a1, a2) -> Double.compare(a2.calcularMedia(), a1.calcularMedia()));

        int numAlunos = alunos.size();
        int equipeId = 1;

        for (int i = 0; i < numAlunos; i += 4) {
            Equipe equipe = new Equipe();
            for (int j = i; j < Math.min(i + 4, numAlunos); j++) {
                Aluno aluno = alunos.get(j);
                equipe.adicionarMembro(aluno);
            }
            equipes.put(equipeId++, equipe);
        }

        return equipes;
    }
}
