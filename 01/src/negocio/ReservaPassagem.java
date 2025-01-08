package negocio;
import java.util.Scanner;
import dados.*;

public class ReservaPassagem {
    Cliente [] listaClientes = new Cliente [50];
    Cidade []listaCidades = new Cidade[50];
    int quantidadeClientes = 0;
    int quantidadeCidades = 0;

    public void cadastrarCidadeReserva(Cidade cidade){
        setListaCidades(cidade);
    }
    
    public void cadastrarClienteReserva(Cliente cliente){
        setListaClientes(cliente);
    }

    public void reservarIda(Cliente cliente, Reserva reserva){
        
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta){
        reserva.setIdaEvolta(true);
    }

    public Reserva[] mostrarReservas(String cpf){
        return getReservas();
    }

    public Cliente [] mostrarClientes(){
        return listaClientes;
    }

    public Cidade [] mostrarCidades(){
        return listaCidades;
    }
   
    public void setListaCidades(Cidade cidade) {
        this.listaCidades[quantidadeCidades] = cidade;
        quantidadeCidades++;
    }

    public void setListaClientes(Cliente cliente) {
        this.listaClientes[quantidadeClientes] = cliente;
        quantidadeClientes++;
    }
    
    public Cliente[] getListaClientes() {
        return listaClientes;
    }
    
    public Cidade[] getlistaCidades() {
        return listaCidades;
    }

}
