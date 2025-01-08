package dados;

public class Aquario extends Viveiro{
    private float altura;
    private float temperatura; 

    public float calculaEspaco(){
        return largura * comprimento * altura;
    }
    @Override
    public boolean adicionarAnimal(Animal animal){
        if(espacoDisponivel() >= (animal.calculaEspacoOcupado() * 0.7)){
            if(animal instanceof Peixe){
                Peixe p = (Peixe) animal;
                if((p.getTemperaturaIdeal() < temperatura - 3) || (p.getTemperaturaIdeal() > temperatura + 3)){
                    return false;
                }
            } else {
                return false;
            }
            animais[quantidadeAnimais] = animal;
            quantidadeAnimais++;
            return true;
        } else {
            return false;
        }
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

    public String toString() {
        return "Aquario: nome = " + nome + ", altura = " + altura + ", temperatura = " + temperatura;
    }
}
