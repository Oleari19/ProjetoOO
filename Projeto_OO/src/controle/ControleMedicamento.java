package controle;

import java.util.ArrayList;
import modelo.*;

/**
 * Classe ControleMedicamento resposável por gerenciar os medicamentos.
 * 
 * @author Maria Clara oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class ControleMedicamento {

	private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();

	/**
	 * O construtor da classe ControleMedicamento.
	 * 
	 * @param dados Os dados do sistema.
	 */

	public ControleMedicamento(ControleDados dados) {
		medicamentos = dados.getMedicamentos();
	}

	/**
	 * Salva um medicamento na lista de medicamentos.
	 * 
	 * @param m Medicamento a ser salvo.
	 * @return true, se o medicamento foi salvo com sucesso, caso contrário, retorna false.
	 */

	public boolean salvar(Medicamento m) {
		if (m != null) {
			medicamentos.add(m);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna um array com os nomes de todos os medicamentos presentes na lista.
	 * 
	 * @return todos os nomes dos medicamentos.
	 */

	public String[] getNomeMedicamento() {
		String[] nomes = new String[medicamentos.size()];
		int i = 0;
		for (Medicamento med : medicamentos) {
			nomes[i] = med.getNome();
			i++;
		}
		return nomes;
	}

	/**
	 * Procura um medicamento específico, pelo nome, na lista de medicamentos.
	 * 
	 * @param busca Nome do medicamento a ser procurado.
	 * @return Indice do medicamento na lista, ou -1 se não foi encontrado.
	 */

	public int procurarMedicamento(String busca) {
		int i = 0;

		for (Medicamento med : medicamentos) {
			if (med.getNome().equals(busca)) {
				return i;
			}
			i++;
		}
		return -1;
	}

}
