package modelo;

/**
 * Classe Vitamina, a qual herda da classe Produto. 
 * Essa Classe representa vitaminas específicas.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class Vitamina extends Produto {

	private int qtComp;
	private String tipoVit;

	/**
	 * Construtor vazio de Vitamina. 
	 * Cria uma nova instância da classe sem receber nenhum parâmetro.
	 */

	public Vitamina() {
	}

	/**
	 * Construtor de uma Vitamina
	 * 
	 * @param nome      O nome da vitamina.
	 * @param codigo    O código da vitamina.
	 * @param preco     O preço da vitamina.
	 * @param qtEstoque A quantidade em estoque da vitamina.
	 * @param qtComp    A quantidade de comprimidos da vitamina.
	 * @param tipoVit   O tipo de vitamina.
	 */

	public Vitamina(String nome, int codigo, double preco, int qtEstoque, int qtComp, String tipoVit) {

		super(nome, codigo, preco, qtEstoque);
		this.qtComp = qtComp;
		this.tipoVit = tipoVit;
	}

	public int getQtComp() {
		return qtComp;
	}

	public void setQtComp(int qtComp) {
		this.qtComp = qtComp;
	}

	public String getTipoVit() {
		return tipoVit;
	}

	public void setTipoVit(String tipoVit) {
		this.tipoVit = tipoVit;
	}

	public String toString() {

		return "Nome: " + nome + "\nCodigo: " + codigo + "\nPreco: " + preco + "\nQuantidade em estoque: " + qtEstoque
				+ "\nQuantidade de comprimidos: " + qtComp + "\nTipo Vitaminico: " + tipoVit;																							// Vitamina"
	}

}
