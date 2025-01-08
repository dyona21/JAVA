package questao2.dados;

public class TrianguloEquilatero extends FigurasGeometricas{
    
    public void setLado(int valor){
        super.medida1 = valor;
    }
    
    public int calculaArea(){
        return (int) ((Math.sqrt(3)/4) * (medida1 * medida1));
    }

    public int calculaPerimetro(){
        return (int) 3 * medida1;
    }

    @Override
    public String toString() {
        return "Triangulo Equilatero [ Perímetro:" + calculaPerimetro() + " área:" + calculaArea() + "]";
    }
    
}
