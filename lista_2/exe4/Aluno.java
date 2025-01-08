package exe4;

import java.util.List;

public class Aluno {
    private String nome;   
    private int idade;   
    private List<Double> notas;
    
    
    public List<Double> getNota() {
        return notas;
    }
    public void setNota(List<Double> notas) {
        this.notas = notas;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    @Override
    public String toString() {
        return "Aluno [Nome:" + nome + ", idade:" + idade + ", notas:" + notas + "]";
    }
    
    public double calcularMedia(){
        double media, soma = 0;
        for(int i = 0; i < 5; i++){
            soma += notas.get(i);
        }
        media = soma/5;
        
        return media; 
    }
}
