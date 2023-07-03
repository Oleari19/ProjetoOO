package projetinho;

public abstract class Produto {

	// atributos
	protected String nome;
	protected int codigo;
	protected String categoria;
	protected double preco;
	
	public Produto(String nome, int codigo, String categoria, double preco) {
		setNome(nome);
		setCodigo(codigo);
		setCategoria(categoria);
		setPreco(preco);
	}
	
	
	//gets (pega) e sets(o nome vai para a variavel nome do Produto
	
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
