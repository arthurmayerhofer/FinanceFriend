package infra.usuario;

import java.util.List;

import infra.dao.UsuarioDAO;
import model.Usuario;

public class ObterUsuario {
private UsuarioDAO dao;
	
	public ObterUsuario() {
		this.dao = new UsuarioDAO();
	}
	public List<Usuario> getList() {
		List<Usuario> movimentos = dao.obterRegistros();
		return movimentos;
	}
	
	public boolean validarUserSenha(String user, String senha){
		return dao.obterUserSenha(user, senha);
	}
}
