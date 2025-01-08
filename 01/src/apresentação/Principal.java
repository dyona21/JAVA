package apresentação;
import java.util.Scanner;

import dados.*;
import negocio.*;
public class Principal {
    

    public static void main(String[] args) {
      
        

        
    }

    public static void exibeMenuPrincipal() {
        System.out.println("Escolha uma opção:");
        System.out.println("0 - Encerrar");
        System.out.println("1 - Realizar Reserva");
        System.out.println("2 - Cadastrar Cliente");
        System.out.println("3 - Mostrar Reservas");
        System.out.println("4 - Cadastrar Cidade");
    }
    
    public static void menuPrincipal() {
        int opcao = -1;
        while (opcao != 0) {
            exibeMenuPrincipal();
            opcao = s.nextInt();
            switch (opcao) {
            case 1:
                System.out.println("Realizar Reserva");
                realizarReserva();
                break;
            case 2:
                System.out.println("Cadastrar Cliente");
                cadastrarCliente();
                break;
            case 3:
                System.out.println("Mostrar Reservas");
                mostrarReservas();
                break;
            case 4:
                System.out.println("Cadastrar Cidade");
                cadastrarCidade();
                break;
            default:
                System.out.println("Número inválido");
                break;
            }
        }
    }

    public static void cadastrarCliente(){
        Scanner ler = new Scanner(System.in);
        System.out.format("Digite as informações do cliente (nome, cpf, telefone e endereço).\n");
        
        System.out.format("Nome:\n");
        String nome = ler.nextLine();
        System.out.format("CPf:\n");
        String cpf = ler.nextLine();
        System.out.format("Telefone:\n");
        int telefone = Integer.parseInt(ler.nextLine());
        System.out.format("Endereço:\n");
        String endereco = ler.nextLine();
        
        Cliente cliente = new Cliente(cpf, telefone, nome, endereco);
        
        
    }

    public static void cadastrarCidade(){
        Scanner ler = new Scanner(System.in);
        System.out.format("Digite as informações da cidade (nome, estado).\n");
        System.out.format("Nome:\n");
        String nome = ler.nextLine();
        System.out.format("Estado:\n");
        String estado = ler.nextLine();

        Cidade cidade = new Cidade(nome, estado);
        listaCidades[quantidadeCidades] = cidade;
    }

}
