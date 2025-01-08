package dados;
import java.util.Scanner;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo;
    private float preco;
    private String classeVoo;
    private Boolean idaEvolta;
    private int numeroPoltrona;
    private Cidade origem;
    private Cidade destino;
    private Reserva volta;


    public void setVolta(Reserva volta) {
        this.volta = volta;
    }

    public Reserva getVolta() {
        return volta;
    }
    
    public String toStringReserva() {
        return "Reserva [número reserva=" + numReserva + ", data do voo=" + dataVoo + ", hora do voo="+ horaVoo + 
        ", preço = " + preco + ",classe = "+ classeVoo + "ida e volta="+ idaEvolta + 
        ", número da poltrona=" + numeroPoltrona + "]";
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public String getDataVoo() {
        return dataVoo;
    }

    public void setHoraVoo(String horaVoo) {
        this.horaVoo = horaVoo;
    }

    public String getHoraVoo() {
        return horaVoo;
    }

    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }

    public String getClasseVoo() {
        return classeVoo;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setIdaEvolta(Boolean idaEvolta) {
        this.idaEvolta = idaEvolta;
    }

    public Boolean getIdaEvolta() {
        return idaEvolta;
    }

    public void setNumeroPoltrona(int numeroPoltrona) {
        this.numeroPoltrona = numeroPoltrona;
    }

    public int getNumPoltrona() {
        return numeroPoltrona;
    }
    
}
