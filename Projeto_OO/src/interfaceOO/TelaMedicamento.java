package interfaceOO;

import java.awt.event.*;

import javax.swing.*;
import controle.*;

/**
 * A classe TelaMedicamento representa a interface gráfica para cadastro, edição e exclusão de medicamentos. 
 * Ela implementa o ActionListener para tratar eventos dos botões.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaMedicamento implements ActionListener {

	private JFrame jfrm = new JFrame("Medicamentos");
	private JTextField jtfNome, jtfCodigo, jtfPreco, jtfQtEstoque, jtfValidade, jtfUtilidade, jtfDosagem;
	private JLabel jlabNome, jlabCodigo, jlabPreco, jlabQtEstoque, jlabValidade, jlabUtilidade, jlabDosagem;
	private JButton jbtnSalvar, jbtnVoltar, jbtnExcluirMed;
	private static ControleDados dados;
	private int index;

	/**
	 * Construtor da classe TelaMedicamento.
	 * 
	 * @param d     Objeto ControleDados que contém os dados do sistema.
	 * @param index O índice do medicamento a ser cadastrado, editado ou excluído.
	 */

	public TelaMedicamento(ControleDados d, int index) {
		dados = d;
		this.index = index;

		jfrm.setLayout(null);
		jfrm.setSize(485, 415);

		if (index == dados.getQtMedicamentos()) {

			// novo medicamento
			jtfNome = new JTextField();
			jtfCodigo = new JTextField();
			jtfPreco = new JTextField();
			jtfQtEstoque = new JTextField();
			jtfUtilidade = new JTextField();
			jtfValidade = new JTextField();
			jtfDosagem = new JTextField();

		} else {

			// medicamento ja existente
			jtfNome = new JTextField(dados.getMedicamentos().get(this.index).getNome());
			jtfCodigo = new JTextField(String.valueOf(dados.getMedicamentos().get(this.index).getCodigo()));
			jtfPreco = new JTextField(String.valueOf(dados.getMedicamentos().get(this.index).getPreco()));
			jtfQtEstoque = new JTextField(String.valueOf(dados.getMedicamentos().get(this.index).getQtEstoque()));
			jtfUtilidade = new JTextField(dados.getMedicamentos().get(this.index).getUtilidade());
			jtfValidade = new JTextField(String.valueOf(dados.getMedicamentos().get(this.index).getValidade()));
			jtfDosagem = new JTextField(dados.getMedicamentos().get(this.index).getDosagem());

			jbtnExcluirMed = new JButton("Excluir");
			jbtnExcluirMed.setBounds(170, 320, 120, 30);
			jfrm.add(jbtnExcluirMed);
			jbtnExcluirMed.addActionListener(this);
		}

		jbtnSalvar = new JButton("Salvar");
		jbtnVoltar = new JButton("Voltar");

		jlabNome = new JLabel("Nome do produto:");
		jlabPreco = new JLabel("Preço do produto:");
		jlabCodigo = new JLabel("Codigo do produto:");
		jlabQtEstoque = new JLabel("Quantidade em estoque:");
		jlabUtilidade = new JLabel("Utilidade:");
		jlabValidade = new JLabel("Data de validade:");
		jlabDosagem = new JLabel("Dosagem:");

		jlabNome.setBounds(20, 30, 150, 25);
		jtfNome.setBounds(200, 30, 245, 25);
		jlabPreco.setBounds(20, 70, 150, 25);
		jtfPreco.setBounds(200, 70, 245, 25);
		jlabCodigo.setBounds(20, 110, 150, 25);
		jtfCodigo.setBounds(200, 110, 245, 25);
		jlabQtEstoque.setBounds(20, 150, 170, 25);
		jtfQtEstoque.setBounds(200, 150, 245, 25);
		jlabUtilidade.setBounds(20, 190, 150, 25);
		jtfUtilidade.setBounds(200, 190, 245, 25);
		jlabDosagem.setBounds(20, 230, 200, 25);
		jtfDosagem.setBounds(200, 230, 245, 25);
		jlabValidade.setBounds(20, 270, 150, 25);
		jtfValidade.setBounds(200, 270, 245, 25);

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

		jfrm.add(jlabUtilidade);
		jfrm.add(jtfUtilidade);

		jfrm.add(jlabDosagem);
		jfrm.add(jtfDosagem);

		jfrm.add(jlabValidade);
		jfrm.add(jtfValidade);

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
			String utilidade = jtfUtilidade.getText();
			String dosagem = jtfDosagem.getText();
			String validade = jtfValidade.getText();

			boolean x = dados.cadastrarEditarMedicamento(nome, preco, codigo, 
					qtEstoque, utilidade, dosagem, validade, index);

			if (x == true) {
				JOptionPane.showMessageDialog(null, "Medicamento Salvo com Sucesso!");
				jfrm.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Erro!");
			}
		}

		if (ae.getActionCommand().equals("Excluir")) {
			dados.excluirMedicamento(index);
			jfrm.dispose();
		}

		if (ae.getActionCommand().equals("Voltar")) {
			jfrm.dispose();
		}
	}
}
