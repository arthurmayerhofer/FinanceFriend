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
	        JOptionPane.showMessageDialog(null, "O campo nome � obrigat�rio.");
	        throw new Exception("O campo nome � obrigat�rio.");
	    }
	    if (StringUtils.isBlank(nomeUsuario)) {
	        JOptionPane.showMessageDialog(null, "O campo nome de usu�rio � obrigat�rio.");
	        throw new Exception("O campo nome de usu�rio � obrigat�rio.");
	    }
	    if (StringUtils.isBlank(email)) {
	        JOptionPane.showMessageDialog(null, "O campo e-mail � obrigat�rio.");
	        throw new Exception("O campo e-mail � obrigat�rio.");
	    }
	    if (StringUtils.isBlank(senha)) {
	        JOptionPane.showMessageDialog(null, "O campo senha � obrigat�rio.");
	        throw new Exception("O campo senha � obrigat�rio.");
	    }
	    return new Usuario(nome, nomeUsuario, email, senha);
	}
    
//    public void cadastrarUsuario() {
//        try {
//            Usuario usuario = getUsuarioCampos();
//            // c�digo para cadastrar o usu�rio
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//        }
//    }
}
