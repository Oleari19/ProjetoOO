package projetinho;

public class Cosmetico extends Produto {
	
	private String igrediente;
	
	public Cosmetico(String nome, int codigo, String categoria, double preco, String igrediente) {
		super(nome, codigo, categoria, preco);
		setIgrediente(igrediente);
	}

	public String getIgrediente() {
		return igrediente;
	}

	public void setIgrediente(String igrediente) {
		this.igrediente = igrediente;
	}
	
	public String toString() {
		
		return "\n\nNome: " + nome + "\nCodigo: " + codigo + "\nCategoria: Cosmetico" + "\nPreco: " + preco + "\nIgredientes: " + igrediente;  
	}
	

}
