package negocio;
import dados.*;

public class ReservaPassagem {
    Cliente [] listaClientes = new Cliente [20];
    Cidade []listaCidades = new Cidade[20];
    int quantidadeClientes = 0;
    int quantidadeCidades = 0;

    public void cadastrarCidadeReserva(Cidade cidade){
        if( quantidadeCidades < 20){
            setListaCidades(cidade);
        } else{
            System.out.format("Impossível adicionar mais cidades.\n");
        }
    }
    
    public void cadastrarClienteReserva(Cliente cliente){
        if(quantidadeClientes < 20){
            setListaClientes(cliente);
        } else {
            System.out.format("Impossível cadastrar mais clientes.\n");
        }
    }

    public void reservarIda(Cliente cliente, Reserva reserva){
        if(cliente != null){
            cliente.reservaIda(reserva);
        } else {
            System.out.format("Cliente não cadastrado.\n");
        }
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta){
        if(cliente != null){
            cliente.reservarVolta(ida, volta);
        } else {
            System.out.format("Cliente não cadastrado.\n");
        }
    }

    public Reserva[] mostrarReservas(long cpf){
        for(int i = 0; i < quantidadeClientes; i++){
            if(listaClientes[i].getCpf() == cpf){
                return listaClientes[i].getReservas();
            }
        }
        return new Reserva[0];
    }

    public Cliente buscarCliente(long cpf) {
        for (Cliente c : this.listaClientes) {
            if (c.getCpf() == cpf) {
                return c;
            }
        }
        return null;
    }
    
    public int getQuantidadeCidades() {
        return quantidadeCidades;
    }

    public int getQuantidadeClientes() {
        return quantidadeClientes;
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
