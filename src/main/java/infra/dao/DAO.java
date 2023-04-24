package infra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import model.Usuario;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	static {
		try {
			emf = Persistence.createEntityManagerFactory("financeFriendPersistenceUnit");
		} catch (Exception e) {
			// ...
		}
	}

	// Construtores
	public DAO() {
		this(null);
	}

	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	// Abrir e Fechar Transação
	public DAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}

	// Incluir Entidade no Banco
	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}

	// Abrir e Fechar Transação incluindo Entidade no Banco
	public DAO<E> incluir1eTransaction(E entidade) {
		return this.abrirT().incluir(entidade).fecharT();
	}

	// Obter Registros do Banco
	public List<E> obterRegistros() {
		return obterRegistros(10, 0);
	}

	public List<E> obterRegistros(int qtde, int deslocamento) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}

	public List<Object[]> obterMovimentoMensal() {
		return obterMovimentoMensal(10, 0);
	}

	public List<Object[]> obterMovimentoMensal(int qtde, int deslocamento) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		String jpql = "SELECT FUNCTION('DATE_FORMAT', m.data, '%m/%Y'), "
				+ "SUM(CASE WHEN m.tipoMovimento = 'Entrada' THEN m.valor ELSE 0 END), "
				+ "SUM(CASE WHEN m.tipoMovimento = 'Saída' THEN m.valor ELSE 0 END) " + "FROM Movimento m "
				+ "GROUP BY FUNCTION('DATE_FORMAT', m.data, '%m/%Y')";
		Query query = em.createQuery(jpql);
		List<Object[]> results = query.getResultList();
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return results;
	}

	public boolean obterUserSenha(String usuarioInformado, String senhaInformada) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		String jpql = "SELECT u.nomeUsuario, u.senha FROM Usuario u WHERE u.nomeUsuario = :user AND u.senha = :password";
		Query query = em.createQuery(jpql);
		query.setParameter("user", usuarioInformado);
		query.setParameter("password", senhaInformada);
		List<Object[]> result = query.getResultList();

		if (result.isEmpty()) {
			// Object[] row = result.get(0);
//            String nomeUsuario = (String) row[0];
//            String senha = (String) row[1];
			JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
			return false;
		}
		//JOptionPane.showMessageDialog(null, "Usuário e senha válidos");
		return true;
	}

	// Fechar Entity Manager
	public void fechar() {
		em.close();
	}
}
