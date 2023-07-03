package modelo;

import java.util.ArrayList;

/**
 * A classe Dados representa um conjunto de dados contendo informações sobre os produtos.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023
 * @version
 *
 */
public class Dados {

	private String nomes;
	public ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
	public ArrayList<Cosmetico> cosmeticos = new ArrayList<Cosmetico>();
	public ArrayList<Vitamina> vitaminas = new ArrayList<Vitamina>();

	/**
	 * Cosntrutor vazio da classe Dados.
	 */

	public Dados() {
	}

	/**
	 * Construtor da classe Dados
	 * 
	 * @param nomes        Nome de um produto a ser salvo.
	 * @param medicamentos Iniciação do ArrayList, da lista, de medicamentos.
	 * @param cosmeticos   Iniciação do ArrayList, da lista, de cosméticos.
	 * @param vitaminas    Iniciação do ArrayList, da lista, de vitaminas.
	 */
	public Dados(String nomes, ArrayList<Medicamento> medicamentos, ArrayList<Cosmetico> cosmeticos,
			ArrayList<Vitamina> vitaminas) {
		this.nomes = nomes;
		this.medicamentos = medicamentos;
		this.cosmeticos = cosmeticos;
		this.vitaminas = vitaminas;
	}

	/**
	 * Método responsável por fazer um pré-cadastro de medicamentos. 
	 * Adiciona 5 medicamentos à lista de medicamentos.
	 */

	public void preCadastroM() {
		for (int i = 1; i < 6; i++) {
			Medicamento meds = new Medicamento("Medicamento" + i, i* 1234, i*19.30, i,
					"dor" + i, (1900 + i), i + "mg");
			medicamentos.add(meds);
		}
	}

	/**
	 * Método responsável por fazer um pré-cadastro de cosméticos. 
	 * Adiciona 5 cosméticos à lista de cosméticos.
	 */

	public void preCadastroC() {
		for (int i = 1; i < 6; i++) {
			Cosmetico cosm = new Cosmetico("Cosmetico" + i, i * 3456, 
					i * 19.30, i, "ingredientes" + i, "marca" + i, i + "ml");
			cosmeticos.add(cosm);
		}
	}

	/**
	 * Método responsável por fazer um pré-cadastro de vitaminas. 
	 * Adiciona 5 vitaminas à lista de vitaminas.
	 */

	public void preCadastroV() {
		for (int i = 1; i < 6; i++) {
			Vitamina vits = new Vitamina("Vitamina" + i, i * 2345, i * 19.30, i, i, "tipo" + i);
			vitaminas.add(vits);
		}
	}

	public String getNomes() {
		return nomes;
	}

	public void setNomes(String nomes) {
		this.nomes = nomes;
	}

	public ArrayList<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public void setMedicamentos(Medicamento med) {
		medicamentos.add(med);
	}

	public int getQtMedicamentos() {
		return medicamentos.size();
	}

	public ArrayList<Cosmetico> getCosmeticos() {
		return cosmeticos;
	}

	public void setCosmeticos(ArrayList<Cosmetico> cosmeticos) {
		this.cosmeticos = cosmeticos;
	}

	public void setCosmeticos(Cosmetico cos) {
		cosmeticos.add(cos);
	}

	public int getQtCosmeticos() {
		return cosmeticos.size();
	}

	public ArrayList<Vitamina> getVitaminas() {
		return vitaminas;
	}

	public void setVitaminas(ArrayList<Vitamina> vitaminas) {
		this.vitaminas = vitaminas;
	}

	public void setVitaminas(Vitamina vit) {
		vitaminas.add(vit);
	}

	public int getQtVitaminas() {
		return vitaminas.size();
	}

	/**
	 * Cadastra, salva um medicamento na lista de medicamentos.
	 * 
	 * @param m O medicamento a ser cadastrado.
	 */

	public void cadastraMedicamento(Medicamento m) {
		medicamentos.add(m);
	}

	/**
	 * Cadastra, salva um cosmético na lista de cosméticos.
	 * 
	 * @param c O cosmético a ser cadastrado.
	 */

	public void cadastraCosmetico(Cosmetico c) {
		cosmeticos.add(c);
	}

	/**
	 * Cadastra, salva uma vitamina na lista de vitaminas.
	 * 
	 * @param v A vitamina a ser cadastrada.
	 */

	public void cadastraVitamina(Vitamina v) {
		vitaminas.add(v);
	}

	// sobrescrita
	@Override
	public String toString() {
		return nomes + medicamentos + cosmeticos + vitaminas;
	}

}
