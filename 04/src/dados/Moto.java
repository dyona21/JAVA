package dados;

public class Moto extends Automovel {

    private String capaChuva;
    private String capacete;
    
    public String getCapaChuva() {
        return capaChuva;
    }
    public void setCapaChuva(String capaChuva) {
        this.capaChuva = capaChuva;
    }
    public String getCapacete() {
        return capacete;
    }
    public void setCapacete(String capacete) {
        this.capacete = capacete;
    }
    
    @Override
    public String toString() {
        return "Moto [Ano de fabricação:" + anoFabricacao + ", capa de chuva:" + capaChuva + ", placa:" + placa + ", capacete:"
                + capacete + ", modelo:" + modelo + ", marca:" + marca + ", cor:" + cor + "]";
    }
    
}
