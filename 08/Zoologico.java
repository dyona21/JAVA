import java.util.*;

public class Zoologico {
    private Animal [] animais = new Animal[60];
    private int quantAnimais = 0;
    private Viveiro [] viveiros = new Viveiro[60];
    private int quantViveiros = 0;
    
    Scanner ler = new Scanner(System.in);

    public void cadastrarViveiro(Viveiro viveiro){
        viveiros[quantViveiros] = viveiro;
        quantViveiros++;
    }

    public Viveiro dadosViveiro(){
        int escolha;
        System.out.println("Vai ser um Aquario(1) ou Viveiro(2)?");
        escolha = Integer.parseInt(ler.nextLine());
        if(escolha == 1){
            Aquario aq = new Aquario();
            System.out.println("Digite o nome do aquario.");
            aq.setNome(ler.nextLine());
            System.out.println("Digite a altura:");
            aq.setAltura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite o comprimento.");
            aq.setComprimento(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a temperatura:");
            aq.setTemperatura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a largura:");
            aq.setLargura(Float.parseFloat(ler.nextLine()));
            
            return aq;
        } 
        if(escolha == 2){
            Viveiro v = new Viveiro();
            System.out.println("Digite o nome do viveiro.");
            v.setNome(ler.nextLine());
            System.out.println("Digite o comprimento.");
            v.setComprimento(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a largura:");
            v.setLargura(Float.parseFloat(ler.nextLine()));
            
            return v;
        }
    }

    public void cadastrarAnimal(Animal animal){
        animais[quantAnimais] = animal;
        quantAnimais++;
    }

    public Animal dadosAnimal(){
        int escolha;
        System.out.println("Cadastrar Peixe (1) ou Animal Terrestre (2)?");
        escolha = Integer.parseInt(ler.nextLine());
        if(escolha == 1){
            Peixe p = new Peixe();
            System.out.println("Digite o nome:");
            p.setNome(ler.nextLine());
            System.out.println("Digite a cor:");
            p.setCor(ler.nextLine());
            System.out.println("Digite a idade:");
            p.setIdade(Integer.parseInt(ler.nextLine()));
            System.out.println("Digite a altura:");
            p.setAltura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a largura:");
            p.setLargura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite o comprimento:");
            p.setComprimento(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a temperatura ideal:");
            p.setTemperatura(Float.parseFloat(ler.nextLine()));

            return p;
        }

        if(escolha == 2){
            Animal a = new Animal();
            System.out.println("Nome:");
            a.setNome(ler.nextLine());
            System.out.println("Idade:");
            a.setIdade(Integer.parseInt(ler.nextLine()));
            System.out.println("largura:");
            a.setLargura(Float.parseFloat(ler.nextLine()));
            System.out.println("Altura:");
            a.setAltura(Float.parseFloat(ler.nextLine()));
            System.out.println("Comprimento:");
            a.setComprimento(Float.parseFloat(ler.nextLine()));
            System.out.println("Cor:");
            a.setCor(ler.nextLine());

            return a;
        }
    }

    public boolean alocarAnimal(Viveiro viveiro, Animal animal){
        return viveiro.adicionarAnimal(animal);
    }

    
}


