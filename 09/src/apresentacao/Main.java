package apresentacao;
import java.util.*;
import dados.*;
import negocio.*;
public class Main {
    public static Scanner ler = new Scanner(System.in);
    public static ListaTelefonica lista = new ListaTelefonica();
    public static void main(String[] args) {
        int escolha = -1;
        while(escolha != 0){
            menu();
            escolha = Integer.parseInt(ler.nextLine());
            switch (escolha) {
                case 1:
                    cadastrarContato(novoContato());
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
                    break;
                default:
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("Escolha uma opção:");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar um contato");
        System.out.println("2 - Remover um contato");
        System.out.println("3 - Mostrar todos os contatos");
    }

    public static void cadastrarContato(Contato contato){
        lista.adicionarContato(contato);
    }

    public static Contato novoContato(){
        Contato c = new Contato();
        System.out.println("Nome:");
        c.setNome(ler.nextLine());
        System.out.println("Telefone:");
        c.setTelefone(Integer.parseInt(ler.nextLine()));
        
        return c;
    }

    public static void exibirContatos(char letra){
        for(int i = 0; i < lista.buscarContatos(letra).size(); i++){
            System.out.println("Codigo: " + i);
            System.out.println(lista.buscarContatos(letra).get(i).toString());
        }
    }

    public static void removerContato(){
        System.out.println("Digite a letra do contato que você quer remover:");
        String l = ler.nextLine().toUpperCase();

        if(lista.buscarContatos(l.charAt(0)).size() > 0){
            exibirContatos(l.charAt(0));
        
        
            if (ler.hasNextInt()) {
                int index = ler.nextInt();
                if (index < lista.buscarContatos(l.charAt(0)).size()) {
                    lista.removerContato(lista.buscarContatos(l.charAt(0)).get(index));
                }
            }

        } else {
            System.out.println("Não existem contatos para serem removidos");
        }
    }

    public static void exibirContatos() {

        lista.buscarContatos().forEach((chave, lista) -> {

            System.out.println(chave + ":");

            for (Contato contato : lista) {

                System.out.println("  " + contato.toString());

            }

        });

    }
        
}

