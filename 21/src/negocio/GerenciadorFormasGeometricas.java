package negocio;
import java.util.*;

import dados.*;
public class GerenciadorFormasGeometricas {
    private List<FormaGeometrica> formas = new ArrayList<>();
        
    public void inserirQuadrado(Quadrado q){
        formas.add(q);
    }

    public void inserirRetangulo(Retangulo r){
        formas.add(r);
    }

    public void inserirCirculo(Circulo c){
        formas.add(c);
    }

    public void inserirTriangulo(TrianguloEquilatero t){
        formas.add(t);
    }

    public List<FormaGeometrica> getFormas(){
        return formas;
    }
}
