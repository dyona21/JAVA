package questao2.dados;

public class Circulo extends FigurasGeometricas {
    public void setRaio(int valor){
        super.medida1 = valor;
        super.medida2 = 2 * valor;
    }

    public int calculaArea(){
        return (int) (3.14 * (medida1 * medida1));
    }

    public int calculaPerimetro(){
        return (int) (3.14 * medida2);
    }

    @Override
    public String toString() {
        return "Circulo [Perímetro:" + calculaPerimetro() + " área:" + calculaArea()+"]";
    }

    
}
