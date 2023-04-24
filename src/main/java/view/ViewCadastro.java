package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.springframework.beans.factory.annotation.Autowired;

import infra.usuario.InserirUsuario;
import model.Usuario;
import regra.ValidatorCadastrar;
import test.Main;

@SuppressWarnings("serial")
public class ViewCadastro extends JFrame {
	JTextField campoNome;
	JTextField campoUsuario;
	JTextField campoEmail;
	JPasswordField campoSenha;
	
	public ViewCadastro() {
		super("Cadastro");

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
		JLabel labelTitulo = new JLabel("Preencha o Cadastro");
		labelTitulo.setForeground(Color.BLACK);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 20, 0);
		painelLogin.add(labelTitulo, gbc);

		// Adiciona o rótulo de usuário e o campo de texto correspondente
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setForeground(Color.BLACK);
		labelNome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 10, 10);
		painelLogin.add(labelNome, gbc);
		campoNome = new JTextField(20);
		campoNome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		campoNome.setBackground(Color.WHITE);
		campoNome.setForeground(Color.BLACK);
		campoNome.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		gbc.gridx = 1;
		gbc.insets = new Insets(0, 0, 10, 0);
		painelLogin.add(campoNome, gbc);

		// Adiciona o rótulo de usuário e o campo de texto correspondente
		JLabel labelUsuario = new JLabel("Usuário:");
		labelUsuario.setForeground(Color.BLACK);
		labelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		gbc.gridx = 0;
		gbc.gridy = 2;
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
		JLabel labelEmail = new JLabel("E-mail:");
		labelEmail.setForeground(Color.BLACK);
		labelEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 10, 10);
		painelLogin.add(labelEmail, gbc);
		campoEmail = new JTextField(20);
		campoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		campoEmail.setBackground(Color.WHITE);
		campoEmail.setForeground(Color.BLACK);
		campoEmail.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		gbc.gridx = 1;
		gbc.insets = new Insets(0, 0, 10, 0);
		painelLogin.add(campoEmail, gbc);

		// Adiciona o rótulo de senha e o campo de texto correspondente
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setForeground(Color.BLACK);
		labelSenha.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		gbc.gridx = 0;
		gbc.gridy = 4;
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

		// Adiciona o botão de cadastro
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		botaoCadastrar.setBackground(new Color(60, 60, 80)); // Define a cor de fundo do botão para verde claro
		botaoCadastrar.setForeground(Color.WHITE);
		botaoCadastrar.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		painelLogin.add(botaoCadastrar, gbc);
		
		// Adiciona o botão de login
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		botaoCancelar.setBackground(new Color(170, 155, 155)); // Define a cor de fundo do botão para verde claro
		botaoCancelar.setForeground(Color.BLACK);
		botaoCancelar.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.CENTER;
		painelLogin.add(botaoCancelar, gbc);

		// Cria o ActionListener para o botão de login
		botaoCancelar.addActionListener(e ->  dispose());
		// Cria o ActionListener para o botão de login
		botaoCadastrar.addActionListener(e -> botaoCadastrar());

		// Adiciona o painel de login à tela
		this.add(painelLogin);

		// Define as configurações da janela
		this.setSize(450, 400);
		this.setLocationRelativeTo(null); // Centraliza a janela na tela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		 // Adiciona um WindowListener para abrir a nova janela quando a janela atual for fechada
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // Cria e exibe a nova janela
//            	new ViewLogin();
//            }
//        });
	}


	private Object botaoCadastrar() {
		try {
			//Insere movimento no banco de dados
			new InserirUsuario(getUsuarioCampos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		cleanCampos();
		return null;
	}

	public Usuario getUsuarioCampos() throws Exception {
		// Ler dados dos campos
		String nome = campoNome.getText().trim();
		String nomeUsuario = campoUsuario.getText().trim();
		String email = campoEmail.getText().trim();
		char[] senhaChar = campoSenha.getPassword();
		String senha = new String(senhaChar).trim();
		// Validar Campos
		return new ValidatorCadastrar().getUsuarioCampos(nome, nomeUsuario, email, senha);
	}
	
	private void cleanCampos() {
        // Limpar campos de entrada
		campoNome.setText("");
		campoUsuario.setText("");
		campoEmail.setText("");
		campoSenha.setText("");
    }
}
