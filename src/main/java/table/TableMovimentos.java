package table;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import infra.movimento.ObterMovimento;
import model.Movimento;

@SuppressWarnings("serial")
public class TableMovimentos extends JFrame {
	private DefaultTableModel model;
	private JTable tabelaMovimentos;

	public TableMovimentos() {
		super("Editar Registros");
		
		// Adicionar ouvinte de eventos para a tabela
		// model.addTableModelListener(new TableModelObserver());
		
		//setPreferredSize(new Dimension(600, 400));
		// Adicionando as tabelas a um painel
		JPanel panel = new JPanel(new GridLayout(3, 1));
		panel.add(new JScrollPane(criarTabela()));
		panel.setPreferredSize(new Dimension(600,350));
		// Adicionando o painel ao JFrame
		add(panel);

		// Configuração do JFrame
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	// Criação das tabelas
	private JTable criarTabela() {
		String[] colunas = { "Id", "Data", "Valor", "Categoria", "Descrição" };
		model = new DefaultTableModel(colunas, 0);
		tabelaMovimentos = new JTable(model);
		tabelaMovimentos.getTableHeader().setReorderingAllowed(false); // impede que o usuário reordene as colunas
		tabelaMovimentos.setPreferredSize(new Dimension(600,400));
		// Adicionar movimentos à tabela
		addMovimentosTabela(model);
		return tabelaMovimentos;
	}

	private void addMovimentosTabela(DefaultTableModel model) {
		// Adicionar movimentos à tabela
		for (Movimento movimento : listaMovimentos()) {
			Object[] linha = { movimento.getId(), movimento.getData(), movimento.getValor(), movimento.getCategoria(),
					movimento.getDescricao() };
			model.addRow(linha);
		}
	}
	// Criar tabela de movimentos
	private List<Movimento> listaMovimentos() {
		return new ObterMovimento().getList();
	}

	public JPanel getTabelaPanel() {
		// Retorna o painel com as tabelas
		return (JPanel) getContentPane().getComponent(0);
	}
}
