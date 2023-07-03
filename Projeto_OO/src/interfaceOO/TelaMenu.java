package interfaceOO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

/**
 * A classe TelaMenu é responsável por exibir o menu principal da aplicação.
 * Permite ao usuário cadastrar medicamentos, vitaminas e cosméticos. 
 * Implementa a interface ActionListener para lidar com eventos de botões.
 * 
 * @author Maria Clara Oleari de Araujo
 * @version 1.0
 * @since 2023
 */

public class TelaMenu implements ActionListener {

	private JFrame jfrm = new JFrame("Menu Principal");
	private JPanel conteudoMenu = new JPanel();
	private JLabel jlabTitulo;
	private JButton jbtnMedicamento, jbtnVitamina, jbtnCosmetico;
	private static ControleDados dados = new ControleDados();

	/**
	 * Construtor da classe TelaMenu. 
	 * Cria a interface gráfica do menu principal.
	 */

	public TelaMenu() {

		jfrm.setLayout(null);
		jfrm.setSize(500, 500);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		conteudoMenu.setLayout(null);
		conteudoMenu.setBackground(new Color(255, 127, 80));

		jbtnMedicamento = new JButton("Cadastrar Medicamento");
		jbtnMedicamento.setForeground(Color.white);
		jbtnVitamina = new JButton("Cadastrar Vitamina");
		jbtnVitamina.setForeground(Color.white);
		jbtnCosmetico = new JButton("Cadastrar Cosmetico");
		jbtnCosmetico.setForeground(Color.white);

		jbtnMedicamento.setBackground(new Color(255, 127, 80));
		jbtnVitamina.setBackground(new Color(255, 127, 80));
		jbtnCosmetico.setBackground(new Color(255, 127, 80));

		jbtnMedicamento.addActionListener(this);
		jbtnVitamina.addActionListener(this);
		jbtnCosmetico.addActionListener(this);

		jlabTitulo = new JLabel("Farmaria");
		jlabTitulo.setFont(new Font("Playfair Display", Font.BOLD, 50));
		jlabTitulo.setForeground(Color.white);

		conteudoMenu.setBounds(00, 00, 700, 120);
		jlabTitulo.setBounds(130, 30, 260, 60);
		conteudoMenu.setVisible(true);

		jbtnMedicamento.setBounds(127, 160, 220, 60);
		jbtnVitamina.setBounds(127, 260, 220, 60);
		jbtnCosmetico.setBounds(127, 360, 220, 60);

		conteudoMenu.add(jlabTitulo);

		jfrm.add(conteudoMenu);

		jfrm.add(jbtnMedicamento);
		jfrm.add(jbtnVitamina);
		jfrm.add(jbtnCosmetico);

		jfrm.setVisible(true);
	}

	/**
	 * Método de gerenciamento de eventos, acionado quando ocorre uma ação. 
	 * Verifica o comando da ação e executa a ação correspondente.
	 *
	 * @param ae O objeto ActionEvent, o qual representa a ação feita.
	 */

	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getActionCommand().equals("Cadastrar Medicamento")) {
			// JOptionPane.showMessageDialog(jfrm, "Registro criado com sucesso!");
			new TelaDetalheMedicamento().mostrarDadosM(dados);
			;// .mostrarDados(dados,1);
		}
		
		if (ae.getActionCommand().equals("Cadastrar Vitamina")) {
			new TelaDetalheVitamina().mostrarDadosV(dados);
		}
		
		if (ae.getActionCommand().equals("Cadastrar Cosmetico")) {
			new TelaDetalheCosmetico().mostrarDadosC(dados);
		}
	}

	/**
	 * Método main para executar a aplicação. 
	 * Cria uma instância da classe Tela Menu para exibir o menu principal.
	 * 
	 * @param args Os argumentos da linha de comando (não utilizados).
	 */
	public static void main(String args[]) {
		new TelaMenu();
	}
}
