package interfaceOO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

/**
 * A classe TelaDetalheVitamina representa a interface gráfica para exibir uma JList com as vitaminas já cadastrados. 
 * Ela serve também para detalha-las e fazer busca por nome dos mesmos. 
 * Implementa ListSelectionListener e ActionListener para tratar eventos relacionados à seleção da lista e botões.
 * 
 * @author Maria Clara Oleari de Araujo
 * @since 2023
 * @version 1.0
 */

public class TelaDetalheVitamina implements ListSelectionListener, ActionListener {

	private JFrame jfrm1 = new JFrame("Vitaminas");
	private JPanel conteudoDetalhe = new JPanel();
	private JLabel jlabBusca, jlabTitulo;
	private JTextField jtfBusca;
	private JButton jbtnCadastrarVit, jbtnAtt, jbtnBusca;
	private JList<String> jlistV;
	private String[] listaNomesV;
	private JScrollPane scroll;
	private static ControleDados dados;

	/**
	 * O método mostrarDadosV exibe a JList com as vitaminas cadastradas.
	 * 
	 * @param v O objeto ControleDados que contém os dados do sistema.
	 */
	
	public void mostrarDadosV(ControleDados v) {
		dados = v;

		listaNomesV = new ControleVitamina(dados).getNomeVitamina();
		jlistV = new JList<String>(listaNomesV);

		jfrm1.setLayout(null);
		jfrm1.setSize(500, 500);

		conteudoDetalhe.setLayout(null);
		conteudoDetalhe.setBackground(new Color(255, 127, 80));
		jlabBusca = new JLabel("Digite o nome da vitamina desejada para realizar a busca:");
		jtfBusca = new JTextField();
		jbtnBusca = new JButton("Buscar");
		jlabTitulo = new JLabel("Vitaminas Cadastradas");
		jbtnCadastrarVit = new JButton("Cadastrar");
		jbtnAtt = new JButton("Atualizar");

		jlabTitulo.setFont(new Font("Playfair Display", Font.BOLD, 20));
		jlabTitulo.setForeground(Color.white);

		jlabBusca.setBounds(60, 30, 500, 25);
		jtfBusca.setBounds(80, 70, 160, 25);
		jbtnBusca.setBounds(270, 67, 120, 30);
		conteudoDetalhe.setBounds(60, 135, 365, 40);
		jlabTitulo.setBounds(50, 8, 400, 25);
		jbtnCadastrarVit.setBounds(105, 390, 120, 30);
		jbtnAtt.setBounds(260, 390, 120, 30);

		conteudoDetalhe.setVisible(true);
		conteudoDetalhe.add(jlabTitulo);

		jlistV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// adiciona a lista ao scroll pane.
		scroll = new JScrollPane(jlistV);
		scroll.setBounds(92, 200, 300, 160);
		jlistV.setVisibleRowCount(10);

		jfrm1.add(jlabBusca);
		jfrm1.add(jtfBusca);
		jfrm1.add(jbtnBusca);
		jfrm1.add(conteudoDetalhe);
		jfrm1.add(jbtnCadastrarVit);
		jfrm1.add(jbtnAtt);
		jfrm1.getContentPane().add(scroll);

		jlistV.addListSelectionListener(this);

		jbtnBusca.addActionListener(this);
		jbtnCadastrarVit.addActionListener(this);
		jbtnAtt.addActionListener(this);

		jfrm1.setVisible(true);
	}

	/**
	 * O método actionPerformed é chamado quando ocorre um clique no botão.
	 * 
	 * @param ae O evento de ação
	 */
	
	public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand().equals("Cadastrar")) {
			new TelaVitamina(dados, dados.getQtVitaminas());
		}

		if (ae.getActionCommand().equals("Atualizar")) {
			jlistV.setListData(new ControleVitamina(dados).getNomeVitamina());
			jlistV.updateUI();
		}

		if (ae.getActionCommand().equals("Buscar")) {
			String nomeBusca = jtfBusca.getText();
			jtfBusca.setText("");

			int b;

			b = new ControleVitamina(dados).procurarVitamina(nomeBusca);

			// caso ja esteja cadastrada e foi encontrada
			if (b != -1) {
				new TelaVitamina(dados, b);

			} else {
				JOptionPane.showMessageDialog(null, "Vitamina nao encontrada.");
			}

		}

	}

	/**
	 * O método valueChanged é chamado quando ocorre um evento de alteração na seleção da lista.
	 * 
	 * @param e Evento de alteração
	 */
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if (e.getValueIsAdjusting() && src == jlistV) {
			new TelaVitamina(dados, jlistV.getSelectedIndex());
		}
	}

}
