package negocio;
import dados.*;

public class Zoologico {
    private Animal [] animais = new Animal[100];
    private Viveiro [] viveiros = new Viveiro[50];
    private int quantidadeAnimais = 0;
    private int quantidadeViveiros = 0;
    
    public void cadastrarViveiro(Viveiro viveiro){
        viveiros[quantidadeViveiros] = viveiro;
        quantidadeViveiros++;
    }

    public void cadastrarAnimais(Animal animal){
        animais[quantidadeAnimais] = animal;
        quantidadeAnimais++;
    }
    
    public Viveiro[] getSoViveiros(){
        int quant = 0;
        for(int i = 0; i < quantidadeViveiros; i++){
            if(!(viveiros[i] instanceof Aquario)){
                quant++;
            }

        }

        Viveiro viveiroTemp[] = new Viveiro[quant];
            
        int cont = 0;
        for(int i = 0; i < quantidadeViveiros; i++){
            if(!(viveiros[i] instanceof Aquario)){
                viveiroTemp[cont] = (Viveiro) viveiros[i];
                cont++;
            }
        }
        return viveiroTemp;
    }
    
    public Viveiro[] getSoAquarios(){
        int quant = 0;
        for(int i = 0; i < quantidadeViveiros; i++){
            if((viveiros[i] instanceof Aquario)){
                quant++;
            }
            
        }
            Aquario aquarioTemp[] = new Aquario[quant];
            
            int cont = 0;
            for(int i = 0; i < quantidadeViveiros; i++){
                if(viveiros[i] instanceof Aquario){
                    aquarioTemp[cont] = (Aquario) viveiros[i];
                    cont++;
                }
            }
        
        return aquarioTemp;
    }
    
    public boolean alocarAnimal(Animal animal, Viveiro viveiro){
            return viveiro.adicionarAnimal(animal);
    }
    
    public Animal[] getAnimais() {
        return animais;
    }
    public Viveiro[] getViveiros() {
        return viveiros;
    }
    public void setViveiros(Viveiro viveiro) {
        this.viveiros[quantidadeViveiros] = viveiro;
        quantidadeViveiros++;
    }
    public int getQuantidadeAnimais() {
        return quantidadeAnimais;
    }
    public int getQuantidadeViveiros() {
        return quantidadeViveiros;
    }
}
