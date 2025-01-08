package dados;

public class Carro extends Automovel{
   @Override
    public String toString() {
        return "Carro [Ano de Fabricacao:" + anoFabricacao + ", ar condicionado:" + arCondicionado + ", placa:" + placa
            + ", direção hidraúlica:" + direcaoHidraulica + ", modelo:" + modelo + ", marca:" + marca + ", cor:"
            + cor + "]";
    }
    private String arCondicionado;
    private String direcaoHidraulica;


    public String getArCondicionado() {
        return arCondicionado;
    }
    public void setArCondicionado(String arCondicionado) {
        this.arCondicionado = arCondicionado;
    }
    public String getDirecaoHidraulica() {
        return direcaoHidraulica;
    }
    public void setDirecaoHidraulica(String direcaoHidraulica) {
        this.direcaoHidraulica = direcaoHidraulica;
    }
 
}
