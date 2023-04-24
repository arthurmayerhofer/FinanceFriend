package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import infra.usuario.ObterUsuario;

@SuppressWarnings("serial")
public class ViewLogin extends JFrame {
	JTextField campoUsuario;
	JPasswordField campoSenha;

	public ViewLogin() {
		super("Login");

		try {
			// Define o Look and Feel do sistema para Nimbus
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Cria o JPanel para a tela de login
		JPanel painelLogin = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		painelLogin.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		// painelLogin.setBackground(new Color(36, 36, 36)); // Define a cor de fundo do
		// painel para cinza escuro

		// Adiciona o rótulo do título da tela
		JLabel labelTitulo = new JLabel("FinanceFriend");
		labelTitulo.setForeground(Color.BLACK);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 20, 0);
		painelLogin.add(labelTitulo, gbc);

		// Adiciona o rótulo de usuário e o campo de texto correspondente
		JLabel labelUsuario = new JLabel("Usuário:");
		labelUsuario.setForeground(Color.BLACK);
		labelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 10, 10);
		painelLogin.add(labelUsuario, gbc);

		campoUsuario = new JTextField(20);
		campoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		campoUsuario.setBackground(Color.WHITE);
		campoUsuario.setForeground(Color.BLACK);
		campoUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		gbc.gridx = 1;
		gbc.insets = new Insets(0, 0, 10, 0);
		painelLogin.add(campoUsuario, gbc);

		// Adiciona o rótulo de senha e o campo de texto correspondente
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setForeground(Color.BLACK);
		labelSenha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 10, 10);
		painelLogin.add(labelSenha, gbc);

		campoSenha = new JPasswordField(20);
		campoSenha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		campoSenha.setBackground(Color.WHITE);
		campoSenha.setForeground(Color.BLACK);
		campoSenha.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		gbc.gridx = 1;
		gbc.insets = new Insets(0, 0, 10, 0);
		painelLogin.add(campoSenha, gbc);

		// Adiciona o botão de login
		JButton botaoLogin = new JButton("   Login   ");
		botaoLogin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		botaoLogin.setBackground(new Color(170, 155, 155)); // Define a cor de fundo do botão para verde claro
		botaoLogin.setForeground(Color.BLACK);
		botaoLogin.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		painelLogin.add(botaoLogin, gbc);

		// Adiciona o botão de cadastro
		JButton botaoCadastro = new JButton("Cadastro");
		botaoCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		botaoCadastro.setBackground(new Color(60, 60, 80)); // Define a cor de fundo do botão para verde claro
		botaoCadastro.setForeground(Color.WHITE);
		botaoCadastro.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
		gbc.gridy = 4;
		painelLogin.add(botaoCadastro, gbc);

		// Cria o ActionListener para o botão de login
		botaoLogin.addActionListener(e -> botaoLogin());
		// Cria o ActionListener para o botão de login
		botaoCadastro.addActionListener(e -> botaoCadastro());

		// Adiciona o painel de login à tela
		this.add(painelLogin);

		// Define as configurações da janela
		this.setSize(450, 300);
		this.setLocationRelativeTo(null); // Centraliza a janela na tela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
	private void botaoLogin() {
		// Ler dados dos campos
		String nomeUsuario = campoUsuario.getText().trim();
		char[] senhaChar = campoSenha.getPassword();
		String senha = new String(senhaChar).trim();		
		// Validar Campos
		if(new ObterUsuario().validarUserSenha(nomeUsuario, senha)) {
			new ViewHome();
			this.setVisible(false);
		}
	}

	private void botaoCadastro() {
		new ViewCadastro();
	}


//	public static void main(String[] args) {
//		new JanelaLogin();
//	}
}
