package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Extensao;
import controle.ExtensaoControle;
import dao.ExtensaoDAO;

public class ExtensaoVisao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ExtensaoControle controle = new ExtensaoControle(new ExtensaoDAO(Extensao.class));
	private JTextField tfExtensao;
	private JLabel lblNewLabel;
	private JButton btnAdicionar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExtensaoVisao frame = new ExtensaoVisao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExtensaoVisao() {
		setTitle("Extens\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JButton btnRemover = new JButton("Remover Selecionado");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row != -1 && row > 0){
					Long id = Long.valueOf(table.getModel().getValueAt(row,0).toString());
					((DefaultTableModel) table.getModel()).removeRow(row);
					controle.excluir(id);
					table.repaint();
				} else {
					controle.alerta("Nenhuma linha selecionada", null);
				}
			}
		});
		
		tfExtensao = new JTextField();
		tfExtensao.setColumns(10);
		
		lblNewLabel = new JLabel("Extens\u00E3o");
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Extensao extensao = new Extensao();
				extensao.setExtensao(tfExtensao.getText());
				controle.criar(extensao);
				extensaoTable(); 
				table.repaint();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemover))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfExtensao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdicionar)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfExtensao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnAdicionar))
					.addGap(79)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRemover)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		table = new JTable();
		extensaoTable();
		panel.add(table);
		contentPane.setLayout(gl_contentPane);
	}

	private void extensaoTable() {
		List<Extensao> listExtensao = controle.listarTodos();
		String[] colunas = new String[]{"Id","Descrição"};
		String[][] dados;
		if(listExtensao != null && listExtensao.size() > 0){
			dados = new String[listExtensao.size()][2];
			int i = 0;
			for (Extensao extensao : listExtensao) {
				dados[i][0] = extensao.getId().toString();
				dados[i][1] = extensao.getExtensao();
				i++;
			}
		} else {
			dados = new String[1][2];
		}
		
		DefaultTableModel model = new DefaultTableModel(dados , colunas );
		table.setModel(model);
	}

}
