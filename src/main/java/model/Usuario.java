package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "O nome não pode estar em branco.")
	private String nome;
	@NotBlank(message = "O nome de usuário não pode estar em branco.")
	private String nomeUsuario;
	@NotBlank(message = "O e-mail não pode estar em branco.")
	private String email;
	@NotBlank(message = "A senha não pode estar em branco.")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
	private String senha;

	public Usuario() {
	}

	public Usuario(String nomeUsuario, String senha) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public Usuario(String nome, String nomeUsuario, String email, String senha) {
		this.nome = nome;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
	}

	public void exibirMensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
//	if (senha.length() < 8) {
//		exibirMensagemErro("A senha deve ter no mínimo 8 caracteres.");
//		throw new IllegalArgumentException("A senha deve ter no mínimo 8 caracteres.");
//	}
//	if (!senha.matches(".*\\d.*")) {
//		exibirMensagemErro("A senha deve conter pelo menos um número.");
//		throw new IllegalArgumentException("A senha deve conter pelo menos um número.");
//	}
//	if (!senha.matches(".*[a-zA-Z].*")) {
//		exibirMensagemErro("A senha deve conter pelo menos uma letra.");
//		throw new IllegalArgumentException("A senha deve conter pelo menos uma letra.");
//	}
}
