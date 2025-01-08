package negocio;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import dados.Circulo;
import dados.Forma_geometrica;
import dados.Quadrado;
import dados.Retangulo;
import dados.TrianguloEquilatero;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorFormasGEometricas {
    private List<Forma_geometrica> formas = new ArrayList<>();    

    public List<Forma_geometrica> getFormas() {
        return formas;
    }
    
    public void adicionarQuadrado(Quadrado q){
        formas.add(q);
    }

    public void salvarFMArquivo(String nomeArquivo){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Forma_geometrica forma : formas) {
                writer.write(forma.toString());
                writer.newLine();
            }

            System.out.println("Formas geometricas salvas no arquivo!!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar formas gemoetricas no arquivo");
            e.printStackTrace();
        }

    }

    public void adicionarRetangulo(Retangulo r){
        formas.add(r);
    }

    public void adicionarTriangulo(TrianguloEquilatero t){
        formas.add(t);
    }

    public void adicionarCirculo(Circulo c){
        formas.add(c);
    }

}
