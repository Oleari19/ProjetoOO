package modelo;

/**
 * Classe abstrata Produto, que representa um produto genérico. 
 * Essa classe contém informações básicas comuns a todos os produtos. 
 * Classe pai de Medicamento, Vitamina e Cosmetico.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023.3
 * @version 1.0
 */

public abstract class Produto {

	protected String nome;
	protected int codigo;
	protected double preco;
	protected int qtEstoque;

	/**
	 * Construtor vazio de Produto 
	 * Cria uma nova instância da classe sem receber nenhum parâmetro.
	 */

	public Produto() {
	}

	/**
	 * Construtor de um produto.
	 * 
	 * @param nome      O nome do produto.
	 * @param codigo    O código do produto.
	 * @param preco     O preço do produto.
	 * @param qtEstoque A quantidade em estoque do produto.
	 */

	public Produto(String nome, int codigo, double preco, int qtEstoque) { // String categoria,
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		this.qtEstoque = qtEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtEstoque() {
		return qtEstoque;
	}

	public void setQtEstoque(int qtEstoque) {
		this.qtEstoque = qtEstoque;
	}

}
