package infra.usuario;

import infra.dao.DAO;
import model.Usuario;

public class InserirUsuario {
	private DAO<Usuario> dao;

	public InserirUsuario(Usuario usuario) {
		this.dao = new DAO<>(Usuario.class);
		inserirListaMovimento(usuario);
	}

	private void inserirListaMovimento(Usuario usuario) {
		dao.incluir1eTransaction(usuario).fechar();
	}
}
