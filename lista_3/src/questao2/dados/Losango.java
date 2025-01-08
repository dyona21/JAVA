package questao2.dados;

public class Losango extends FigurasGeometricas{
    
    public void setD(int valor){
        super.medida1 = valor;
    }

    public void setd(int valor){
        super.medida2 = valor;
    }

    public int calculaArea(){
        return (int) ((medida1 * medida2)/2);
    }

    public int calculaPerimetro(){
        int l = (int) Math.sqrt(((medida1 * medida1)/4) + ((medida2 * medida2)/4));
        
        return 4 * l; 
    }

    @Override
    public String toString() {
        return "Losango [Perímetro:" + calculaPerimetro() + " área:" + calculaArea() + "]";
    }

    
}
