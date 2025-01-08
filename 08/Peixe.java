public class Peixe extends Animal {
    private float tempIdeal;
    
    public void calculaEspacoOcupado(){
        return super.largura * super.comprimento;
    }

    public float getTempIdeal() {
        return tempIdeal;
    }

    public void setTempIdeal(float tempIdeal) {
        this.tempIdeal = tempIdeal;
    }

    @Override
    public String toString() {
        return "Peixe [tempIdeal=" + tempIdeal + "]";
    }
}
