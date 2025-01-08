package exercicio01;

public class Cliente {
	private int cpf;
	private String nome;
	private String endereco;
	
	public Cliente(int cpf, String nome, String endereco) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Cliente(int cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = "Endereço não cadastrado!";
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public boolean equals(Object b) {
		Cliente p;
		if(!(b instanceof Cliente)) {
			return false;
		}
		p = (Cliente) b;
		if(this.cpf == p.getCpf()) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString(){
		return "Nome: "+nome+"- CPF: "+cpf+" - Endereço: "+endereco;
	}

}
