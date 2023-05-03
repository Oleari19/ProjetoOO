package projetinho;

public class Main {
	
	static Vitamina teste1;
	static Medicamento teste2;
	static Cosmetico teste3;

	public static void main(String[] args) {
		
		teste1 = new Vitamina("Vitamina A", 12345, "Vitamina", 55.99, 20);
		System.out.println(teste1.toString());
		
		teste2 = new Medicamento("Dipirona", 78943, "Medicamento", 35.90, "Dor de cabeca", 100523);
		System.out.println(teste2.toString());
		
		teste3 = new Cosmetico("Condicionador", 25894, "Cosmetico", 19.99, "Tensoativos, agentes de estabilizacao, fragrancia e preservantes");
		System.out.println(teste3.toString());
	}
	
		
}



