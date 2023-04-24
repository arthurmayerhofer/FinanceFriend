package regra;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

import model.Usuario;

public class ValidatorCadastrar {
    
	public Usuario getUsuarioCampos(String nomeCampo, String usuarioCampo, String emailCampo, String senhaCampo) throws Exception {
	    // Ler dados dos campos
	    String nome = nomeCampo != null ? nomeCampo.trim() : null;
	    String nomeUsuario = usuarioCampo != null ? usuarioCampo.trim() : null;
	    String email = emailCampo != null ? emailCampo.trim() : null;
	    String senha = senhaCampo != null ? senhaCampo.trim() : null;

	    // Validar Campos
	    if (StringUtils.isBlank(nome)) {
	        JOptionPane.showMessageDialog(null, "O campo nome é obrigatório.");
	        throw new Exception("O campo nome é obrigatório.");
	    }
	    if (StringUtils.isBlank(nomeUsuario)) {
	        JOptionPane.showMessageDialog(null, "O campo nome de usuário é obrigatório.");
	        throw new Exception("O campo nome de usuário é obrigatório.");
	    }
	    if (StringUtils.isBlank(email)) {
	        JOptionPane.showMessageDialog(null, "O campo e-mail é obrigatório.");
	        throw new Exception("O campo e-mail é obrigatório.");
	    }
	    if (StringUtils.isBlank(senha)) {
	        JOptionPane.showMessageDialog(null, "O campo senha é obrigatório.");
	        throw new Exception("O campo senha é obrigatório.");
	    }
	    return new Usuario(nome, nomeUsuario, email, senha);
	}
    
//    public void cadastrarUsuario() {
//        try {
//            Usuario usuario = getUsuarioCampos();
//            // código para cadastrar o usuário
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//        }
//    }
}
