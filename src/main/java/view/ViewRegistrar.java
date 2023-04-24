package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import infra.movimento.InserirMovimento;
import model.Movimento;
import regra.ValidatorRegistrar;
import table.TableMovimentos;

@SuppressWarnings("serial")
public class ViewRegistrar extends JDialog {
	protected JComboBox<String> tipoMovimento;
	private JTextField campoData;
	private JTextField campoValor;
	private JComboBox<String> comboCategoria;
	private JTextField campoDescricao;
	private ValidatorRegistrar validateCampos;

	public ViewRegistrar() throws SQLException {
		setTitle("Registrar");
		setModal(true);

		try {
			// Define o Look and Feel do sistema para Nimbus
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5, 5, 5, 5);

		// Combo Tipo de Registro
		JLabel labelTipo = new JLabel("Tipo de Transação:");
		painel.add(labelTipo, gbc);

		tipoMovimento = new JComboBox<>(new String[] { "Entrada", "Saida" });
		gbc.gridx++;
		painel.add(tipoMovimento, gbc);

		// Campo Data
		JLabel labelData = new JLabel("Data:");
		gbc.gridx = 0;
		gbc.gridy++;
		painel.add(labelData, gbc);

		campoData = new JTextField(10);
		campoData.setText(LocalDate.now().toString());
		gbc.gridx++;
		painel.add(campoData, gbc);
		campoData.setText("00/00/2023");

		// Campo Valor
		JLabel labelValor = new JLabel("Valor:");
		gbc.gridx = 0;
		gbc.gridy++;
		painel.add(labelValor, gbc);

		campoValor = new JTextField(10);
		gbc.gridx++;
		painel.add(campoValor, gbc);

		// Combo Categoria
		JLabel labelCategoria = new JLabel("Categoria:");
		gbc.gridx = 0;
		gbc.gridy++;
		painel.add(labelCategoria, gbc);

		comboCategoria = new JComboBox<>(new String[] { "Alimentação", "Transporte", "Moradia", "Lazer", "Outros" });
		gbc.gridx++;
		painel.add(comboCategoria, gbc);

		// Campo Descrição
		JLabel labelDescricao = new JLabel("Descrição:");
		gbc.gridx = 0;
		gbc.gridy++;
		painel.add(labelDescricao, gbc);

		campoDescricao = new JTextField(30);
		gbc.gridx++;
		painel.add(campoDescricao, gbc);

		// Botões
		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(e -> {
			botaoSalvar();
		});
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		painel.add(botaoSalvar, gbc);

		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.addActionListener(e -> dispose());
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.gridwidth = 0;
		painel.add(botaoCancelar, gbc);

		painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(painel);
		pack();
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private void botaoSalvar() {
		this.setVisible(false);
		//Insere movimento no banco de dados
		new InserirMovimento(getMovimentoCampos());
		cleanCampos();
		//Exibe Tabela Movimentos com novo registo
		new TableMovimentos();
	}
	public Movimento getMovimentoCampos() {
		// Ler dados dos campos
		String tipo = (String) tipoMovimento.getSelectedItem();
		String dataTexto = campoData.getText().trim();
		String valorTexto = campoValor.getText().trim();
		String categoria = (String) comboCategoria.getSelectedItem();
		String descricao = campoDescricao.getText().trim();
		// Validar Campos
		validateCampos = new ValidatorRegistrar(dataTexto, valorTexto);
		return new Movimento(tipo, validateCampos.getData(), categoria, descricao, validateCampos.getValor());
	}
	
    private void cleanCampos() {
        // Limpar campos de entrada
    	 tipoMovimento.setSelectedIndex(0);
         campoValor.setText("");
         comboCategoria.setSelectedIndex(0);
         campoDescricao.setText("");
         campoData.setText("");
    }
}
