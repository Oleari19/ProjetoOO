package projetinho;

public class Medicamento extends Produto {
	
	private String utilidade;
	private int dataValidade;
	
	public Medicamento(String nome, int codigo, String categoria, double preco, String utilidade, int dataValidade) {
		super(nome, codigo, categoria, preco);
		setUtilidade(utilidade);
		setDataValidade(dataValidade);
	}

	public String getUtilidade() {
		return utilidade;
	}

	public void setUtilidade(String utilidade) {
		this.utilidade = utilidade;
	}
	
	public int getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(int validade) {
		this.dataValidade = validade;
	}
	
	public String toString() {
		
		return "\n\nNome: " + nome + "\nCodigo: " + codigo + "\nCategoria: Medicamento" + "\nPreco: " + preco + "\nUtilidade: " + utilidade + "\nData de Validade: " + dataValidade;  
	}
	
	
}
