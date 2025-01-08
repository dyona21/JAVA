public class Aquario extends Viveiro {
    
    private float altura;
    private float temperatura;
    
    public float calculaEspaco(){
        return super.largura * super.comprimento * altura;
    }
    
    @Override
    public String toString() {
        return "Aquario [altura:" + altura + ", temperatura:" + temperatura + "]";
    }
    
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public float getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }


    
}
