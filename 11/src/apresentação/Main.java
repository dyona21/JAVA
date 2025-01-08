package apresentação;

import java.util.List;
import java.util.Scanner;

import dados.*;
import negocio.Zoologico;
import exeções.EspacoIndisponivelException;
import exeções.Sem_viveiroCadastradoException;

public class Main {
    public static Scanner ler = new Scanner(System.in);
    private static Zoologico zoo = new Zoologico();

    public static void main(String[] args) throws Sem_viveiroCadastradoException {
        menuPrincipal();
    }

    public static void exibeMenuPrincipal() {
        System.out.println("Escolha uma opção:");
        System.out.println("0 - Encerrar");
        System.out.println("1 - Cadastrar viveiro");
        System.out.println("2 - Cadastrar Animal");
        System.out.println("3 - Alocar animal");
        System.out.println("4 - Ver aquários");
        System.out.println("5 - Ver viveiros");
    }

    public static void menuPrincipal() throws Sem_viveiroCadastradoException {
        int opcao = -1;
        while (opcao != 0) {
            exibeMenuPrincipal();
            opcao = ler.nextInt();
            ler.nextLine(); // Limpa o buffer do scanner
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
                    mostrarAnimais();
                    break;
                case 5:
                    mostrarViveiros();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Número inválido");
                    break;
            }
        }
    }

    public static void cadastrarAnimais() {
        System.out.println("É animal terrestre(1) ou peixe(2)? Escolha de acordo com o número.");
        int escolha4 = Integer.parseInt(ler.nextLine());
        if (escolha4 == 1) {
            Animal animal = new Animal();
            System.out.println("Digite o nome do animal:");
            animal.setNome(ler.nextLine());
            System.out.println("Digite a cor do animal:");
            animal.setCor(ler.nextLine());
            System.out.println("Digite a espécie do animal:");
            animal.setEspecie(ler.nextLine());
            System.out.println("Digite a idade do animal:");
            animal.setIdade(Integer.parseInt(ler.nextLine()));
            System.out.println("Digite a altura do animal:");
            animal.setAltura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a largura do animal:");
            animal.setLargura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite o comprimento do animal:");
            animal.setComprimento(Float.parseFloat(ler.nextLine()));

            zoo.cadastrarAnimais(animal);
            System.out.println("Animal terrestre cadastrado.");

        } else if (escolha4 == 2) {
            Peixe p = new Peixe();
            System.out.println("Digite o nome do animal:");
            p.setNome(ler.nextLine());
            System.out.println("Digite a cor do animal:");
            p.setCor(ler.nextLine());
            System.out.println("Digite a espécie do animal:");
            p.setEspecie(ler.nextLine());
            System.out.println("Digite a idade do animal:");
            p.setIdade(Integer.parseInt(ler.nextLine()));
            System.out.println("Digite a altura do animal:");
            p.setAltura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a largura do animal:");
            p.setLargura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite o comprimento do animal:");
            p.setComprimento(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a temperatura ideal para o peixe sobreviver:");
            p.setTemperaturaIdeal(Float.parseFloat(ler.nextLine()));

            zoo.cadastrarAnimais(p);
            System.out.println("Peixe cadastrado.");
        }
    }

    public static void cadastrarViveiro() {
        System.out.println("É aquário(1) ou viveiro(2)? Escolha de acordo com o número.");
        int escolha3 = Integer.parseInt(ler.nextLine());
        if (escolha3 == 1) {
            Aquario aquario = new Aquario();
            System.out.println("Digite o comprimento:");
            aquario.setComprimento(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a largura:");
            aquario.setLargura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a temperatura da água:");
            aquario.setTemperatura(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a altura:");
            aquario.setAltura(Float.parseFloat(ler.nextLine()));

            zoo.cadastrarViveiro(aquario);
            System.out.println("Aquário cadastrado.");

        } else if (escolha3 == 2) {
            Viveiro viveiro = new Viveiro();
            System.out.println("Digite o comprimento:");
            viveiro.setComprimento(Float.parseFloat(ler.nextLine()));
            System.out.println("Digite a largura:");
            viveiro.setLargura(Float.parseFloat(ler.nextLine()));

            zoo.cadastrarViveiro(viveiro);
            System.out.println("Viveiro cadastrado.");
        }
    }

    public static void alocarAnimal() throws Sem_viveiroCadastradoException {
        if (zoo.getQuantidadeAnimais() > 0) {
            System.out.println("Selecione numericamente o animal que você quer alocar e em qual viveiro.");
            mostrarAnimais();
            int escolha = Integer.parseInt(ler.nextLine());
            mostrarViveiros();
            int escolha2 = Integer.parseInt(ler.nextLine());
            List<Animal> animal = zoo.getAnimais();
            List<Viveiro> viveiro = zoo.getViveiros();

            try {
                if (zoo.alocarAnimal(animal.get(escolha - 1), viveiro.get(escolha2 - 1))) {
                    System.out.println("Alocação bem sucedida.");
                } else {
                    System.out.println("Alocação não ocorreu.");
                }
            } catch (EspacoIndisponivelException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Não há animais cadastrados, impossível de alocar.");
        }
    }

    public static void mostrarAnimais() {
        if (zoo.getQuantidadeAnimais() <= 0) {
            System.out.println("Não há animais cadastrados.");
        } else {
            System.out.println("Os animais cadastrados são esses:");
            List<Animal> animais = zoo.getAnimais();
            for (int i = 0; i < animais.size(); i++) {
                System.out.format("%d - %s\n", i + 1, animais.get(i).toString());
            }
        }
    }

    public static void mostrarViveiros() {
        if (zoo.getQuantidadeViveiros() <= 0) {
            System.out.println("Não há viveiros cadastrados.");
        } else {
            System.out.println("Os viveiros cadastrados são esses:");
            List<Viveiro> viveiros = zoo.getViveiros();
            for (int i = 0; i < viveiros.size(); i++) {
                System.out.format("%d - %s\n", i + 1, viveiros.get(i).toString());
            }
        }
    }
}
