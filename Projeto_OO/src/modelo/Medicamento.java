package modelo;

/**
 * Classe Medicamento, a qual herda da classe Produto. 
 * Essa classe representa medicamentos específicos.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class Medicamento extends Produto {

	private String utilidade;
	private int validade;
	private String dosagem;

	/**
	 * Construtor vazio de Medicamento. 
	 * Cria uma nova instância da classe sem receber nenhum parâmetro.
	 */
	
	public Medicamento() {
	}

	/**
	 * Construtor de um Medicamento.
	 * 
	 * @param nome      O nome do medicamento.
	 * @param codigo    O código do medicamento.
	 * @param preco     O preço do medicamento.
	 * @param qtEstoque A quantidade em estoque do medicamento.
	 * @param utilidade A utilidade do medicamento.
	 * @param validade  A data de validade do medicamento.
	 * @param dosagem   A dosagem do medicamento.
	 */

	public Medicamento(String nome, int codigo, double preco, int qtEstoque, String utilidade, int validade,
			String dosagem) {

		super(nome, codigo, preco, qtEstoque);
		this.utilidade = utilidade;
		this.validade = validade;
		this.dosagem = dosagem;
	}

	public String getUtilidade() {
		return utilidade;
	}

	public void setUtilidade(String utilidade) {
		this.utilidade = utilidade;
	}

	public int getValidade() {
		return validade;
	}

	public void setValidade(int validade) {
		this.validade = validade;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String toString() {

		return "\n\nNome: " + nome + "\nPreco: " + preco + "\nCodigo" + codigo + "\nQtEstoque: " + qtEstoque
				+ "\nUtilidade: " + utilidade + "\nDosagem: " + dosagem + "\nData de Validade: " + validade;
	}
}
