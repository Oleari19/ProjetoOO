package projetinho;

public class Vitamina extends Produto {
	
	private int quantidadeDeComprimido;
	
	public Vitamina(String nome, int codigo, String categoria, double preco, int quantidadeDeComprimido) {
		super(nome, codigo, categoria, preco);
		setQuantidadeDeComprimido(quantidadeDeComprimido);
	}

	public int getQuantidadeDeComprimido() {
		return quantidadeDeComprimido;
	}

	public void setQuantidadeDeComprimido(int quantidadeDeComprimido) {
		this.quantidadeDeComprimido = quantidadeDeComprimido;
	}
	
	public String toString() {
		
		return "Nome: " + nome + "\nCodigo: " + codigo + "\nCategoria: Vitamina" + "\nPreco: " + preco + "\nQuantidade de comprimidos: " + quantidadeDeComprimido;  
	}
	
}
