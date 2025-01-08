package exercicio01;

public class Funcionario {
	private int codigoDeVenda;
	private String nomeFuncionario;
	private String cargo;
	
	public Funcionario(int codigoDeVenda, String nomeFuncionario, String cargo) {
		this.codigoDeVenda = codigoDeVenda;
		this.nomeFuncionario = nomeFuncionario;
		this.cargo = cargo;
	}
	
	public String toStringFuncionario(){
		return "Código de venda: "+ codigoDeVenda +"- nome do funcionário: "+ nomeFuncionario +" - cargo: "+cargo+"\n";
	}

	public int getCodigoDeVenda() {
		return codigoDeVenda;
	}
	
	public void setCodigoDeVenda(int codigoDeVenda) {
		this.codigoDeVenda = codigoDeVenda;
	}
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
	

}
