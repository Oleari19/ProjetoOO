package controle;

import java.util.ArrayList;
import modelo.*;

/**
 * Classe ControleVitamina resposável por gerenciar as vitaminas.
 * 
 * @author Maria Clara oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class ControleVitamina {

	private ArrayList<Vitamina> vitaminas = new ArrayList<Vitamina>();

	/**
	 * O construtor da classe Controle.Vitamina.
	 * 
	 * @param dados Os dados do sistema.
	 */
	
	public ControleVitamina(ControleDados dados) {
		vitaminas = dados.getVitaminas();
	}

	/**
	 * Salva uma vitamina na lista de vitaminas.
	 * 
	 * @param v Vitamina a ser salva.
	 * @return true, se a vitamina foi salva com sucesso, caso contrário, retorna false.
	 */
	
	public boolean salvar(Vitamina v) {
		if (v != null) {
			vitaminas.add(v);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna um array com os nomes de todas as vitaminas presentes na lista.
	 * 
	 * @return todos os nomes das vitaminas.
	 */
	
	public String[] getNomeVitamina() {
		String[] nomes = new String[vitaminas.size()];
		int i = 0;
		for (Vitamina vit : vitaminas) {
			nomes[i] = vit.getNome();
			i++;
		}
		return nomes;
	}

	/**
	 * Procura uma vitamina específica, pelo nome, na lista de vitaminas.
	 * 
	 * @param busca Nome da vitamina a ser procurada.
	 * @return Indice da vitamina na lista, ou -1 se não foi encontrada.
	 */
	
	public int procurarVitamina(String busca) {
		int i = 0;

		for (Vitamina vit : vitaminas) {
			if (vit.getNome().equals(busca)) {
				return i;
			}
			i++;
		}
		return -1;
	}
}
