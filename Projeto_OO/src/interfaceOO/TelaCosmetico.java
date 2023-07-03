package interfaceOO;

import java.awt.event.*;

import javax.swing.*;
import controle.*;

/**
 * A classe TelaCosmetico representa a interface gráfica para cadastro, edição e exclusão de cosmeticos.
 * Ela implementa o ActionListener para tratar eventos dos botões.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaCosmetico implements ActionListener {

	private JFrame jfrm = new JFrame("Cosmeticos");
	private JTextField jtfNome, jtfCodigo, jtfPreco, jtfQtEstoque, jtfMarca, jtfTamanho, jtfIngrediente;
	private JLabel jlabNome, jlabCodigo, jlabPreco, jlabQtEstoque, jlabMarca, jlabTamanho, jlabIngrediente;
	private JButton jbtnSalvar, jbtnVoltar, jbtnExcluirCos;
	private static ControleDados dados;
	private int index;

	/**
	 * Construtor da classe TelaCosmetico.
	 * 
	 * @param d     Objeto ControleDados que contém os dados do sistema.
	 * @param index O índice do cosmetico a ser cadastrado, editado ou excluído.
	 */

	public TelaCosmetico(ControleDados d, int index) {
		dados = d;
		this.index = index;

		jfrm.setLayout(null);
		jfrm.setSize(485, 415);

		if (index == dados.getQtMedicamentos()) {

			// novo cosmetico
			jtfNome = new JTextField();
			jtfCodigo = new JTextField();
			jtfPreco = new JTextField();
			jtfQtEstoque = new JTextField();
			jtfMarca = new JTextField();
			jtfTamanho = new JTextField();
			jtfIngrediente = new JTextField();

		} else {

			// cosmetico ja existente
			jtfNome = new JTextField(dados.getCosmeticos().get(this.index).getNome());
			jtfCodigo = new JTextField(String.valueOf(dados.getCosmeticos().get(this.index).getCodigo()));
			jtfPreco = new JTextField(String.valueOf(dados.getCosmeticos().get(this.index).getPreco()));
			jtfQtEstoque = new JTextField(String.valueOf(dados.getCosmeticos().get(this.index).getQtEstoque()));
			jtfMarca = new JTextField(dados.getCosmeticos().get(this.index).getMarca());
			jtfTamanho = new JTextField(dados.getCosmeticos().get(this.index).getTamanho());
			jtfIngrediente = new JTextField(dados.getCosmeticos().get(this.index).getIngrediente());

			jbtnExcluirCos = new JButton("Excluir");
			jbtnExcluirCos.setBounds(170, 320, 120, 30);
			jfrm.add(jbtnExcluirCos);
			jbtnExcluirCos.addActionListener(this);
		}

		jbtnSalvar = new JButton("Salvar");
		jbtnVoltar = new JButton("Voltar");

		jlabNome = new JLabel("Nome do produto:");
		jlabPreco = new JLabel("Preço do produto:");
		jlabCodigo = new JLabel("Codigo do produto:");
		jlabQtEstoque = new JLabel("Quantidade em Estoque:");
		jlabTamanho = new JLabel("Tamanho:");
		jlabMarca = new JLabel("Marca:");
		jlabIngrediente = new JLabel("Ingredientes:");

		jlabNome.setBounds(20, 30, 150, 25);
		jtfNome.setBounds(200, 30, 245, 25);
		jlabPreco.setBounds(20, 70, 150, 25);
		jtfPreco.setBounds(200, 70, 245, 25);
		jlabCodigo.setBounds(20, 110, 150, 25);
		jtfCodigo.setBounds(200, 110, 245, 25);
		jlabQtEstoque.setBounds(20, 150, 170, 25);
		jtfQtEstoque.setBounds(200, 150, 245, 25);
		jlabMarca.setBounds(20, 190, 150, 25);
		jtfMarca.setBounds(200, 190, 245, 25);
		jlabTamanho.setBounds(20, 230, 200, 25);
		jtfTamanho.setBounds(200, 230, 245, 25);
		jlabIngrediente.setBounds(20, 270, 150, 25);
		jtfIngrediente.setBounds(200, 270, 245, 25);

		jbtnSalvar.setBounds(30, 320, 120, 30);
		jbtnVoltar.setBounds(310, 320, 120, 30);

		jfrm.add(jlabNome);
		jfrm.add(jtfNome);

		jfrm.add(jlabPreco);
		jfrm.add(jtfPreco);

		jfrm.add(jlabCodigo);
		jfrm.add(jtfCodigo);

		jfrm.add(jlabQtEstoque);
		jfrm.add(jtfQtEstoque);

		jfrm.add(jlabMarca);
		jfrm.add(jtfMarca);

		jfrm.add(jlabTamanho);
		jfrm.add(jtfTamanho);

		jfrm.add(jlabIngrediente);
		jfrm.add(jtfIngrediente);

		jfrm.add(jbtnSalvar);
		jfrm.add(jbtnVoltar);

		jbtnSalvar.addActionListener(this);
		jbtnVoltar.addActionListener(this);

		jfrm.setVisible(true);
	}

	/**
	 * Método para gerência de eventos.
	 * 
	 * @param ae O evento de ação ocorrido.
	 */

	public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand().equals("Salvar")) {

			String nome = jtfNome.getText();
			String preco = jtfPreco.getText();
			String codigo = jtfCodigo.getText();
			String qtEstoque = jtfQtEstoque.getText();
			String marca = jtfMarca.getText();
			String tamanho = jtfTamanho.getText();
			String ingrediente = jtfIngrediente.getText();

			boolean x = dados.cadastrarEditarCosmetico(nome, preco, codigo, qtEstoque, marca, tamanho, ingrediente,
					index);

			if (x == true) {
				JOptionPane.showMessageDialog(null, "Cosmetico Salvo com Sucesso!");
				jfrm.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Erro!");
			}
		}

		if (ae.getActionCommand().equals("Excluir")) {
			dados.excluirCosmetico(index);
			JOptionPane.showMessageDialog(null, "Cosmetico Excluido com Sucesso!");
			jfrm.dispose();
		}

		if (ae.getActionCommand().equals("Voltar")) {
			jfrm.dispose();
		}
	}
}
