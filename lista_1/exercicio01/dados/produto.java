package exercicio01;
//sistema supermecado
public class produto {
	private int codigo;
	private String nome;
	private double preco;
	
	public produto(int codigo, String nome, double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
	
	public produto(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = 0.0;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public boolean equals(Object obj) {
		produto l;
		if(!(obj instanceof produto)) {
			return false;
		}
		l = (produto) obj;
		if(this.codigo == l.getCodigo()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
       return "Codigo: "+codigo+" - Nome: "+nome+" - Preco "+preco;
	}

}
