package modelo;

/**
 * Classe Cosmetico, a qual herda da classe Produto. 
 * Essa classe representa cosméticos específicos.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023
 * @version 1.0
 *
 */

public class Cosmetico extends Produto {

	private String ingrediente;
	private String marca;
	private String tamanho;

	/**
	 * Construtor vazio de Cosmetico. 
	 * Cria uma nova instância da classe sem receber nenhum parâmetro.
	 */
	
	public Cosmetico () {
		
	}
	
	/**
	 * Construtor de um Cosmetico.
	 * 
	 * @param nome        O nome do cosmético.
	 * @param codigo      O código do cosmético.
	 * @param preco       O preço do cosmético.
	 * @param qtEstoque   A quantidade em estoque do cosmético.
	 * @param ingrediente Os ingredientes do cosmético.
	 * @param marca       A marca do cosmético.
	 * @param tamanho     O tamanho do cosmético.
	 */

	public Cosmetico(String nome, int codigo, double preco, int qtEstoque, String ingrediente, String marca,
			String tamanho) {

		super(nome, codigo, preco, qtEstoque);
		this.ingrediente = ingrediente;
		this.marca = marca;
		this.tamanho = tamanho;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String toString() {

		return "\n\nNome: " + nome + "\nCodigo: " + codigo + "\nPreco: " + preco + "\nQuantidade em estoque: "
				+ qtEstoque + "\nIngredientes: " + ingrediente + "\nMarca: " + marca + "\nTamanho: " + tamanho;
	}

}
