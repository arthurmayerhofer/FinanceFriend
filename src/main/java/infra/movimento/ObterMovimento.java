package infra.movimento;

import java.util.List;

import infra.dao.MovimentoDAO;
import model.Movimento;

public class ObterMovimento {
	private MovimentoDAO dao;
	
	public ObterMovimento() {
		this.dao = new MovimentoDAO();
	}
	public List<Movimento> getList() {
		List<Movimento> movimentos = dao.obterRegistros();
		return movimentos;
	}
	
	public List<Object[]> obterMovimentoMensal(){
		List<Object[]> mmensal = dao.obterMovimentoMensal();
		return mmensal;
	}
	
//	public static void main(String[] args) {
//		MovimentoDAO dao = new MovimentoDAO();
//		//List<Movimento> movimentos = dao.obterRegistros();
//		List<Object[]> mMensal = dao.obterMovimentoMensal();
//		
//		
//		for (Object[] m : mMensal) {
//			System.out.println("MÊS: " + m[0] + ", ENTRADAS: " + m[1] + ", SAÍDAS: " + m[2]);
//		}
//	}

}
