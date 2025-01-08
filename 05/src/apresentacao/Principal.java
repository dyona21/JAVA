package apresentacao;
import java.util.Scanner;

import dados.*;
import negocio.Zoologico;

public class Principal {
    public static Scanner ler = new Scanner(System.in);
    private static Zoologico zoo = new Zoologico();
    
    public static void main(String[] args) {
        
        menuPrincipal();
        
    }

    public static void exibeMenuPrincipal() {
        System.out.println("Escolha uma opção:");
        System.out.println("0 - Encerrar");
        System.out.println("1 - Cadastrar viveiro");
        System.out.println("2 - Cadastrar Animal");
        System.out.println("3 - Alocar animal");
        System.out.println("4 - Ver aquarios");
        System.out.println("5 - Ver viveiros");
    }

    public static void menuPrincipal() {
        
        int opcao = -1;
        while (opcao != 0) {
            exibeMenuPrincipal();
            opcao = ler.nextInt();
            String vazio = ler.nextLine();
            switch (opcao) {
            case 1:
                System.out.println("Realizar cadastro de viveiro:\n");
                cadastrarViveiro();
                break;
            case 2:
                System.out.println("Realizar cadastro de animal:\n");
                cadastrarAnimais();
                break;
            case 3:
                System.out.println("Alocando animal:\n");
                alocarAnimal();
                break;
            case 4:
                System.out.println("Vendo apenas os aquarios:\n");
                mostrarApenasAquarios();
                break;
            case 5:
                System.out.println("Vendo apenans os viveiros:\n");
                mostrarApenasViveiros();
                break;
            default:
                System.out.println("Número inválido");
                break;
            }
        }
        
    }
    

    public static void cadastrarAnimais(){
        System.out.format("É animal terrestre(1) ou peixe(2)? Escolha de acordo com o número.\n");
        int escolha4 = Integer.parseInt(ler.nextLine());
        if(escolha4 == 1){
            Animal animal = new Animal();
            System.out.format("Digite o nome do animal:\n");
            animal.setNome(ler.nextLine());
            System.out.format("Digeite a cor do animal:\n");
            animal.setCor(ler.nextLine());
            System.out.format("Digeite a espécie do animal:\n");
            animal.setEspecie(ler.nextLine());
            System.out.format("Digite a idade do animal:\n");
            animal.setIdade(Integer.parseInt(ler.nextLine()));
            System.out.format("Digite a altura do animal:\n");
            animal.setAltura(Float.parseFloat(ler.nextLine()));
            System.out.format("Digite a largura do animal:\n");
            animal.setLargura(Float.parseFloat(ler.nextLine()));
            System.out.format("Digite o comprimento do animal:\n");
            animal.setComprimento(Float.parseFloat(ler.nextLine()));
            
            zoo.cadastrarAnimais(animal);
            System.out.format("Animal terrestre cadastrado.\n");

        } else if(escolha4 == 2){
            Peixe p = new Peixe();
            System.out.format("Digite o nome do animal:\n");
            p.setNome(ler.nextLine());
            System.out.format("Digeite a cor do animal:\n");
            p.setCor(ler.nextLine());
            System.out.format("Digeite a espécie do animal:\n");
            p.setEspecie(ler.nextLine());
            System.out.format("Digite a idade do animal:\n");
            p.setIdade(Integer.parseInt(ler.nextLine()));
            System.out.format("Digite a altura do animal:\n");
            p.setAltura(Float.parseFloat(ler.nextLine()));
            System.out.format("Digite a largura do animal:\n");
            p.setLargura(Float.parseFloat(ler.nextLine()));
            System.out.format("Digite o comprimento do animal:\n");
            p.setComprimento(Float.parseFloat(ler.nextLine()));
            System.out.format("Digite a temperatura ideal para o peixe sobreviver:\n");
            p.setTemperaturaIdeal(Float.parseFloat(ler.nextLine()));
            
            zoo.cadastrarAnimais(p);
            System.out.format("Peixe cadastrado.\n");
        }
    }

    public static void cadastrarViveiro(){
        
        System.out.format("É aquário(1) ou viveiro(2)? Escolha de acordo com o número.\n");
        int escolha3 = Integer.parseInt(ler.nextLine());
        if(escolha3 == 1){
            Aquario aquario = new Aquario();
            System.out.format("Digite o nome:\n");
            aquario.setNome(ler.nextLine());
            System.out.format("Digite o comprimento:\n");
            aquario.setComprimento(Float.parseFloat(ler.nextLine()));        
            System.out.format("Digite a largura:\n");
            aquario.setLargura(Float.parseFloat(ler.nextLine()));
            System.out.format("Digite a temperatura da água:\n");   
            aquario.setTemperatura(Float.parseFloat(ler.nextLine()));
            System.out.format("Digite a altura:\n");
            aquario.setAltura(Float.parseFloat(ler.nextLine()));
            
            zoo.cadastrarViveiro(aquario);
            System.out.format("Aquário cadastrado.\n");

        } else if(escolha3 == 2){
            Viveiro viveiro = new Viveiro();
            System.out.format("Digite o nome:\n");
            viveiro.setNome(ler.nextLine());
            System.out.format("Digite o comprimento:\n");
            viveiro.setComprimento(Float.parseFloat(ler.nextLine()));        
            System.out.format("Digite a largura:\n");
            viveiro.setLargura(Float.parseFloat(ler.nextLine())); 
                        
            zoo.cadastrarViveiro(viveiro);
            System.out.format("Viveiro cadastrado.\n");
        }
        
    }

    public static void alocarAnimal(){
        if(zoo.getQuantidadeAnimais() > 0){
            System.out.format("Selecione numericamente o animal que você quer cadastrar e em qual viveiro.\n");
            mostrarAnimais();
            int escolha = Integer.parseInt(ler.nextLine());
            mostrarViveiros();
            int escolha2 = Integer.parseInt(ler.nextLine());
            Animal []animal = zoo.getAnimais();
            Viveiro []viveiro = zoo.getViveiros();

            if(zoo.alocarAnimal(animal[escolha - 1], viveiro[escolha2 - 1])){
                System.out.format("Alocação bem sucedida.\n");
            } else {
                System.out.format("Alocação não ocorreu.\n");
            }
        } else{
            System.out.format("Não tem animais cadastrados, impossível de alocar.\n");
        }
    
    }

    public static void mostrarAnimais(){
        if(zoo.getQuantidadeAnimais() <= 0){
            System.out.format("Não tem animais cadastrados.\n");
        } else {
            System.out.format("Os animais cadastrados são esses:\n");
            for(int i = 0; i < zoo.getQuantidadeAnimais(); i++){
                System.out.format("%d-", i+1);
                System.out.println(zoo.getAnimais()[i].toString());
            }
        }
    }

    public static void mostrarViveiros(){
        if(zoo.getQuantidadeViveiros() <= 0){
            System.out.format("Não tem viveiros cadastrados.\n");
        } else {
            System.out.format("Os viveiros cadastrados são esses:\n");
            for(int i = 0; i < zoo.getQuantidadeViveiros(); i++){
                System.out.format("%d-", i+1);
                System.out.println(zoo.getViveiros()[i].toString());
            }
        }
    }

    public static void mostrarApenasViveiros(){
        Viveiro []viveiros = zoo.getSoViveiros();
            
        if(viveiros.length > 0){
            for(int i = 0; i < viveiros.length; i++){
                System.out.println(viveiros[i].toString());
            }
        } else{
            System.out.format("Não tem viveiros cadastrados.\n");
        }
        
    }

    public static void mostrarApenasAquarios(){
        Viveiro []aquarios = zoo.getSoAquarios();
        
        if(aquarios.length <= 0){
            System.out.format("Não tem aquários cadastrados.\n");
        } else {
            for(int i = 0; i < aquarios.length; i++){
                System.out.println(aquarios[i].toString());
            }
        }
            
    }

    
}
