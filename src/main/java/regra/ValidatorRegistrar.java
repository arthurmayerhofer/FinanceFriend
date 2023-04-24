package regra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ValidatorRegistrar{

	private JPanel view;
	private Date data;
	private double valor;
	public ValidatorRegistrar(){ 
	}
	public ValidatorRegistrar(String dataTexto, String valorTexto){
		 // Validar campos obrigatórios
        if (!validarCamposObrigatorios(valorTexto, dataTexto)) {
            JOptionPane.showMessageDialog(view, "Por favor, preencha todos os campos obrigatórios.");
            return;
        }
        // Validar formato dos campos
        valor = validarValor(valorTexto);
        data = validarData(dataTexto);       
	}

	
	public boolean validarCamposObrigatorios(String valorTexto, String dataTexto) {
	       return !valorTexto.isEmpty() && !dataTexto.isEmpty();
	}
	
	private double validarValor(String valorTexto) {
	    try {
	        return Double.parseDouble(valorTexto);
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(view, "Por favor, insira um valor válido.");
	        throw ex;
	    }
	}
	
	public Date validarData(String dataTexto) {
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        return sdf.parse(dataTexto);
	    } catch (ParseException ex) {
	        JOptionPane.showMessageDialog(view, "Por favor, insira uma data válida no formato dd/MM/yyyy.");
	        throw new RuntimeException(ex);
	    }
	}

	public Date getData() {
		return data;
	}
	public double getValor() {
		return valor;
	}


}
