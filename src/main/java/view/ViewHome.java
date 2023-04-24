package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;

import table.TableMovimentos;
import table.TableResumos;

@SuppressWarnings("serial")
public class ViewHome extends JFrame implements ActionListener {
	private JPanel painelHome;
	private JButton btnAddMovimento;
	private JButton btnShowRegistros;

	public ViewHome() {
		super("Principal");

		try {
			// Define o Look and Feel do sistema para Nimbus
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Cria o JPanel para a tela de login
		painelHome = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		painelHome.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		// painelHome.setBackground(new Color(155, 155, 155)); // Define a cor de fundo

		// Cria um objeto da classe TabelaFrame
		TableResumos tabelaFrame = new TableResumos();

		// Define o tamanho preferido da tabela
		tabelaFrame.getTabelaPanel().setPreferredSize(new Dimension(600, 400));
		// Obtém o painel com as tabelas da classe TabelaFrame
		JPanel tabelaPanel = tabelaFrame.getTabelaPanel();

		// Adiciona o rótulo do título da tela
		JLabel labelTitulo = new JLabel("Orçamento Anual");
		labelTitulo.setForeground(Color.BLACK);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 20, 0);
		painelHome.add(labelTitulo, gbc);
		
		// Define configurações gbc para Adicionar o painel de Tabelas Resumo
		gbc.gridx = 1; // coluna 1
		gbc.gridy = 1; // linha 0
		gbc.gridwidth = 2; // ocupa 2 colunas
		gbc.gridheight = 1; // ocupa 1 linha
		gbc.insets = new Insets(10, 10, 10, 10); // margem
		painelHome.add(tabelaPanel, gbc);

		// Cria o menu
		JMenuBar menuBar = new JMenuBar();
		// Cria o botão "Add Movimento" e adiciona ao painel
		btnAddMovimento = new JButton("    +    ");
		btnAddMovimento.addActionListener(this);
		// Cria o botão "Ver Registros" e adiciona ao painel
		btnShowRegistros = new JButton("Ver Registros");
		btnShowRegistros.addActionListener(this);
		// Adiciona botões ao MenuBar
		menuBar.add(btnAddMovimento);
		menuBar.add(btnShowRegistros);
		// Adiciona o menu à janela
		this.setJMenuBar(menuBar);

		// Define as configurações da janela
		this.setContentPane(painelHome);
		this.setSize(700, 600);
		this.setLocationRelativeTo(null); // Centraliza a janela na tela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddMovimento || e.getActionCommand().equals("+")) {
			// Código para abrir a tela de registros
			try {
				new ViewRegistrar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == btnShowRegistros || e.getActionCommand().equals("Registros")) {
			// Código para abrir a tela de registros
			new TableMovimentos();
		}
	}
}
