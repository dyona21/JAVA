package exercicio01;
import java.util.Date;

public class Venda {
	private int numero;
    private Cliente cliente;
    private Carrinho carrinho;
    private Date data;
    
    public Venda(int numero, Cliente cliente, Carrinho carrinho, Date data) {
        this.setNumero(numero);
        this.setCliente(cliente);
        this.setCarrinho(carrinho);
        this.setData(data);
    }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String toString() {
		return "Venda: Numero "+numero+" \nCliente: "+cliente+" \nCarrinho: "+carrinho+" \nData: "+data +"\n";
	}
	
	public boolean equals(Object o) {
		Venda n;
		if(!(o instanceof Venda)) {
			return false;
		}
		n = (Venda) o;
		if(this.numero == n.getNumero()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
