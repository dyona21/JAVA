package exercicio01;
import dados.*;
import java.util.Date;

public class exercicio02 {
    public static void main(String[] args) {
        produto produto1 = new produto(101, "Picanha", 50.99);
        produto produto2 = new produto(102, "Contra filé");
        produto2.setPreco(45.50);

        System.out.println(produto1.toString());
        System.out.println(produto2.toString());

        Cliente cliente1 = new Cliente(875621, "Victor", "Avenida Mauá, 841");
        Cliente cliente2 = new Cliente(896123, "Peter");
        cliente2.setEndereco("Rua Antônio João Silva, 106");

        System.out.println(cliente1.toString());
        System.out.println(cliente2.toString());

        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(produto1);
        carrinho.adicionarItem(produto2);

        System.out.println(carrinho);
        System.out.println("Total do carrinho: " + carrinho.calcularTotal());

        Funcionario funcionario1 = new Funcionario(301, "Lucas", "Caixa");
        Funcionario funcionario2 = new Funcionario(302, "Gabriel", "Caixa");

        System.out.println(funcionario1.toStringFuncionario());
        System.out.println(funcionario2.toStringFuncionario());

        Venda venda1 = new Venda(401, cliente1, carrinho, new Date());
        Venda venda2 = new Venda(402, cliente2, carrinho, new Date());

        System.out.println(venda1.toString());
        System.out.println(venda2.toString());
    }
}

