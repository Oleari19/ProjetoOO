package controle;

import java.util.ArrayList;
import modelo.*;

/**
 * Classe ControleCosmetico resposável por gerenciar os cosméticos.
 * 
 * @author Maria Clara oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class ControleCosmetico {

	private ArrayList<Cosmetico> cosmeticos = new ArrayList<Cosmetico>();

	/**
	 * Construtor vazio de ControleCosmetico. 
	 * Cria uma nova instância da classe sem receber nenhum parâmetro.
	 */
	
	public ControleCosmetico() {

	}
	
	/**
	 * O construtor da classe ControleCosmetico.
	 * 
	 * @param dados Os dados do sistema.
	 */
	
	public ControleCosmetico(ControleDados dados) {
		cosmeticos = dados.getCosmeticos();
	}
	
	/**
	 * Salva um cosmetico na lista de cosmeticos.
	 * 
	 * @param c Cosmetico a ser salvo.
	 * @return true, se o cosmetico foi salvo com sucesso, caso contrário, retorna false.
	 */

	public boolean salvar(Cosmetico c) {
		if (c != null) {
			cosmeticos.add(c);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna um array com os nomes de todos os cossmeticos presentes na lista.
	 * 
	 * @return Todos os nomes dos cosmeticos.
	 */

	public String[] getNomeCosmetico() {
		String[] nomes = new String[cosmeticos.size()];
		int i = 0;
		for (Cosmetico cos : cosmeticos) {
			nomes[i] = cos.getNome();
			i++;
		}
		return nomes;
	}
	
	/**
	 * Procura um cosmetico específico, pelo nome, na lista de cosmeticos.
	 * 
	 * @param busca Nome do cosmetico a ser procurado.
	 * @return Indice do cosmetico na lista, ou -1 se não foi encontrado.
	 */

	public int procurarCosmetico(String busca) {
		int i = 0;

		for (Cosmetico cos : cosmeticos) {
			if (cos.getNome().equals(busca)) {
				return i;
			}
			i++;
		}
		return -1;
	}
}
