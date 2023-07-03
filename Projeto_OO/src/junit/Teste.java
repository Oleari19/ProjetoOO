package junit;

import static org.junit.Assert.*;
import controle.*;
import org.junit.jupiter.api.Test;

/**
 * Implementa os teste unitarios.
 * 
 * @author Maria Clara Oleari de Araujo.
 * @since 2023
 * @version 1.0
 */

class Teste {

	ControleDados controleDados = new ControleDados();

	/**
	 * Testa o método cadastrarEditarMedicamento da classe ControleDados. 
	 * Usando assertTrue pois foi inserido dados corretos.
	 */

	@Test
	void testeCadastrarEditarM() {

		String nome = "Novalgina";
		String preco = "23.7";
		String codigo = "1906";
		String qtEstoque = "14";
		String utilidade = "dor de cabeça";
		String dosagem = "1g";
		String validade = "02082023";
		int index = 1;

		assertTrue(controleDados.cadastrarEditarMedicamento(nome, preco, codigo, qtEstoque, utilidade, dosagem,
				validade, index));

	}

	/**
	 * Testa o método cadastrarEditarVitamina da classe ControleDados. 
	 * Usando assertFalse pois foi inserido dados incorretos.
	 */

	@Test
	void testeCadastrarEditarV() {

		String nome = "DPrev";
		String preco = "caro";
		String codigo = "0404";
		String qtEstoque = "22";
		String tipoVit = "38";
		String qtComp = "muitos";
		int index = 1;

		// nao quero q apareça
		assertFalse(controleDados.cadastrarEditarVitamina(nome, preco, codigo, qtEstoque, tipoVit, qtComp, index));

	}

	/**
	 * Testa o método excluirCosmetico da classe ControleDados. 
	 * Utilizando assertTrue para confirmar a exclusão.
	 */

	@Test
	void testeExcluirCosmetico() {
		assertTrue(controleDados.excluirCosmetico(0));
	}
}