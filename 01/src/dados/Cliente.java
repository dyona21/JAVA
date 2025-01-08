package dados;

public class Cliente {
    private String cpf;
    private int telefone;
    private String nome2;
    private String endereco; 
    private int quantidadeReserva = 0;
    private Reserva [] reservas = new Reserva[50];
    
    public void setReservas(Reserva reservas) {
        this.reservas[quantidadeReserva] = reservas;
        quantidadeReserva++;
    }
    
    public Reserva[] getReservas() {
        return reservas;
    }

    public Cliente(String cpf, int telefone, String nome2, String endereco){
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome2 = nome2;
        this.endereco = endereco;
    
    }

    public String toStringCliente() {
        return "Cliente [cpf=" + cpf + ", telefone=" + telefone + ", nome="+ nome2 + 
        ", endereço= " + endereco + "]";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNome2() {
        return nome2;
    }

    public void setNome2(String nome2) {
        this.nome2 = nome2;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
