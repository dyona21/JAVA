package dados;

public class Automovel {
    protected int anoFabricacao;
    protected String placa;
    protected String modelo;
    protected String marca;
    protected String cor;
    
    
    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    @Override
    public String toString() {
        return "Automóvel [ Ano de Fabricação:" + anoFabricacao + ", placa:" + placa + ", modelo:" + modelo
                + ", marca:" + marca + ", cor:" + cor + "]";
    }
}
