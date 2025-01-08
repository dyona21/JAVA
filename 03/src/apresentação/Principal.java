package apresentação;

import java.util.Scanner;

import dados.*;
import negocio.*;
public class Principal {
    
    private static Scanner ler = new Scanner(System.in);
    private static ReservaPassagem reservarPassagem = new ReservaPassagem();
    
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
    
    public static void realizarReserva() {

            Cliente c = escolherCliente();

            if (c != null) {
                int escolher_oq_fazer = -1;

                while(escolher_oq_fazer != 0){
                    System.out.println("Digite 0 para Sair");
                    System.out.println("Digite 1 para reservar somente a Ida");
                    System.out.println("Digite 2 para reservar Ida e Volta");
                    escolher_oq_fazer = ler.nextInt();

                    switch (escolher_oq_fazer) {
                    case 1:
                        Reserva r = novaReserva();
                        reservarPassagem.reservarIda(c, r);
                        break;
                    case 2:
                        Reserva r1 = novaReserva();
                        System.out.format("Cadastrando volta.\n");
                        Reserva volta = novaReserva();
                        reservarPassagem.reservarVolta(c, r1, volta);
                        break;
                    default:
                        System.out.println("Numero invalido");
                        break;
                    }

                }

            }

        }
        
     
    
    public static Reserva novaReserva() {
        Reserva r = new Reserva();
        String vazio = ler.nextLine();//limpar o buffer do teclado
        System.out.println("Digite a data do voo:");
         r.setDataVoo(ler.nextLine());
        
        System.out.println("Digite a hora do voo:");
        r.setHoraVoo(ler.nextLine());

        System.out.println("Digite o preço do voo:");
        r.setPreco(ler.nextFloat());
        String vazio2 = ler.nextLine();//limpar o buffer do teclado

        System.out.println("Digite a classe do voo:");
        r.setClasseVoo(ler.nextLine());

        System.out.println("Digite a poltrona no voo:");
        r.setNumeroPoltrona(Integer.parseInt(ler.nextLine()));

        Cidade origem = escolherCidade();
        Cidade destino = escolherCidade();

        r.setOrigem(origem);
        r.setDestino(destino);

        return r;

    }

    public static Cliente novoCliente() {
        Cliente c = new Cliente();

        System.out.println("Digite o cpf:");
        c.setCpf(Long.parseLong(ler.nextLine()));

        System.out.println("Digite o nome:");
        c.setNome2(ler.nextLine());

        System.out.println("Digite o endereço:");
        c.setEndereco(ler.nextLine());  

        System.out.println("Digite o telefone:");
        c.setTelefone( ler.nextInt());

        System.out.format("Cliente cadastrado com sucesso.\n");
        return c;
    }

    public static void cadastrarCliente() {
        reservarPassagem.cadastrarClienteReserva(novoCliente());
    }

    public static void mostrarClientes() {
        if(reservarPassagem.getQuantidadeClientes() >= 1){
            for (Cliente c : reservarPassagem.mostrarClientes()) {
                if(c == null){
                    return; 
                }
                System.out.println(c.toString());
                
            }
        } else{
            System.out.format("Não tem clientes cadastrados.\n");
        }
        
    }

    public static Cliente escolherCliente() {
        
        mostrarClientes();
        
        if(reservarPassagem.getQuantidadeClientes() > 0){
            
            System.out.println("Digite o CPF do cliente escolhido:");

            Cliente c = reservarPassagem.buscarCliente(Long.parseLong(ler.nextLine()));
            if (c != null) {
                return c;
            }
        }
            
        return null;
    }

    public static Cidade novaCidade() {
        Cidade c = new Cidade();
    
        System.out.println("Digite o nome da cidade:");
        c.setNome1(ler.nextLine());

        System.out.println("Digite o estado da cidade");
        c.setEstado(ler.nextLine());
        
        return c;
    
    }

    public static void cadastrarCidade() {

        reservarPassagem.cadastrarCidadeReserva(novaCidade());

    }

    public static void mostrarCidades() {
        if(reservarPassagem.getQuantidadeCidades() >= 1){
            for (int i = 0; i < reservarPassagem.mostrarCidades().length; i++) {
                if(reservarPassagem.mostrarCidades()[i] != null){
                    System.out.println("Cidade " + (i+1));
                    System.out.println(reservarPassagem.mostrarCidades()[i].toStringCidade());
                } else {
                    return;
                }
            }
        } else {
            return;
        }
        
    }

    public static Cidade escolherCidade() {
        if(reservarPassagem.getQuantidadeCidades() == 0){
            System.out.format("Não tem cidade cadastradas.\n");
            return null;
        }
        mostrarCidades();
        System.out.println("Escolha uma cidade:");
        int codigo = Integer.parseInt(ler.nextLine());

        if (codigo > reservarPassagem.mostrarCidades().length) {
            System.out.println("Cidade inválida");
            return null;
        } else {
            Cidade []listCidades = new Cidade[50];
            listCidades = reservarPassagem.getlistaCidades();
            return listCidades[codigo];

        }
    }

    public static void mostrarReservas(){

        Cliente c = escolherCliente();

        if( c != null) {
            for(int i = 0; i < c.getQuantidadeReserva(); i++){
                System.out.println(c.getReservas()[i].toStringReserva());
            }
        } else {
            System.out.println("CPF invalido ou Cliente inexistente!");
        }       
    }
}

    



