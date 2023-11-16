package cafeteria.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cafeteria.negocio.Bebida;
import cafeteria.repositorio.repositorioBebida;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Cadastro_Cafe extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField preco;
	private JTable table;
	private DefaultTableModel m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Cafe frame = new Cadastro_Cafe();
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
	public Cadastro_Cafe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_Cafe.class.getResource("/cafeteria/imagens/br/ardoise_SB_05124_1399363593-2.png")));
		setFont(new Font("Agency FB", Font.BOLD, 15));
		setTitle("Cadastra Caf\u00E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(367, 287, 186, 212);
		contentPane.add(scrollPane);
		
		repositorioBebida b = new repositorioBebida();
		ArrayList<Bebida> be = b.all();
		
		

		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome"
			}
		));
		table.setBounds(0, 0, 1, 1);
		contentPane.add(table);
		scrollPane.setViewportView(table);
		
		m = (DefaultTableModel)table.getModel();
		for (int i = 0; i < be.size(); i++) {
			String[] linha = {be.get(i).getNome()};
			m.addRow(linha);
		}
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblNome.setBounds(154, 287, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Agency FB", Font.BOLD, 15));
		lblPreo.setBounds(154, 334, 46, 14);
		contentPane.add(lblPreo);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				repositorioBebida b = new repositorioBebida();
				Bebida v = new Bebida( nome.getText(), Double.parseDouble (preco.getText()));
				b.inseri(v);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
				nome.setText("");
				preco.setText("");
			}
		});
		btnFinalizar.setHorizontalAlignment(SwingConstants.LEFT);
		btnFinalizar.setIcon(new ImageIcon(Cadastro_Cafe.class.getResource("/cafeteria/imagens/br/Visto-icon-1.png")));
		btnFinalizar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnFinalizar.setBounds(10, 510, 143, 40);
		contentPane.add(btnFinalizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_Produto c = new Cadastro_Produto();
				c.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(Cadastro_Cafe.class.getResource("/cafeteria/imagens/br/Voltar-icon-1.png")));
		btnVoltar.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnVoltar.setBounds(551, 510, 123, 40);
		contentPane.add(btnVoltar);
		
		preco = new JTextField();
		preco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				preco.setText(preco.getText().replaceAll("[^0-9 ^.]", ""));
			}
		});
		preco.setBounds(190, 333, 142, 20);
		contentPane.add(preco);
		preco.setColumns(10);
		
		nome = new JTextField();
		nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nome.setText(nome.getText().replaceAll("[^a-z ^A-Z]", ""));
			}
		});
		nome.setBounds(190, 286, 142, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Cadastro_Cafe.class.getResource("/cafeteria/imagens/br/Logo_Dellas_Cafeteria_VFinal_Name-1.png")));
		logo.setBounds(203, 0, 277, 194);
		contentPane.add(logo);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(Cadastro_Cafe.class.getResource("/cafeteria/imagens/br/Background_Xicaras_Cleean-1.png")));
		fundo.setBounds(0, 0, 694, 561);
		contentPane.add(fundo);
	}
}
