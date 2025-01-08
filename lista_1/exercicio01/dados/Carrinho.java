package exercicio01;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	private List<produto> itens;
	
	public Carrinho() {
		itens =  new ArrayList<>();
	}
	
	public void adicionarItem(produto produto) {
		itens.add(produto);
	}
	
	public void removerItem(produto produto) {
        itens.remove(produto);
	}

	public List<produto> getItens() {
		return itens;
    }

	    
	public double calcularTotal() {
		double total = 0.0;
	       for (produto produto : itens) {
	    	   total += produto.getPreco();
	       }   
	       return total;
	}
	
	public String toString() {
		return "Itens"+itens;
	}
}
