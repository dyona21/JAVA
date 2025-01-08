package negocio;
import dados.*;
import java.util.*;

public class CadastroDeVeiculos {
    List<Automovel> automoveis = new ArrayList<Automovel>();
    Scanner ler = new Scanner(System.in);
    
    public boolean cadastrandoAutomoveis(Automovel automovel){ 
        automoveis.add(automovel);
        return true;
    }

    public Automovel lendoDadosAutomovel(){
        System.out.println("Vai ser moto(1) ou carro(2)?");
        
        int escolha = Integer.parseInt(ler.nextLine());
        
        if(escolha == 1){
            Moto a = new Moto();
            
            System.out.println("Ano de fabricação:");
            a.setAnoFabricacao(Integer.parseInt(ler.nextLine()));
            System.out.println("Placa:");
            a.setPlaca(ler.nextLine());
            System.out.println("Modelo:");
            a.setModelo(ler.nextLine());
            System.out.println("Marca:");
            a.setMarca(ler.nextLine());
            System.out.println("Cor:");
            a.setCor(ler.nextLine());
            System.out.println("Tem capa de chuva?");
            a.setCapaChuva(ler.nextLine());
            System.out.println("Tem capacete?");
            a.setCapacete(ler.nextLine());
            
            return a;
        
        } else if(escolha == 2){
            Carro a = new Carro();
            
            System.out.println("Ano de fabricação:");
            a.setAnoFabricacao(Integer.parseInt(ler.nextLine()));
            System.out.println("Placa:");
            a.setPlaca(ler.nextLine());
            System.out.println("Modelo:");
            a.setModelo(ler.nextLine());
            System.out.println("Marca:");
            a.setMarca(ler.nextLine());
            System.out.println("Cor:");
            a.setCor(ler.nextLine());
            System.out.println("Tem ar condicionado?");
            a.setArCondicionado(ler.nextLine());
            System.out.println("Tem direção hidráulica?");
            a.setDirecaoHidraulica(ler.nextLine());
        
            return a;
        } else {
            return null;
        }
    }
    public boolean removerAutomovel(Automovel automovel){
        automoveis.remove(automovel);
        return true;
    }

    public Automovel escolhendoAutomovelParaRemover(){
        System.out.println("Digite a placa do automóvel a ser removido:");
        String placa = ler.nextLine();
        int contador = 0;
        for(Automovel automovel : automoveis){
            if(automovel.getPlaca().equals(placa)){
                return automoveis.get(contador);
            } 
            contador++;
        }
        return null;
    }

    public boolean verificandoSeContemElemento(){
        System.out.println("Digite a cor do automóvel que você quer verificar:");
        String cor = ler.nextLine();
        System.out.println("Digite a marca do automóvel que você quer verificar:");
        String marca = ler.nextLine();

        for (Automovel automovel : automoveis) {
            if(automovel.getCor().equals(cor) && automovel.getMarca().equals(marca)){
                return true;
            }
        }
    
        return false;
    }

    public void imprimindoAutomoveis(){
        for (Automovel automovel : automoveis) {
            System.out.println(automovel.toString());
        }
    }

}
