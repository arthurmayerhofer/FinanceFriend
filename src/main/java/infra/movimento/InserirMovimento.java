package infra.movimento;

import infra.dao.DAO;
import model.Movimento;

public class InserirMovimento {
	private DAO<Movimento> dao;

	public InserirMovimento(Movimento movimento) {
		this.dao = new DAO<>(Movimento.class);
		inserirListaMovimento(movimento);
	}

	private void inserirListaMovimento(Movimento movimento) {
		dao.incluir1eTransaction(movimento).fechar();
	}

//	public static void main(String[] args) throws ParseException {
//
//		String dataString = "25/12/2022";
//		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//		Date data = null;
//		data = (Date) formato.parse(dataString);
//
//		Movimento movimento = new Movimento("Saída", data, "Alimentação", "carne seca", 42.);
//		DAO<Movimento> dao = new DAO<>(Movimento.class);
//		dao.incluir1eTransaction(movimento).fechar();
//	}
}
