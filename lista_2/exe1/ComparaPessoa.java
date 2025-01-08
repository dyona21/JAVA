package exe1;
import java.util.*;

public class ComparaPessoa {
    public static Scanner ler = new Scanner(System.in);
    static List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        System.out.println("Digite as informações das pessoas:");
        while(true){
            Pessoa p = new Pessoa();
            System.out.println("Digite o nome da pessoa:");
            String nome = ler.nextLine();
            if(nome.equals("-1")){
                break;
            }
            p.setNome(nome);
            
            System.out.println("Digite a idade da pessoa:");
            p.setIdade(Integer.parseInt(ler.nextLine()));
            
            System.out.println("Digite o cpf da pessoa:");
            p.setCpf(Long.parseLong(ler.nextLine()));
            
            System.out.println("Digite a cidade da pessoa:");
            p.setCidade(ler.nextLine());
            
            pessoas.add(p);
        }
        
        Collections.sort(pessoas);
        exibirPessoasPorFaixaEtaria(pessoas);
    }

    public static void exibirPessoasPorFaixaEtaria(List<Pessoa> pessoas) {
        Map<String, List<Pessoa>> faixasEtarias = new HashMap<>();
        faixasEtarias.put("Crianças", new ArrayList<>());
        faixasEtarias.put("Adolescentes", new ArrayList<>());
        faixasEtarias.put("Jovens", new ArrayList<>());
        faixasEtarias.put("Adultos", new ArrayList<>());
        faixasEtarias.put("Idosos", new ArrayList<>());

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getIdade() >= 1 && pessoa.getIdade() <= 12) {
                faixasEtarias.get("Crianças").add(pessoa);
            } else if (pessoa.getIdade() >= 13 && pessoa.getIdade() <= 18) {
                faixasEtarias.get("Adolescentes").add(pessoa);
            } else if (pessoa.getIdade() >= 19 && pessoa.getIdade() <= 25) {
                faixasEtarias.get("Jovens").add(pessoa);
            } else if (pessoa.getIdade() >= 26 && pessoa.getIdade() <= 59) {
                faixasEtarias.get("Adultos").add(pessoa);
            } else {
                faixasEtarias.get("Idosos").add(pessoa);
            }
        }

        for (Map.Entry<String, List<Pessoa>> entry : faixasEtarias.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Pessoa pessoa : entry.getValue()) {
                System.out.println(pessoa.toString());
            }
        }
    }
}