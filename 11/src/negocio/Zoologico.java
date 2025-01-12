package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.Animal;
import dados.Aquario;
import dados.Peixe;
import dados.Viveiro;
import exeções.*;

public class Zoologico {

    private List<Animal> animais;
    private List<Viveiro> viveiros;

    public Zoologico() {
        this.animais = new ArrayList<>();
        this.viveiros = new ArrayList<>();
    }

    public void cadastrarViveiro(Viveiro viveiro) {
        this.viveiros.add(viveiro);
    }

    public void cadastrarAnimais(Animal animal) {
        this.animais.add(animal);
    }

    public List<Animal> mostrarAnimais() {
        return this.animais;
    }

    public List<Viveiro> mostrarViveiros() {
        return this.viveiros;
    }

    public boolean alocarAnimal(Animal animal, Viveiro viveiro) throws EspacoIndisponivelException, Sem_viveiroCadastradoException {
        if(viveiros.size() > 0){
            if (viveiro instanceof Aquario) {
                if (animal instanceof Peixe) {
                    Aquario aquario = (Aquario) viveiro;
                    Peixe peixe = (Peixe) animal;
    
                    float larguraDisponivel = aquario.larguraDisponivel();
                    float comprimentoDisponivel = aquario.comprimentoDisponivel();
                    float alturaDisponivel = aquario.alturaDisponivel();
                    float temperaturaAquario = aquario.getTemperatura();
    
                    if (larguraDisponivel > 0.7 * peixe.getLargura() &&
                        comprimentoDisponivel > 0.7 * peixe.getComprimento() &&
                        alturaDisponivel > 0.7 * peixe.getAltura()) {
    
                        float temperaturaMaxima = peixe.getTemperaturaIdeal() + 3;
                        float temperaturaMinima = peixe.getTemperaturaIdeal() - 3;
    
                        if (temperaturaAquario < temperaturaMaxima && temperaturaAquario > temperaturaMinima) {
                            aquario.addAnimal(peixe);
                        } else {
                            throw new EspacoIndisponivelException("Não há espaço no aquário para esse peixe");
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                if (animal instanceof Peixe) {
                    return false;
                } else {
                    float larguraDisponivel = viveiro.larguraDisponivel();
                    float comprimentoDisponivel = viveiro.comprimentoDisponivel();
    
                    if (larguraDisponivel > 0.7 * animal.getLargura() &&
                        comprimentoDisponivel > 0.7 * animal.getComprimento()) {
                        viveiro.addAnimal(animal);
                    } else {
                        throw new EspacoIndisponivelException("Não há espaço disponível no viveiro para esse animal");
                    }
                    return true;
                }
            }
    
        } else {
            throw new Sem_viveiroCadastradoException("Não há viveiros cadastrados.");
        }
        
    }

    public int getQuantidadeAnimais() {
        return this.animais.size();
    }

    public int getQuantidadeViveiros() {
        return this.viveiros.size();
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public List<Viveiro> getViveiros() {
        return viveiros;
    }
}
