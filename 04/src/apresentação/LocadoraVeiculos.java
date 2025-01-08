package apresentação;
import java.util.*;
import dados.*;
import negocio.*;

public class LocadoraVeiculos {
    private static CadastroDeVeiculos veiculos = new CadastroDeVeiculos();
    public static Scanner ler = new Scanner(System.in);
    
    public static void main(String[] args) {
        int escolha;
        
        while(true){
            menu();
            escolha = Integer.parseInt(ler.nextLine());    
            switch (escolha) {
                case 1:
                        cadastrarVeiculo();
                    break;
                case 2:
                        removerVeiculo();
                    break;
                case 3:
                        verificaCarro();
                    break;
                case 4:
                        exibindoAutomoveis();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("Escolha a ação que você quer realizar.");
        System.out.println("1-Cadastrar veículo.");
        System.out.println("2-Remover veículo.");
        System.out.println("3-Verificar se contém determinado veículo.");
        System.out.println("4-Imprimir veículos cadastrados.");
        System.out.println("5-Sair.");
    }

    public static void cadastrarVeiculo(){
        if(veiculos.cadastrandoAutomoveis(veiculos.lendoDadosAutomovel())){
            System.out.println("Cadastro realizado com sucesso.");
        } else {
            System.out.println("Cadastro não realizado.");
        }
    }

    public static void removerVeiculo(){
        if(veiculos.removerAutomovel(veiculos.escolhendoAutomovelParaRemover())){
            System.out.println("Remoção feita com sucesso.");
        } else {
            System.out.println("Remoção não foi feita.");
        }
    }

    public static void verificaCarro(){
        if(veiculos.verificandoSeContemElemento()){
            System.out.println("Contém o automovél que foi pedido.");
        } else {
            System.out.println("Não contém o automovél que foi pedido.");
        }
    }

    public static void exibindoAutomoveis(){
        veiculos.imprimindoAutomoveis();
    }

}
