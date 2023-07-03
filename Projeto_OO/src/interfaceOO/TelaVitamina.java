package interfaceOO;

import java.awt.event.*;

import javax.swing.*;
import controle.*;

/**
 * A classe TelaVitamina representa a interface gráfica para cadastro, edição e exclusão de vitaminas. 
 * Ela implementa o ActionListener para tratar eventos dos botões.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaVitamina implements ActionListener {

	private JFrame jfrm = new JFrame("Vitaminas");
	private JTextField jtfNome, jtfCodigo, jtfPreco, jtfQtEstoque, jtfTipoVit, jtfQtComp;
	private JLabel jlabNome, jlabCodigo, jlabPreco, jlabQtEstoque, jlabTipoVit, jlabQtComp;
	private JButton jbtnSalvar, jbtnVoltar, jbtnExcluirVit;
	private static ControleDados dados;
	private int index;

	/**
	 * Construtor da classe TelaVitamina.
	 * 
	 * @param d     Objeto ControleDados que contém os dados do sistema.
	 * @param index O índice da vitamina a ser cadastrada, editada ou excluída.
	 */

	public TelaVitamina(ControleDados d, int index) {
		dados = d;
		this.index = index;

		jfrm.setLayout(null);
		jfrm.setSize(485, 415);

		if (index == dados.getQtVitaminas()) {

			// nova vitamina
			jtfNome = new JTextField();
			jtfCodigo = new JTextField();
			jtfPreco = new JTextField();
			jtfQtEstoque = new JTextField();
			jtfTipoVit = new JTextField();
			jtfQtComp = new JTextField();

		} else {

			// vitamina ja existente
			jtfNome = new JTextField(dados.getVitaminas().get(this.index).getNome());
			jtfCodigo = new JTextField(String.valueOf(dados.getVitaminas().get(this.index).getCodigo()));
			jtfPreco = new JTextField(String.valueOf(dados.getVitaminas().get(this.index).getPreco()));
			jtfQtEstoque = new JTextField(String.valueOf(dados.getVitaminas().get(this.index).getQtEstoque()));
			jtfQtComp = new JTextField(String.valueOf(dados.getVitaminas().get(this.index).getQtComp()));
			jtfTipoVit = new JTextField(dados.getVitaminas().get(this.index).getTipoVit());

			jbtnExcluirVit = new JButton("Excluir");
			jbtnExcluirVit.setBounds(170, 320, 120, 30);
			jfrm.add(jbtnExcluirVit);
			jbtnExcluirVit.addActionListener(this);
		}

		jbtnSalvar = new JButton("Salvar");
		jbtnVoltar = new JButton("Voltar");

		jlabNome = new JLabel("Nome do produto:");
		jlabPreco = new JLabel("Preço do produto:");
		jlabCodigo = new JLabel("Codigo do produto:");
		jlabQtEstoque = new JLabel("Quantidade em estoque:");
		jlabTipoVit = new JLabel("Tipo vitaminico:");
		jlabQtComp = new JLabel("Quantidade de comprimidos:");

		jlabNome.setBounds(20, 30, 150, 25);
		jtfNome.setBounds(200, 30, 245, 25);
		jlabPreco.setBounds(20, 70, 150, 25);
		jtfPreco.setBounds(200, 70, 245, 25);
		jlabCodigo.setBounds(20, 110, 150, 25);
		jtfCodigo.setBounds(200, 110, 245, 25);
		jlabQtEstoque.setBounds(20, 150, 170, 25);
		jtfQtEstoque.setBounds(200, 150, 245, 25);
		jlabTipoVit.setBounds(20, 190, 150, 25);
		jtfTipoVit.setBounds(200, 190, 245, 25);
		jlabQtComp.setBounds(20, 230, 200, 25);
		jtfQtComp.setBounds(200, 230, 245, 25);

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

		jfrm.add(jlabTipoVit);
		jfrm.add(jtfTipoVit);

		jfrm.add(jlabQtComp);
		jfrm.add(jtfQtComp);

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
			String tipoVit = jtfTipoVit.getText();
			String qtComp = jtfQtComp.getText();

			boolean x = dados.cadastrarEditarVitamina(nome, preco, codigo, qtEstoque, tipoVit, qtComp, index);

			if (x == true) {
				JOptionPane.showMessageDialog(null, "Vitamina Salva com Sucesso!");
				jfrm.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Erro!");
			}
		}

		if (ae.getActionCommand().equals("Excluir")) {
			dados.excluirVitamina(index);
			jfrm.dispose();
		}
		if (ae.getActionCommand().equals("Voltar")) {
			jfrm.dispose();
		}

	}
}
