package exercicio03;
import java.util.ArrayList;

public class Imobiliaria {
	private String nome;
    private ArrayList<Imovel> imoveis;

    public Imobiliaria(String nome) {
        this.nome = nome;
        this.imoveis = new ArrayList<>();
    }

    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public Imovel[] filtrarPorArea(double x) {
        ArrayList<Imovel> filtrados = new ArrayList<>();
        for (Imovel imovel : imoveis) {
            if (imovel.calcularArea() >= x) {
                filtrados.add(imovel);
            }
        }

        Imovel[] result = filtrados.toArray(new Imovel[0]);

        for (int i = 0; i < result.length - 1; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].getPreco() > result[j].getPreco()) {
                    Imovel temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }

        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Imobiliaria ").append(nome).append(":\n");
        for (Imovel imovel : imoveis) {
            sb.append(imovel.toString()).append("\n");
        }
        return sb.toString();
    }
	
}
