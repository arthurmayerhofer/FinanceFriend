package table;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import infra.movimento.ObterMovimento;

@SuppressWarnings("serial")
public class TableResumos extends JFrame {

	public TableResumos() {
		super("Balan�o de Gastos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Cria��o das tabelas
		
		// Adicionando as tabelas a um painel
		JPanel panel = new JPanel(new GridLayout(3, 1));
		// Adicionando o t�tulo para a primeira tabela
        TitledBorder border1 = new TitledBorder("Consolidado Mensal");
        border1.setTitleFont(new Font("Segoe UI", Font.BOLD, 14));
        JScrollPane scroll1 = new JScrollPane(movimentosMensais());
        scroll1.setBorder(border1);
        panel.add(scroll1);
        panel.add(scroll1);
        panel.add(scroll1);
//		panel.setBorder(new TitledBorder("Tabela de Pessoas"));
//		panel.add(new JScrollPane(movimentosMensais()));
//		panel.add(new JScrollPane(movimentosMensais()));
//		panel.add(new JScrollPane(movimentosMensais()));

		// Adicionando o painel ao JFrame
		add(panel);

		// Configura��o do JFrame
		// setSize(600, 400);
		// setLocationRelativeTo(null);
		// setVisible(true);
	}
	// Cria��o das tabelas
	private JTable movimentosMensais() {	
		DefaultTableModel model = new DefaultTableModel(new Object[] { "M�s", "Entradas", "Sa�das" }, 0);
		// Adicionar movimentos � tabela
		addMovimentosTabela(model);
		JTable movimentosMensais = new JTable(model);
		
		return movimentosMensais;		
	}
	// Adicionar movimentos � tabela
	private void addMovimentosTabela(DefaultTableModel model) {
		// Percorre lista de objetos movimentosMensais � tabela
		for (Object[] m : listaMovimentosMensais()) {
			String mes = (String) m[0];
			Double valorEntradas = (Double) m[1];
			Double valorSaidas = (Double) m[2];
			Object[] linha = {mes,valorEntradas,valorSaidas};
			model.addRow(linha);			
		}
	}
	// Criar tabela de movimentos
	private List<Object[]> listaMovimentosMensais() {
		return new ObterMovimento().obterMovimentoMensal();
	}

	public JPanel getTabelaPanel() {
		// Retorna o painel com as tabelas
		return (JPanel) getContentPane().getComponent(0);
	}

}
