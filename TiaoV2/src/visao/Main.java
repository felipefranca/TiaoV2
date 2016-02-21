package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Menu Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 409);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Organiza\u00E7\u00E3o");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegras = new JMenuItem("Regras");
		mntmRegras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new RegraVisao().setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Extens\u00E3o");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ExtensaoVisao().setVisible(true);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		mnNewMenu.add(mntmRegras);
		
		JMenu mnNewMenu_1 = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmRegrasAutomaticas = new JMenuItem("Regras Autom\u00E1ticas");
		mnNewMenu_1.add(mntmRegrasAutomaticas);
		contentPane = new JPanel();
		contentPane.setToolTipText("Principal");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 252, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
