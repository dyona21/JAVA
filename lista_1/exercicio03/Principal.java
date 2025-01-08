package exercicio03;

public class Principal {

	public static void main(String[] args) {
		 Imovel imovel1 = new Imovel(11.0, 17.0, 200000.0);
	        Imovel imovel2 = new Imovel(14.0, 23.0, 250000.0);

	        Imobiliaria imobiliaria = new Imobiliaria("Boa escolha");
	        imobiliaria.adicionarImovel(imovel1.toString());
	        imobiliaria.adicionarImovel(imovel2.toString());

	        System.out.println("Lista de imóveis:\n" + imobiliaria);

	        double areaMinima = 190.0;
	        Imovel[] filtrados = imobiliaria.filtrarPorArea(areaMinima);
	        System.out.println("Imóveis com área maior ou igual a " + areaMinima + " m²:");
	        for (Imovel imovel : filtrados) {
	            System.out.println(imovel.toString());
	        }
	    }

}

