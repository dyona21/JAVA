package dados;

public class Cliente {
    private long cpf;
    private int telefone;
    private String nome2;
    private String endereco; 
    private int quantidadeReserva = 0;

    private Reserva [] reservas = new Reserva[50];
    
    public Reserva[] getReservas() {
        return reservas;
    }

    public void reservaIda(Reserva reservas) {
        this.reservas[quantidadeReserva] = reservas;
        quantidadeReserva++;
    }
   
    public void reservarVolta(Reserva ida, Reserva volta) {
        this.reservas[quantidadeReserva] = volta;
        ida.setIdaEvolta(true);
        ida.setVolta(volta);
    }

  
    @Override
    public String toString() {
        return "Cliente [CPF: " + cpf + ", Nome: " + nome2 + ", Endereço: " + endereco + ", Telefone: " + telefone + "]";
    }

    public int getQuantidadeReserva() {
        return quantidadeReserva;
    }

    
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
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
