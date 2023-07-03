package controle;

import modelo.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * A classe ControleDados é responsável por gerenciar os dados do sistema.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class ControleDados {

	private Dados d = new Dados();
	private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
	private ArrayList<Cosmetico> cosmeticos = new ArrayList<Cosmetico>();
	private ArrayList<Vitamina> vitaminas = new ArrayList<Vitamina>();

	/**
	 * O construtor da classe ControleDados. 
	 * Inicializa os dados pré-cadastrados de medicamentos, cosmeticos e vitaminas.
	 */

	public ControleDados() {
		d.preCadastroM();
		medicamentos = d.getMedicamentos();
		d.preCadastroC();
		cosmeticos = d.getCosmeticos();
		d.preCadastroV();
		vitaminas = d.getVitaminas();
	}

	/**
	 * Cadastra ou edita um medicamento no sistema.
	 * 
	 * @param nome      O nome do medicamento.
	 * @param preco     O preço do medicamento.
	 * @param codigo    O código do medicamento,
	 * @param qtEstoque A quantidade em estoque do medicamento.
	 * @param utilidade A utilidade do medicamento.
	 * @param dosagem   A dosagem do medicamento.
	 * @param validade  A validade do medicamento.
	 * @param index     O índice do medicamento a ser editado.
	 * @return true se o cadastro ou edição foi realizado com sucesso, caso contrário, false.
	 */

	public boolean cadastrarEditarMedicamento(String nome, String preco, String codigo, String qtEstoque,
			String utilidade, String dosagem, String validade, int index) {

		if (preco.matches("[a-z]+") || !codigo.matches("[0-9]+") || !qtEstoque.matches("[0-9]+")
				|| !validade.matches("[0-9]+")) {
			return false;

		} else {
			Medicamento medicamentoTemp = new Medicamento(nome, Integer.parseInt(codigo), Double.parseDouble(preco),
					Integer.parseInt(qtEstoque), utilidade, Integer.parseInt(validade), dosagem);

			if (index == d.getMedicamentos().size()) {
				d.setMedicamentos(medicamentoTemp);
				medicamentos = d.getMedicamentos();

			} else {

				d.getMedicamentos().get(index).setNome(nome);
				d.getMedicamentos().get(index).setCodigo(Integer.parseInt(codigo));
				d.getMedicamentos().get(index).setPreco(Double.parseDouble(preco));
				d.getMedicamentos().get(index).setQtEstoque(Integer.parseInt(qtEstoque));
				d.getMedicamentos().get(index).setUtilidade(utilidade);
				d.getMedicamentos().get(index).setDosagem(dosagem);
				d.getMedicamentos().get(index).setValidade(Integer.parseInt(validade));
			}
			return true;
		}
	}

	/**
	 * Cadastra ou edita um cosmético no sistema.
	 * 
	 * @param nome        O nome do cosmético.
	 * @param preco       O preço do cosmético.
	 * @param codigo      O código do cosmético.
	 * @param qtEstoque   A quantidade em estoque do cosmético.
	 * @param marca       A marca do cosmético.
	 * @param tamanho     O tamanho do cosmético.
	 * @param ingrediente Os ingredientes do cosmético.
	 * @param index       O índice do cosmético a ser editado.
	 * @return true se o cadastro ou edição foi realizado com sucesso, caso contrário, false.
	 */

	public boolean cadastrarEditarCosmetico(String nome, String preco, String codigo, String qtEstoque, String marca,
			String tamanho, String ingrediente, int index) {

		if (preco.matches("[a-z]+") || !codigo.matches("[0-9]+") || !qtEstoque.matches("[0-9]+")) {
			return false;

		} else {
			Cosmetico cosmeticoTemp = new Cosmetico(nome, Integer.parseInt(codigo), Double.parseDouble(preco),
					Integer.parseInt(qtEstoque), tamanho, marca, ingrediente);

			if (index == d.getCosmeticos().size()) {
				d.setCosmeticos(cosmeticoTemp);
				cosmeticos = d.getCosmeticos();

			} else {

				d.getCosmeticos().get(index).setNome(nome);
				d.getCosmeticos().get(index).setCodigo(Integer.parseInt(codigo));
				d.getCosmeticos().get(index).setPreco(Double.parseDouble(preco));
				d.getCosmeticos().get(index).setQtEstoque(Integer.parseInt(qtEstoque));
				d.getCosmeticos().get(index).setMarca(marca);
				d.getCosmeticos().get(index).setTamanho(tamanho);
				d.getCosmeticos().get(index).setIngrediente(ingrediente);
			}
			return true;
		}
	}

	/**
	 * Cadastra ou edita uma vitamina no sistema.
	 * 
	 * @param nome      O nome da vitamina.
	 * @param preco     O preço da vitamina.
	 * @param codigo    O código da vitamina.
	 * @param qtEstoque A quantidade em estoque da vitamina,
	 * @param tipoVit   O tipo de vitamina.
	 * @param qtComp    A quantidade de comprimidos da vitamina.
	 * @param index     O índice da vitamina a ser editada (-1 se for um novo
	 *                  cadastro).
	 * @return true se o cadastro ou edição foi realizado com sucesso, false caso contrário.
	 */

	public boolean cadastrarEditarVitamina(String nome, String preco, String codigo, String qtEstoque, String tipoVit,
			String qtComp, int index) {

		if (preco.matches("[a-z]+") || !codigo.matches("[0-9]+") || !qtEstoque.matches("[0-9]+")
				|| !qtComp.matches("[0-9]+")) {
			return false;

		} else {
			Vitamina vitaminaTemp = new Vitamina(nome, Integer.parseInt(codigo), Double.parseDouble(preco),
					Integer.parseInt(qtEstoque), Integer.parseInt(qtComp), tipoVit);

			if (index == d.getVitaminas().size()) {
				d.setVitaminas(vitaminaTemp);
				vitaminas = d.getVitaminas();

			} else {

				d.getVitaminas().get(index).setNome(nome);
				d.getVitaminas().get(index).setCodigo(Integer.parseInt(codigo));
				d.getVitaminas().get(index).setPreco(Double.parseDouble(preco));
				d.getVitaminas().get(index).setQtEstoque(Integer.parseInt(qtEstoque));
				d.getVitaminas().get(index).setTipoVit(tipoVit);
				d.getVitaminas().get(index).setQtComp(Integer.parseInt(qtComp));
			}
			return true;
		}
	}

	/**
	 * Exclui um medicamento do sistema.
	 * 
	 * @param index O índice do medicamento a ser excluído.
	 */

	public void excluirMedicamento(int index) {
		if (index >= 0 && index < medicamentos.size()) {

			medicamentos.remove(index);
			d.setMedicamentos(medicamentos);
			JOptionPane.showMessageDialog(null, "Medicamento Excluido com Sucesso!");
		}
	}

	/**
	 * Exclui um cosmético da lista de cosméticos.
	 *
	 * @param index O índice do cosmético a ser excluído
	 * @return true se o cosmético foi excluído com sucesso, false caso contrário
	 */

	public boolean excluirCosmetico(int index) {
		if (index >= 0 && index < cosmeticos.size()) {

			cosmeticos.remove(index);
			d.setCosmeticos(cosmeticos);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Exclui uma vitamina do sistema.
	 * 
	 * @param index O índice da vitamina a ser excluída.
	 */

	public void excluirVitamina(int index) {
		if (index >= 0 && index < vitaminas.size()) {

			vitaminas.remove(index);
			d.setVitaminas(vitaminas);
			JOptionPane.showMessageDialog(null, "Vitamina Excluida com Sucesso!");
		}
	}

	public Dados getD() {
		return d;
	}

	public void setD(Dados d) {
		this.d = d;
	}

	public ArrayList<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
		d.setMedicamentos(medicamentos);
	}

	public int getQtMedicamentos() {
		return d.getQtMedicamentos();
	}

	public ArrayList<Cosmetico> getCosmeticos() {
		return cosmeticos;
	}

	public void setCosmeticos(ArrayList<Cosmetico> cosmeticos) {
		this.cosmeticos = cosmeticos;
		d.setCosmeticos(cosmeticos);
	}

	public int getQtCosmeticos() {
		return d.getQtCosmeticos();
	}

	public ArrayList<Vitamina> getVitaminas() {
		return vitaminas;
	}

	public void setVitaminas(ArrayList<Vitamina> vitaminas) {
		this.vitaminas = vitaminas;
		d.setVitaminas(vitaminas);
	}

	public int getQtVitaminas() {
		return d.getQtVitaminas();
	}

}
